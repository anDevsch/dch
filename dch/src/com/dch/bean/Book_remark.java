package com.dch.bean;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Book_remark implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2268017608905319538L;
	private String id; 
	private User user_id;
	private Book book_id;
	private String context;
	private Date remarkdatetime;
	private int zan;
	private int remark_status;
	private Set<Rema_remark> rema_remarks_id = new HashSet<Rema_remark>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Book getBook_id() {
		return book_id;
	}
	public void setBook_id(Book book_id) {
		this.book_id = book_id;
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
	public Set<Rema_remark> getRema_remarks_id() {
		return rema_remarks_id;
	}
	public void setRema_remarks_id(Set<Rema_remark> rema_remarks_id) {
		this.rema_remarks_id = rema_remarks_id;
	}
	public User getUser_id() {
		return user_id;
	}
	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}
	
	
	
	static public class DateCompare implements Comparator {
        public int compare(Object o1, Object o2) {
        	Book_remark s1 = (Book_remark) o2;
        	Book_remark s2 = (Book_remark) o1;
            int result = s1.getRemarkdatetime().getTime() > s2.getRemarkdatetime().getTime() ? 1 : (s1.getRemarkdatetime().getTime() == s2.getRemarkdatetime().getTime() ? 0 : -1);
            if (result == 0) {
                result = s1.getId().compareTo(s2.getId());
            }
            return result;
        }

    }
	static public class PariseCompare implements Comparator {
        public int compare(Object o1, Object o2) {
        	Book_remark s1 = (Book_remark) o2;
        	Book_remark s2 = (Book_remark) o1;
            int result = s1.getZan() > s2.getZan() ? 1 : (s1.getZan() == s2.getZan() ? 0 : -1);
            if (result == 0) {
                result = s1.getId().compareTo(s2.getId());
            }
            return result;
        }

    }
}
