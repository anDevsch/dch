package com.dch.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ToPath extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8153149062592253786L;
	public String tosharepage(){
		return SUCCESS;
	}
	public String tologinpage(){
		return SUCCESS;
	}
	public String toindexpage(){
		return SUCCESS;
	}
	public String toregisterpage(){
		return SUCCESS;
	}
	public String touserpage(){
		return SUCCESS;
	}
	public String tofriends_circlepage(){
		return SUCCESS;
	}
	public String toorderbookpage(){
		return SUCCESS;
	}
	public String toaboutpage(){
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	private String time;
	public String togetTimepage(){
		String ff=null;
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 try
		 {
			  Date date = format.parse(this.time);
			  ff = TimeFormat(date);
			  //System.out.println("两个日期的差距：" + ff);
			  setTime(ff);
			  HttpServletResponse response = ServletActionContext.getResponse();
			  response.setCharacterEncoding("utf-8");
			  try {
				response.getWriter().write(ff);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		 if(years>0)return years+"年前";
		 if(months>0)return months+"月前";
		 if(days>0)return days+"天前";
		 if(hours>0)return hours+"小时前";
		 if(minutes>0)return minutes+"分钟前";
		 return "刚刚";
	 }
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
