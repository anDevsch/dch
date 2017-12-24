package com.dch.action;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.dch.bean.Book;
import com.dch.bean.User;
import com.dch.service.UserService;
import com.dch.servlet.regexMatch;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sch.getstring.getString;

@Results({})
public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Resource 
	private UserService userService;
	
	
	private String username;
	private String password;
	private String random;
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRandom() {
		return random;
	}
	public void setRandom(String random) {
		this.random = random;
	}
	
	private User user;
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	private Book book;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Action(value="Login")
	public String execute() throws Exception{
		if(check()){
			User user=this.userService.login(username,password);
			//System.out.println(user.getPhonenumber());
			if(user!=null)
			{
				Map request = (Map) ActionContext.getContext().get("request");
				//List<Book> books=this.userService.top10book();
				//request.put("books", books);
				ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write("true");
				return null;
			}
			else 
			{
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write("用户名或密码错误");
				String dd=(String)ActionContext.getContext().getSession().get("random");
				System.out.println(dd);
				return null;
			}
		
		}
		else return null;
	}
	public Boolean check() {
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			String rand=(String)ActionContext.getContext().getSession().get("random");
			if(rand.equalsIgnoreCase(random)){
				if(username.equals("")){
					response.getWriter().write("用户名不能为空");
					return false;
				}
				if(password.equals("")){
					response.getWriter().write("密码不能为空");
					return false;
				}
				if(!regexMatch.MimaisRight(password)||!regexMatch.MimaisRight(username)){
					response.getWriter().write("不能包含特殊字符");
					return false;
				}
			}
			else{
				response.getWriter().write("验证码错误");
				return false;
			}
		}catch(Exception e){
			return false;
		}
		return true;
	}
}
