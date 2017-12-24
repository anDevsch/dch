package com.dch.action;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
@Results({@Result(name = "success", location = "/webpage/login/login.jsp"),
	@Result(name = "text", location = "/text.jsp")})
public class ExitAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2623834034229896125L;
	@Action(value="Exit")
	public String execute() throws Exception{
		if(ActionContext.getContext().getSession().get("loginUser")!=null)
			ActionContext.getContext().getSession().put("loginUser",null);
		else {
			Map request=(Map)ActionContext.getContext().get("request");
			//HttpServletResponse response = ServletActionContext.getResponse();
			request.put("text", "您已经成功退出登录，无需再次退出。");
			request.put("return", "location.href = 'Tologin'");
			return "text";
		}
		return SUCCESS;
	}
}
