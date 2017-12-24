package com.dch.action;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import com.dch.bean.Book;
import com.dch.bean.User;
import com.dch.service.BookService;
import com.dch.service.UserService;
import com.dch.viewbean.Grobe;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;  
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Results({@Result(name = "success", location = "/webpage/index/index.jsp"),  
    	  @Result(name = "error", location = "/Tologin")})
public class IndexAction  extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8336426677984356376L;
	@Resource 
	private BookService bookService;
	@Resource 
	private UserService userService;
	private List<Book> rebooks;
	private List<Book> cebooks;
	private List<User> users;
	@Action(value="Index")
	public String execute() throws Exception{
		List<User> us = this.userService.top7user();
		setUsers(us);
		Grobe g = new Grobe();
		List<Book> bos = bookService.clifybook("order by updatetime desc",1,4,g);
		setRebooks(bos);
		List<Book> books = bookService.clifybook("order by priace desc",1,7,g);
		List<Book> cen =   bookService.clifybook("",1,4,g);
		
		setCebooks(cen);
		Map request = (Map) ActionContext.getContext().get("request");
		if(books!=null&&books.size()>0)
		{
			request.put("books", books);
			return SUCCESS;
		}else
		return "success";
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Book> getRebooks() {
		return rebooks;
	}
	public void setRebooks(List<Book> rebooks) {
		this.rebooks = rebooks;
	}
	public List<Book> getCebooks() {
		return cebooks;
	}
	public void setCebooks(List<Book> cebooks) {
		this.cebooks = cebooks;
	}
}