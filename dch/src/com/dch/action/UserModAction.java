package com.dch.action;

import java.io.File;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.dch.bean.User;
import com.dch.service.UserService;
import com.dch.servlet.UppngHelp;
import com.dch.servlet.regexMatch;
import com.dch.viewbean.UserMod;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Results({@Result(name = "text", location = "/text.jsp")})
public class UserModAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	@Resource
	private UserService userService;
	
	private UserMod userMod;
	
	private File headpng;
	public File getHeadpng() {
		return headpng;
	}
	public void setHeadpng(File headpng) {
		this.headpng = headpng;
	}
	
	@Action(value="UserMod")
	public String execute() throws Exception{
		if(check()){
			//Map request=(Map)ActionContext.getContext().get("request");
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			request.setCharacterEncoding("utf-8");  
	        response.setContentType("text/html;charset=utf-8");  
	        
	        String path = request.getSession().getServletContext().getRealPath("/headpng");//保存的服务器地址  
	        //System.out.println(path);
	        String newFileName = "";//文件名称
	        if(headpng!=null){
		        newFileName = UppngHelp.uploadFile(headpng,path);
		        //System.out.println(">>>have");
	        }
			User user = userService.getUserById(userMod.getUserflag());
	        if(newFileName!=null&&!newFileName.equals("")){
				user.setHeadpng(newFileName);
				System.out.println(">>>update headpng name = "+user.getNickname()+"filename = "+newFileName);
	        }
			user.setAge(userMod.getAge());
			user.setEmail(userMod.getEmail());
			user.setClassnumber(userMod.getClassnumber());
			user.setSign(userMod.getSign());
			if(this.userService.mergeUser(user))
			{
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write("true");
				return null;
			}
			else{
				//HttpServletResponse response = ServletActionContext.getResponse();
				request.setAttribute("text", "404");
				request.setAttribute("return", "location.href = 'myUser'");
				return "text";
			}
		}
		else return null;
	}
	public Boolean check() {
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			if(!regexMatch.AgeisRight(userMod.getAge())){
				response.getWriter().write("年龄不正确");
				return false;
			}
			if(!regexMatch.IdisRight(userMod.getUserflag())){
				response.getWriter().write("异常错误，请刷新重试");
				return false;
			}
			if(!userMod.getEmail().equals("")){
				if(!regexMatch.EmailisRight(userMod.getEmail())){
					response.getWriter().write("邮箱格式不正确");
					return false;
				}
			}
			if(!userMod.getClassnumber().equals("")){
				if(!regexMatch.QQisRight(userMod.getClassnumber())){
					response.getWriter().write("QQ号格式不正确");
					return false;
				}
			}
			if(!userMod.getSign().equals("")){
				if(!regexMatch.StringisRight(userMod.getSign())){
					response.getWriter().write("个性签名包含特殊字符");
					return false;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public UserMod getUserMod() {
		return userMod;
	}
	public void setUserMod(UserMod userMod) {
		this.userMod = userMod;
	}
	

}
