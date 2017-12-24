package com.dch.action;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.web.util.HtmlUtils;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.dch.bean.Book;
import com.dch.bean.Dymess;
import com.dch.bean.Order;
import com.dch.bean.User;
import com.dch.service.BookService;
import com.dch.service.DynamicService;
import com.dch.service.MexService;
import com.dch.service.UserService;
import com.sch.download.*;
@Results({})
public class UpShareAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1353761161258695194L;
	private final static String UPLOADDIR = "/upload";
	@Resource
	private UserService userService;
	@Resource
	private DynamicService dynamicService;
	@Resource
	private BookService bookService;
	private String type;
	private String description;
	@Action(value="UpBook")
	public String execute() throws Exception{
		String retjson="";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		String jsonbook=(String)ServletActionContext.getRequest().getSession().getAttribute("upbook");
		User u=(User)ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		if(u==null||u.equals("")){retjson="{state:'error',reason:'请先登录'}";response.getWriter().write(retjson);return null;}
		if(jsonbook==null||jsonbook==""){retjson="{state:'error',reason:'请先上传书籍'}";response.getWriter().write(retjson);return null;}
		//String userid=user.getId();
		Date now = new Date();
		User user = userService.getUserById(u.getId());
		String dir = ServletActionContext.getRequest().getRealPath(UPLOADDIR);
		try {
        	JSONObject json = JSONObject.fromObject(jsonbook);
        	if(json.getString("state").equals("success"))
        	{
        		JSONArray data = json.getJSONArray("data");
                    JSONObject bookinfor = data.getJSONObject(0);
                    //System.out.println(dir);
                    //System.out.println(bookinfor.getString("png"));
                    String filename=DownloadUtils.get(bookinfor.getString("png"),dir);
                    //System.out.println(filename);
                    Book b = new Book();
                    b.setBookname(HtmlUtils.htmlUnescape(bookinfor.getString("title")));
                    b.setAuthor(HtmlUtils.htmlUnescape(bookinfor.getString("author")));
                    b.setBookpng(filename);
    				b.setUser_id(user);
    				b.setType(type);
    				b.setDescription(description);
    				b.setUpdatetime(now);
    				b.setPublicdatetime(HtmlUtils.htmlUnescape(bookinfor.getString("publictime")));
    				//b.setPriace(bookinfor.getInt("priace"));
    				b.setPriace(0);
    				b.setIsbn(HtmlUtils.htmlUnescape(bookinfor.getString("ISBN")));
    				b.setStruts(0);
                    //bookService.addBook(b);
    				//if(user.getBooks_id()==null)user.setBooks_id(new HashSet<Book>());
                    user.getBooks_id().add(b);
                    userService.mergeUser(user);
                    retjson="{state:'success',reason:''}";
                    Dymess dy = new Dymess();
                    dy.setTitle("【"+user.getNickname()+"】上传了书籍&lt;&lt;"+b.getBookname()+"&gt;&gt;");
                    dy.setHeadpng(filename);
                    dy.setContext(description);
                    dy.setCrdatetime(now);
                    	Book bb = bookService.FindBookByPng(filename);
                    	if(bb!=null)dy.setBook_id(bb.getId());
                    	else dy.setBook_id("error");
                    dynamicService.addDymess(dy);
        	}
        	else {retjson="{state:'error',reason:'上传失败，书籍信息错误'}";}
        } catch (JSONException e) {
            e.printStackTrace();
        }
		
		response.getWriter().write(retjson);
		System.out.println(retjson);
		return null;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
}
