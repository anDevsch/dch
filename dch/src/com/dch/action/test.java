package com.dch.action;

import com.dch.bean.Book;
import com.dch.bean.User;
import com.dch.service.BookService;
import com.dch.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.sch.download.DownloadUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class test extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3304644846156332534L;
	private UserService userService;
	private BookService bookService;
	private String time;
	public String execute() throws Exception{
		String ff=null;
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 try
		 {
			  Date date = format.parse(this.time);
			  ff = TimeFormat(date);
			  System.out.println("�������ڵĲ�ࣺ" + ff);
			  setTime(ff);
			  HttpServletResponse response = ServletActionContext.getResponse();
			  response.setCharacterEncoding("utf-8");
			  response.getWriter().write(ff);
		 } catch (ParseException e) {
		  	  e.printStackTrace();
		 }
		return null;
	}
	
	public static String TimeFormat(Date date1)
	 {
		int years=0,months=0,days=0,hours=0,minutes=0;
		 Calendar cal1 = Calendar.getInstance();
		 cal1.setTime(date1);
		 Calendar cal2 = Calendar.getInstance();
		 cal2.setTime(new Date());
		 years = cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR);
		 months =cal2.get(Calendar.MONTH) - cal1.get(Calendar.MONTH);
		 days = cal2.get(Calendar.DAY_OF_YEAR) - cal1.get(Calendar.DAY_OF_YEAR);
		 hours = cal2.get(Calendar.HOUR_OF_DAY) - cal1.get(Calendar.HOUR_OF_DAY);
		 minutes = cal2.get(Calendar.MINUTE) - cal1.get(Calendar.MINUTE);
		 if(years>0)return years+"��ǰ";
		 if(months>0)return months+"��ǰ";
		 if(days>0)return days+"��ǰ";
		 if(hours>0)return hours+"Сʱǰ";
		 if(minutes>0)return minutes+"����ǰ";
		 return "�ո�";
	 }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public BookService getBookService() {
		return bookService;
	}


	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
