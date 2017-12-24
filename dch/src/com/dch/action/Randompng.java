package com.dch.action;

import java.io.ByteArrayInputStream;

import org.springframework.context.annotation.Scope;
import com.dch.servlet.RandomNumUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")//ÿ�������½�һ��Action,Ĭ��Ϊ����ģʽ,����һ��Action
public class Randompng extends ActionSupport{
	private ByteArrayInputStream inputStream;

	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	} 
	
	public String execute() throws Exception{
		RandomNumUtil rdnu=RandomNumUtil.Instance(); 
		this.setInputStream(rdnu.getImage());
		ActionContext.getContext().getSession().put("random", rdnu.getStr());
		return SUCCESS;
	}
}
