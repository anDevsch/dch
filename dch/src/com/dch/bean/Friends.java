package com.dch.bean;

import java.io.Serializable;

public class Friends implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5646461284675495320L;
	private String id;
	private User from_id;
	private User to_id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getFrom_id() {
		return from_id;
	}
	public void setFrom_id(User from_id) {
		this.from_id = from_id;
	}
	public User getTo_id() {
		return to_id;
	}
	public void setTo_id(User to_id) {
		this.to_id = to_id;
	}
	
}
