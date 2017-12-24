package com.dch.action;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Results;

import com.dch.bean.Book;
import com.dch.bean.Order;
import com.dch.bean.User;
import com.dch.dao.OrderDao;
import com.dch.service.BookService;
import com.dch.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Results({})
public class OrderOperateAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Resource 
	private OrderDao orderDao;
	@Resource 
	private UserService userService;
	@Resource 
	private BookService bookService;
	private int struts;
	private String oid;
	@Action(value="OrderOperate")
	public String execute() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		User u=(User)ActionContext.getContext().getSession().get("loginUser");
		try{
			Order order = orderDao.GetOrderById(oid.trim());
			User user = userService.getUserById(u.getId());
			Book book = bookService.GetBookById(order.getBook_id().getId());
			if(struts==0){response.getWriter().write("{state:'error',reason:'错误404',data:''}");return null;}
			switch (struts){
				case 1:
					if(order.getUser_id().equals(user.getId())){
						if(order.getStruts()==0){
							order.setStruts(1);
							orderDao.updateOrder(order);
							response.getWriter().write("{state:'success',reason:'',data:'确认订单成功'}");return null;
						}
					}
					break;
				case 2:
					if(order.getUser_id().equals(user.getId())){
						if(order.getStruts()==1){
							order.setStruts(2);
							orderDao.updateOrder(order);
							response.getWriter().write("{state:'success',reason:'',data:'申请归还成功'}");return null;
						}
					}
					break;
				case 3:
					if(book.getUser_id().getId().equals(user.getId())){
						if(order.getStruts()==2){
							order.setStruts(3);
							orderDao.updateOrder(order);
							book.setStruts(0);
							bookService.updateBook(book);
							response.getWriter().write("{state:'success',reason:'',data:'归还确认成功'}");return null;
						}
					}
					break;
				default:
			}
		}catch(Exception e){response.getWriter().write("{state:'error',reason:'错误404',data:''}");return null;}
		response.getWriter().write("{state:'error',reason:'错误404',data:''}");
		return null;
	}
	public int getStruts() {
		return struts;
	}
	public void setStruts(int struts) {
		this.struts = struts;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
}