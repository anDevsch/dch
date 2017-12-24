package com.dch.bean;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7029409818398148566L;
	private String id; 
	private String bookname;
	private String author;
	private String bookpng;
	private User user_id;
	private String type;
	private String description;
	private Date updatetime;
	private String publicdatetime;
	private Integer priace;
	private String isbn;
	private Integer struts;
	private Set<Order> orders_id = new HashSet<Order>();
	private Set<Book_remark> book_remarks_id = new HashSet<Book_remark>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBookpng() {
		return bookpng;
	}
	public void setBookpng(String bookpng) {
		this.bookpng = bookpng;
	}
	public User getUser_id() {
		return user_id;
	}
	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public Integer getPriace() {
		return priace;
	}
	public void setPriace(Integer priace) {
		this.priace = priace;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPublicdatetime() {
		return publicdatetime;
	}
	public void setPublicdatetime(String publicdatetime) {
		this.publicdatetime = publicdatetime;
	}
	public Set<Book_remark> getBook_remarks_id() {
		return book_remarks_id;
	}
	public void setBook_remarks_id(Set<Book_remark> book_remarks_id) {
		this.book_remarks_id = book_remarks_id;
	}
	
	
	
	public Integer getStruts() {
		return struts;
	}
	public void setStruts(Integer struts) {
		this.struts = struts;
	}




	public Set<Order> getOrders_id() {
		return orders_id;
	}
	public void setOrders_id(Set<Order> orders_id) {
		this.orders_id = orders_id;
	}




	static public class PariseCompare implements Comparator {
        public int compare(Object o1, Object o2) {
        	Book s1 = (Book) o2;
        	Book s2 = (Book) o1;
            int result = s1.getUpdatetime().getTime() > s2.getUpdatetime().getTime() ? 1 : (s1.getUpdatetime().getTime() == s2.getUpdatetime().getTime() ? 0 : -1);
            if (result == 0) {
                result = s1.getId().compareTo(s2.getId());
            }
            return result;
        }

    }
}
