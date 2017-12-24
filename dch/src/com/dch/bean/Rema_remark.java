package com.dch.bean;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

public class Rema_remark implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -457576873069596973L;
	private String id; 
	private String user_id;
	private Book_remark remark_id;
	private String context;
	private Date remarkdatetime;
	private int zan;
	private int remark_status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Book_remark getRemark_id() {
		return remark_id;
	}
	public void setRemark_id(Book_remark remark_id) {
		this.remark_id = remark_id;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Date getRemarkdatetime() {
		return remarkdatetime;
	}
	public void setRemarkdatetime(Date remarkdatetime) {
		this.remarkdatetime = remarkdatetime;
	}
	public int getZan() {
		return zan;
	}
	public void setZan(int zan) {
		this.zan = zan;
	}
	public int getRemark_status() {
		return remark_status;
	}
	public void setRemark_status(int remark_status) {
		this.remark_status = remark_status;
	}
	
	
	
	
	
	
	
	
	
	
	static public class DateCompare implements Comparator {
        public int compare(Object o1, Object o2) {
        	Rema_remark s1 = (Rema_remark) o1;
        	Rema_remark s2 = (Rema_remark) o2;
            int result = s1.getRemarkdatetime().getTime() > s2.getRemarkdatetime().getTime() ? 1 : (s1.getRemarkdatetime().getTime() == s2.getRemarkdatetime().getTime() ? 0 : -1);
            if (result == 0) {
                result = s1.getId().compareTo(s2.getId());
            }
            return result;
        }

    }
}
