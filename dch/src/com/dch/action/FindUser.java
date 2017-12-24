package com.dch.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dch.bean.Book;
import com.dch.bean.User;
import com.dch.service.BookService;
import com.dch.service.UserService;
import com.dch.viewbean.Grobe;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FindUser extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2414400170744314040L;
	private UserService userService;
	private BookService bookService;
	private List<Book> rebooks;
	private User user;
	public String execute() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String id="";
		id = request.getParameter("nid");
		if(id!=null&&id!=""){
			User user = userService.getUserById(id);
			if(user!=null){
				setUser(user);
				Grobe g = new Grobe();
				List<Book> bos = bookService.clifybook("where user_id='"+user.getId()+"' order by updatetime desc",1,100,g);
				setRebooks(bos);
				return SUCCESS;
			}
		}
			request.setAttribute("text", "查找用户失败，请刷新后重试。。。");
			request.setAttribute("return", "history.go(-1)");
			return "text";
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	public List<Book> getRebooks() {
		return rebooks;
	}
	public void setRebooks(List<Book> rebooks) {
		this.rebooks = rebooks;
	}

}
