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

import com.dch.bean.Book;
import com.dch.bean.Dymess;
import com.dch.viewbean.Grobe;
@Repository
public class DynamicDao {
	@Resource(name="hibernateTemplate")   
    private HibernateTemplate hibernateTemplate;
    public void addDymess(Dymess dymess)
	{
    	this.hibernateTemplate.save(dymess);
	}
    public void deleteDymess(Dymess dymess)
	{
    	this.hibernateTemplate.delete(dymess);
	}
    public void updateDymess(Dymess dymess)
	{
    	this.hibernateTemplate.update(dymess);
	}
    public List<Dymess> top7dynamic(){
    	@SuppressWarnings("unchecked")
    	String hql="from Dymess";
    	List<Dymess> dymess = (List<Dymess>)doSplitPage(hql,1,7);
    	return dymess;
    }
    public List<Dymess> clifydymess(String where,int page,int spilt,Grobe g){
    	@SuppressWarnings("unchecked")
    	String hql="from Dymess "+where;
    	g.setTotal(this.hibernateTemplate.find(hql).size());
    	List<Dymess> dymess = (List<Dymess>)doSplitPage(hql,page,spilt);
    	return dymess;
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
