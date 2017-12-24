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

import com.dch.bean.Dymess;
import com.dch.bean.Order;
import com.dch.viewbean.Grobe;
@Repository
public class OrderDao {
	@Resource(name="hibernateTemplate")   
    private HibernateTemplate hibernateTemplate;
	public void addOrder(Order order)
	{
    	this.hibernateTemplate.save(order);
	}
    public void deleteOrder(Order order)
	{
    	this.hibernateTemplate.delete(order);
	}
    public void updateOrder(Order order)
	{
    	this.hibernateTemplate.update(order);
	}
    public Order GetOrderById(String id)
	{
    	String hql= "from Order where id=?";
    	@SuppressWarnings("unchecked")
		List<Order> order = (List<Order>)this.hibernateTemplate.find(hql,id);
    	if(order!=null&&order.size()>0)
    	{
    		return order.get(0);
    	}
    	else{
    		return null;
    	}
	}
    public List<Order> GetOrderBySql(String where,int page,int spilt,Grobe g){
    	@SuppressWarnings("unchecked")
    	String hql="from Order "+where;
    	g.setTotal(this.hibernateTemplate.find(hql).size());
    	List<Order> order = (List<Order>)doSplitPage(hql,page,spilt);
    	return order;
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
