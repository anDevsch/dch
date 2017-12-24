package com.dch.action;


import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.dch.bean.Dymess;
import com.dch.bean.User;
import com.dch.service.BookService;
import com.dch.service.DynamicService;
import com.dch.service.UserService;
import com.dch.viewbean.Grobe;
import com.opensymphony.xwork2.ActionSupport;

@Results({@Result(name = "success", location = "/webpage/dynamic/dynamic.jsp"),  
	  @Result(name = "text", location = "/text.jsp")})
public class DynamicAction  extends ActionSupport{
	@Resource 
	private BookService bookService;
	@Resource 
	private UserService userService;
	@Resource 
	private DynamicService dynamicService;
	
	private Grobe grobe;
	private int page;
	private List<Dymess> dynas;
	private List<User> users;
	@Action(value="Dynamic")
	public String execute() throws Exception{
		if(page<=0)page=1;
		int spite = 5;
		Grobe g = new Grobe();
		List<Dymess> dys = this.dynamicService.clifydymess("order by crdatetime desc", page, 5, g);
		
		int Total = g.getTotal();
		g.setCurr(page);
		g.setPage((Total%spite>0?((Total/spite)+1):(Total/spite)));
		setGrobe(g);
		setDynas(dys);
		List<User> us = this.userService.top7user();
		setUsers(us);
		return SUCCESS;
	}
	public List<Dymess> getDynas() {
		return dynas;
	}
	public void setDynas(List<Dymess> dynas) {
		this.dynas = dynas;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public Grobe getGrobe() {
		return grobe;
	}
	public void setGrobe(Grobe grobe) {
		this.grobe = grobe;
	}

}
