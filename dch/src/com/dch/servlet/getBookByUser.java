package com.dch.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.dch.bean.Book;
import com.dch.bean.User;
import com.dch.service.BookService;
import com.dch.service.UserService;
import com.dch.viewbean.Grobe;
import com.opensymphony.xwork2.ActionSupport;

public class getBookByUser extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5211904376709526027L;
	private String nnid;
	private List<Book> ubooks;
	private UserService userService;
	private BookService bookService;
	public String execute() throws Exception{
		User uuid = userService.getUserById(nnid);
		Grobe g = new Grobe();
		List<Book> bos = bookService.clifybook("where user_id='"+uuid.getId()+"' order by updatetime desc",1,100,g);
		setUbooks(bos);
		/*
		Book book = bookService.GetBookById("");
		//System.out.println(books_id);
		if(book==null)return null;
		HttpServletResponse response = ServletActionContext.getResponse();
		  response.setCharacterEncoding("utf-8");
		  try {
			  String vsr = "<input name=\"bookpng\" value=\""+book.getBookpng()+"\" type=\"hidden\"/><br>";
			  vsr += "<input name=\"bid\" value=\""+book.getId()+"\" type=\"hidden\"/><br>";
			  vsr += "<input name=\"bookname\" value=\""+book.getBookname()+"\" type=\"hidden\"/><br>";
			  vsr += "<input name=\"author\" value=\""+book.getAuthor()+"\" type=\"hidden\"/><br>";
			  vsr += "<input name=\"praise\" value=\""+book.getPriace()+"\" type=\"hidden\"/><br>";
			  vsr += "<input name=\"desc\" value=\""+book.getDescription()+"\" type=\"hidden\"/><br>";
			response.getWriter().write(vsr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		return SUCCESS;
	}
	public List<Book> getUbooks() {
		return ubooks;
	}
	public void setUbooks(List<Book> ubooks) {
		this.ubooks = ubooks;
	}
	public String getNnid() {
		return nnid;
	}
	public void setNnid(String nnid) {
		this.nnid = nnid;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
}
