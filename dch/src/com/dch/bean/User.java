package com.dch.bean;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;




public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3405351384617627689L;
	private String id; 
	private String phonenumber;
	private String password;
	private String nickname;
	private String sex;
	private Integer age;
	private String headpng;
	private String grade;
	private String classnumber;
	private String email;
	private String sign;
	private Date datetime;
	private Integer struts;
	private Integer borrowdata;
	private Set<Book> books_id = new HashSet<Book>();
	private Set<Friends> friend_from_id = new HashSet<Friends>();
	private Set<Friends> friend_to_id = new HashSet<Friends>();
	public String getId (){
		return id;
	}
	public void setId(String id){
		this.id=id;
	}
	public String getPhonenumber(){
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber){
		this.phonenumber=phonenumber;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getNickname(){
		return nickname;
	}
	public void setNickname(String nickname){
		this.nickname=nickname;
	}
	public String getSex(){
		return sex;
	}
	public void setSex(String sex){
		this.sex=sex;
	}
	public Integer getAge(){
		return age;
	}
	public void setAge(Integer age){
		this.age=age;
	}
	public String getHeadpng(){
		return headpng;
	}
	public void setHeadpng(String headpng){
		this.headpng=headpng;
	}
	public String getGrade(){
		return grade;
	}
	public void setGrade(String grade){
		this.grade=grade;
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email=email;
	}
	public String getSign(){
		return sign;
	}
	public void setSign(String sign){
		this.sign=sign;
	}
	public Date getDatetime(){
		return datetime;
	}
	public void setDatetime(Date datetime){
		this.datetime=datetime;
	}
	public String getClassnumber() {
		return classnumber;
	}
	public void setClassnumber(String classnumber) {
		this.classnumber = classnumber;
	}
	public Set<Book> getBooks_id() {
		return books_id;
	}
	public void setBooks_id(Set<Book> books_id) {
		this.books_id = books_id;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Set<Friends> getFriend_from_id() {
		return friend_from_id;
	}
	public void setFriend_from_id(Set<Friends> friend_from_id) {
		this.friend_from_id = friend_from_id;
	}



















	public Set<Friends> getFriend_to_id() {
		return friend_to_id;
	}
	public void setFriend_to_id(Set<Friends> friend_to_id) {
		this.friend_to_id = friend_to_id;
	}



















	public Integer getStruts() {
		return struts;
	}
	public void setStruts(Integer struts) {
		this.struts = struts;
	}



















	public Integer getBorrowdata() {
		return borrowdata;
	}
	public void setBorrowdata(Integer borrowdata) {
		this.borrowdata = borrowdata;
	}



















	static public class PariseCompare implements Comparator {
        public int compare(Object o1, Object o2) {
        	User s1 = (User) o2;
        	User s2 = (User) o1;
            int result = s1.getDatetime().getTime() > s2.getDatetime().getTime() ? 1 : (s1.getDatetime().getTime() == s2.getDatetime().getTime() ? 0 : -1);
            if (result == 0) {
                result = s1.getId().compareTo(s2.getId());
            }
            return result;
        }

    }
}
