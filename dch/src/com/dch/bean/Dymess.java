package com.dch.bean;

import java.util.Date;

public class Dymess {
	private String id; 
	private String title;
	private String headpng;
	private String context;
	private Date crdatetime;
	private String book_id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHeadpng() {
		return headpng;
	}
	public void setHeadpng(String headpng) {
		this.headpng = headpng;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Date getCrdatetime() {
		return crdatetime;
	}
	public void setCrdatetime(Date crdatetime) {
		this.crdatetime = crdatetime;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
}
