package com.dch.action;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.dch.bean.Book;
import com.dch.bean.Dymess;
import com.dch.bean.User;
import com.dch.service.DynamicService;
import com.dch.service.MexService;
import com.dch.service.UserService;
import com.dch.viewbean.Grobe;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Results({@Result(name = "success", location = "/webpage/user/user.jsp"),
	@Result(name = "text", location = "/text.jsp")})
public class MyuserAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4853284808296724894L;
	@Resource
	private UserService userService;
	@Resource
	private MexService mexService;
	@Resource 
	private DynamicService dynamicService;

	private Grobe grobe;
	private int page;
	private List<Dymess> dynas;
	private User user;
	private List<Book> sharebooks;
	private List<Book> borrbooks;
	private List<User> foxusers;
	@Action(value="myUser")
	public String execute() throws Exception{
		int spite = 5;
		if(page<=0)page=1;
		if(ActionContext.getContext().getSession().get("loginUser")!=null){
			User user=(User)ActionContext.getContext().getSession().get("loginUser");
			//System.out.println(user.getAge());
			User nuser = userService.getUserById(user.getId());
			setUser(nuser);
			setFoxusers(userService.top7user());
			List<Book> sharebook = new ArrayList<Book>();
			sharebook.addAll(nuser.getBooks_id());
			setSharebooks(sharebook);
			setBorrbooks(mexService.FindOrderByUser(nuser));
			//¶¯Ì¬
			Grobe g = new Grobe();
			List<Dymess> dys = this.dynamicService.clifydymess("where title like '%"+nuser.getNickname()+"%' order by crdatetime desc", page, spite, g);
			int Total = g.getTotal();
			g.setCurr(page);
			g.setPage((Total%spite>0?((Total/spite)+1):(Total/spite)));
			setGrobe(g);
			setDynas(dys);
			/**end dy**/
			return SUCCESS;
		}else{
			HttpServletRequest request=ServletActionContext.getRequest();
			request.setAttribute("text", "µÇÂ¼³¬Ê±£¬ÇëÖØÐÂµÇÂ½¡£");
			request.setAttribute("return", "location.href = 'Tologin'");
			return "text";
		}
		
		
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getFoxusers() {
		return foxusers;
	}
	public void setFoxusers(List<User> foxusers) {
		this.foxusers = foxusers;
	}
	public List<Book> getSharebooks() {
		return sharebooks;
	}
	public void setSharebooks(List<Book> sharebooks) {
		this.sharebooks = sharebooks;
	}
	public List<Book> getBorrbooks() {
		return borrbooks;
	}
	public void setBorrbooks(List<Book> borrbooks) {
		this.borrbooks = borrbooks;
	}
	public List<Dymess> getDynas() {
		return dynas;
	}
	public void setDynas(List<Dymess> dynas) {
		this.dynas = dynas;
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
