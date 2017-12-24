package com.dch.action;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.dch.bean.Book;
import com.dch.service.BookService;
import com.dch.viewbean.Grobe;
import com.opensymphony.xwork2.ActionSupport;

@Results({@Result(name = "success", location = "/webpage/classify/classify.jsp"),  
	  @Result(name = "text", location = "/text.jsp")})
public class ClassifyAction  extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5194235724557544650L;
	private final static String src = "/config";
	@Resource 
	private BookService bookService;
	
	private List<Book> books;
	
	private int cify;
	private int page;
	private Grobe grobe;
	private String fen;
	@Action(value="Classify")
	public String execute() throws Exception{
		int spite = 5;
		String dir = ServletActionContext.getRequest().getRealPath(src);
		InputStream is = new BufferedInputStream(new FileInputStream(dir+"/config.properties"));
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");
        Properties properties = new Properties();
        try {
            properties.load(isr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String classify = properties.getProperty(cify+"");
        if(is != null)is.close();
		if(page==0){page = 1;}
		String where = "order by updatetime desc";setFen("нч");
		if(classify!=null&&!classify.equals("")){where = "where type='"+classify.trim()+"' order by updatetime desc";setFen(classify.trim());}
		Grobe g = new Grobe();
		List<Book> bos = bookService.clifybook(where,page,spite,g);
		
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