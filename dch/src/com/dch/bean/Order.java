package com.dch.bean;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4533600746937474361L;
	private String id;
	private String user_id;
	private Book book_id;
	private Date orderdatetime;
	private Date retdatetime;
	private Integer struts;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Book getBook_id() {
		return book_id;
	}
	public void setBook_id(Book book_id) {
		this.book_id = book_id;
	}
	public Date getOrderdatetime() {
		return orderdatetime;
	}
	public void setOrderdatetime(Date orderdatetime) {
		this.orderdatetime = orderdatetime;
	}
	public Integer getStruts() {
		return struts;
	}
	public void setStruts(Integer struts) {
		this.struts = struts;
	}
	public Date getRetdatetime() {
		return retdatetime;
	}
	public void setRetdatetime(Date retdatetime) {
		this.retdatetime = retdatetime;
	}
}
