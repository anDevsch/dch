package com.dch.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Results;

import com.dch.bean.Book;
import com.dch.bean.User;
import com.dch.service.BookService;
import com.dch.service.UserService;
import com.opensymphony.xwork2.ActionContext;

@Results({})
public class PraiseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 158266375863401727L;
	@Resource 
	private BookService bookService;
	@Resource 
	private UserService userService;
	private String bid;
	@Action(value="Praise")
	public String execute() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		User u=(User)ActionContext.getContext().getSession().get("loginUser");
		try{
			if(u==null){response.getWriter().write("{state:'error',reason:'请先登录',data:''}");return null;}
			String flag = (String)ActionContext.getContext().getSession().get(bid.trim());
			if(flag==null||flag==""){
				ServletActionContext.getRequest().getSession().setAttribute(bid.trim(), "true");
				Book b = bookService.GetBookById(bid.trim());
				b.setPriace(b.getPriace()+1);
				bookService.updateBook(b);
				response.getWriter().write("{state:'success',reason:'',data:'赞成功'}");return null;}
			else if("true".equals(flag)){response.getWriter().write("{state:'error',reason:'您已经赞过了',data:''}");return null;}
		}catch(Exception e){response.getWriter().write("{state:'error',reason:'错误404',data:''}");}
		return null;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}

}
