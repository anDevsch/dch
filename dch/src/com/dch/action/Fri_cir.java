package com.dch.action;

import java.util.List;

import com.dch.bean.User;
import com.dch.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class Fri_cir  extends ActionSupport{
	private List<User> foxusers;
	private UserService userService;
	public String execute() throws Exception{
		List<User> user = userService.top7user();
		setFoxusers(user);
		return SUCCESS;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public List<User> getFoxusers() {
		return foxusers;
	}
	public void setFoxusers(List<User> foxusers) {
		this.foxusers = foxusers;
	}
}
