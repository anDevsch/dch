package com.dch.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.dch.bean.Book;
import com.dch.service.BookService;
import com.dch.viewbean.Grobe;

@Results({@Result(name = "success", location = "/webpage/search/search.jsp"),  
	  @Result(name = "error", location = "/Tologin")})
public class SearchAction {
	@Resource 
	private BookService bookService;
	private List<Book> books;
	private String sear;
	private int page;
	private Grobe grobe;
	@Action(value="Search")
	public String execute() throws Exception{
		/*
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		String gg = java.net.URLDecoder.decode(sear,"UTF-8");
		String sssdd = request.getParameter("sear");
		String s = new String(sssdd.getBytes("iso-8859-1"));
		*/
		//sear = s;
		if(sear==null)sear="";
		if(page<=0)page=1;
		int spite = 5;
		Grobe g = new Grobe();
		List<Book> bos = bookService.clifybook("where bookname like '%"+sear+"%' or author like '%"+sear+"%' order by updatetime desc",page,spite,g);
		setBooks(bos);
		
		int Total = g.getTotal();
		g.setDesc(sear);
		g.setCurr(page);
		g.setPage((Total%spite>0?((Total/spite)+1):(Total/spite)));
		setGrobe(g);
		return "success";
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getSear() {
		return sear;
	}
	public void setSear(String sear) {
		this.sear = sear;
	}
	public Grobe getGrobe() {
		return grobe;
	}
	public void setGrobe(Grobe grobe) {
		this.grobe = grobe;
	}

}
