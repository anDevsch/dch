package com.dch.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.dch.bean.User;
@Repository
public class UserDao{
	@Resource(name="hibernateTemplate")   
    private HibernateTemplate hibernateTemplate;
    public User login(String username,String password){
    	String hql= "from User where phonenumber=? and password=?";
    	@SuppressWarnings("unchecked")
		List<User> user = (List<User>)this.hibernateTemplate.find(hql,username,password);
    	if(user!=null&&user.size()>0)
    	{
    		return user.get(0);
    	}
    	else{
    		return null;
    	}
    }
    public boolean addUser(User user){
    	this.hibernateTemplate.save(user);
    	return true;
    }
    public boolean mergeUser(User user){
    	this.hibernateTemplate.merge(user);
    	return true;
    }
    public boolean updateUser(User user){
    	this.hibernateTemplate.update(user);
    	return true;
    }
    public User getUserById(String id){
    	String hql= "from User where id=?";
    	@SuppressWarnings("unchecked")
		List<User> user = (List<User>)this.hibernateTemplate.find(hql,id);
    	if(user!=null&&user.size()>0)
    	{
    		return user.get(0);
    	}
    	else{
    		return null;
    	}
    }
    public List<User> top7user(){
    	@SuppressWarnings("unchecked")
    	String hql="from User";
    	List<User> users = (List<User>)doSplitPage(hql,1,7);
    	return users;
    }
    @SuppressWarnings("unchecked")
	private List doSplitPage(final String hql,final int curPage,final int pageSize){
    	return (List)this.hibernateTemplate.executeFind(new HibernateCallback(){
    		public Object doInHibernate(Session session) throws HibernateException, SQLException {
    			Query query=session.createQuery(hql);
    			return query.setFirstResult((curPage-1)*pageSize).setMaxResults(pageSize).list();
    		}
    	});
    }
}
