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

import com.dch.bean.Book;
import com.dch.bean.Order;
import com.dch.viewbean.Grobe;
@Repository
public class BookDao {
	@Resource(name="hibernateTemplate")   
    private HibernateTemplate hibernateTemplate;
    public void addBook(Book book)
	{
    	this.hibernateTemplate.save(book);
	}
    public void deleteBook(Book book)
	{
    	this.hibernateTemplate.delete(book);
	}
    public void updateBook(Book book)
	{
    	this.hibernateTemplate.update(book);
	}
    public void mergeBook(Book book)
	{
    	this.hibernateTemplate.merge(book);
	}
    public Book GetBookById(String id)
	{
    	String hql= "from Book where id=?";
    	@SuppressWarnings("unchecked")
		List<Book> book = (List<Book>)this.hibernateTemplate.find(hql,id);
    	if(book!=null&&book.size()>0)
    	{
    		return book.get(0);
    	}
    	else{
    		return null;
    	}
	}
    public List<Book> top7book(){
    	@SuppressWarnings("unchecked")
    	String hql="from Book";
    	List<Book> books = (List<Book>)doSplitPage(hql,1,7);
    	return books;
    }
    public List<Book> clifybook(String where,int page,int spilt,Grobe g){
    	@SuppressWarnings("unchecked")
    	String hql="from Book "+where;
    	g.setTotal(this.hibernateTemplate.find(hql).size());
    	List<Book> books = (List<Book>)doSplitPage(hql,page,spilt);
    	return books;
    }
    public Book FindBookByPng(String png){
    	@SuppressWarnings("unchecked")
    	String hql="from Book where bookpng='"+png+"'";
    	List<Book> books = (List<Book>)doSplitPage(hql,1,2);
    	if(books!=null&&books.size()>0){
    		return books.get(0);
    	}
    	else return null;
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
