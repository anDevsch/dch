package com.dch.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.dch.bean.Book_remark;
@Repository
public class RemarkDao {
	@Resource(name="hibernateTemplate")   
    private HibernateTemplate hibernateTemplate;
	public void addRemark(Book_remark remark)
	{
    	this.hibernateTemplate.save(remark);
	}
    public void deleteRemark(Book_remark remark)
	{
    	this.hibernateTemplate.delete(remark);
	}
    public void updateRemark(Book_remark remark)
	{
    	this.hibernateTemplate.update(remark);
	}
    public Book_remark GetRemarkById(String id)
	{
    	String hql= "from Book_remark where id=?";
    	@SuppressWarnings("unchecked")
		List<Book_remark> remark = (List<Book_remark>)this.hibernateTemplate.find(hql,id);
    	if(remark!=null&&remark.size()>0)
    	{
    		return remark.get(0);
    	}
    	else{
    		return null;
    	}
	}
    public List<Book_remark> top7remark(){
    	@SuppressWarnings("unchecked")
    	String hql="from Book_remark";
    	List<Book_remark> remarks = (List<Book_remark>)doSplitPage(hql,1,7);
    	return remarks;
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
