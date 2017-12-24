package com.dch.action;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.dch.bean.User;
import com.dch.service.UserService;
import com.dch.servlet.regexMatch;
import com.dch.viewbean.VBReg;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Results({@Result(name = "text", location = "/text.jsp")})
public class RegiAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	@Resource
	private UserService userService;
	
	private VBReg vbreg;
	public void setVbreg(VBReg vbreg) {
		this.vbreg = vbreg;
	}
	public VBReg getVbreg(){
		return vbreg;
	}
	@Action(value="Register")
	public String execute() throws Exception{
		if(check()){
			User user = new User();
			user.setPhonenumber(vbreg.getPhonenumber());
			user.setPassword(vbreg.getPassword());
			user.setSex(vbreg.getSex());
			user.setGrade(vbreg.getGrade());
			user.setNickname(vbreg.getNickname());
			user.setHeadpng("head.jpg");
			user.setAge(10);
			user.setSign("个性签名");
			user.setDatetime(new Date());
			user.setStruts(0);
			if(this.userService.addUser(user))
			{
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write("true");
				return null;
			}
			else{
				Map request=(Map)ActionContext.getContext().get("request");
				//HttpServletResponse response = ServletActionContext.getResponse();
				request.put("text", "404");
				request.put("return", "location.href = 'ToRegister'");
				return "text";
			}
		}
		else return null;
	}
	public Boolean check() {
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			String rand=(String)ActionContext.getContext().getSession().get("random");
			if(rand.equalsIgnoreCase(vbreg.getYan())){
				if(vbreg.getPhonenumber().equals("")){
					response.getWriter().write("请输入手机号");
					return false;
				}
				if(vbreg.getPassword().equals("")){
					response.getWriter().write("请输入密码");
					return false;
				}
				if(vbreg.getNickname().equals("")){
					response.getWriter().write("请输入姓名");
					return false;
				}
				if(vbreg.getGrade().equals("")){
					response.getWriter().write("请输入班级");
					return false;
				}
				if(vbreg.getSex()==null||vbreg.getSex().equals("")){
					response.getWriter().write("请输入性别");
					return false;
				}
				if(!vbreg.getPassword().equals(vbreg.getPassword_a())){
					response.getWriter().write("两次密码输入不一致");
					return false;
				}
				if(!regexMatch.PhoneisRight(vbreg.getPhonenumber())){
					response.getWriter().write("手机号格式不正确");
					return false;
				}
				if(!regexMatch.MimaisRight(vbreg.getPassword())){
					response.getWriter().write("密码包含特殊字符");
					return false;
				}
			}
			else{
				response.getWriter().write("验证码错误");
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

}
