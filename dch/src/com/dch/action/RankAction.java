package com.dch.action;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.dch.bean.Book;
import com.dch.service.BookService;
import com.dch.viewbean.Grobe;
import com.opensymphony.xwork2.ActionSupport;

@Results({@Result(name = "success", location = "/webpage/rank/rank.jsp"),  
	  @Result(name = "text", location = "/text.jsp")})
public class RankAction  extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5194235724557544650L;
	private final static String src = "/config";
	@Resource 
	private BookService bookService;
	
	private List<Book> books;
	private Grobe grobe;
	private int cify;
	private int page;
	private String fen;
	@Action(value="Rank")
	public String execute() throws Exception{
		int spite = 5;
		if(page==0){page = 1;}
		String where = "";
		if(cify == 0){where = "order by updatetime desc";setFen("最新书籍");}
		else {where = "order by priace desc";setFen("推荐书籍");}
		Grobe g = new Grobe();
		List<Book> bos = bookService.clifybook(where,page,5,g);
		
		int Total = g.getTotal();
		g.setCify(cify);
		g.setCurr(page);
		g.setPage((Total%spite>0?((Total/spite)+1):(Total/spite)));
		setGrobe(g);
		setBooks(bos);
		return SUCCESS;
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
	public int getCify() {
		return cify;
	}
	public void setCify(int cify) {
		this.cify = cify;
	}
	public String getFen() {
		return fen;
	}
	public void setFen(String fen) {
		this.fen = fen;
	}
	public Grobe getGrobe() {
		return grobe;
	}
	public void setGrobe(Grobe grobe) {
		this.grobe = grobe;
	}
}