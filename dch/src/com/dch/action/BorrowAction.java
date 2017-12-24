package com.dch.action;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Results;

import com.dch.bean.Book;
import com.dch.bean.Order;
import com.dch.bean.User;
import com.dch.service.BookService;
import com.dch.service.UserService;
import com.opensymphony.xwork2.ActionContext;

@Results({})
public class BorrowAction {
	@Resource 
	private BookService bookService;
	@Resource 
	private UserService userService;
	private String bookborrid;
	
	@Action(value="Borrow")
	public String execute() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		Date date = new Date();
		Calendar calendar = new GregorianCalendar(); 
	    calendar.setTime(date);
	    calendar.add(calendar.MONTH, 1);
		Book book = bookService.GetBookById(bookborrid);
		if(book.getStruts()!=0){response.getWriter().write("{state:'error',reason:'����Ŀǰ���������',data:''}");return null;}
		User u=(User)ActionContext.getContext().getSession().get("loginUser");
		if(u.getId().equals(book.getUser_id().getId())){response.getWriter().write("{state:'error',reason:'���ܽ����Լ�����',data:''}");return null;}
		try{
			User user = userService.getUserById(u.getId());
			book.setStruts(1);
			Order order = new Order();
			order.setUser_id(user.getId());
			order.setBook_id(book);
			order.setOrderdatetime(date);
			order.setRetdatetime(calendar.getTime());
			order.setStruts(0);
			Set<Order> o = new HashSet<Order>();
			o.add(order);
			book.setOrders_id(o);
			bookService.mergeBook(book);
			response.getWriter().write("{state:'success',reason:'',data:'�����ɹ�\n��ͨ����ϵ��ʽ��ϵ��ĳ����ߣ�\n������"+book.getUser_id().getNickname()+"\n�绰��"+book.getUser_id().getPhonenumber()+"'}");
		}catch(Exception e){response.getWriter().write("{state:'error',reason:'����404',data:''}");}
		return null;
	}

	public String getBookborrid() {
		return bookborrid;
	}

	public void setBookborrid(String bookborrid) {
		this.bookborrid = bookborrid;
	}
}
