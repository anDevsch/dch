package com.dch.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dch.bean.Book;
import com.dch.bean.Order;
import com.dch.bean.User;

@Service  
@Transactional//事务管理
public class MexService {
	@Resource(name="hibernateTemplate")   
    private HibernateTemplate hibernateTemplate;
	@Resource(name="bookService")
	private BookService bookService;
	public List<Book> FindOrderByUser(User user){
		String hql= "from Order where user_id=? and struts!=-1 and struts!=3 order by orderdatetime desc";
    	@SuppressWarnings("unchecked")
		List<Order> orders = (List<Order>)this.hibernateTemplate.find(hql,user.getId());
    	List<Book> books = new ArrayList<Book>();
    	if(orders!=null&&orders.size()>0)
    	{
    		for(Order o:orders){
    			Book b = bookService.GetBookById(o.getBook_id().getId());
    			books.add(b);
    		}
    		return books;
    	}
    	else{
    		return null;
    	}
	}
	//错误 user_id为外键 未知错误
	public Book FindBookByUser(String userid){
		String hql= "from Book where user_id=? order by updatetime desc";
    	@SuppressWarnings("unchecked")
		List<Book> books = (List<Book>)this.hibernateTemplate.find(hql,userid);
    	if(books!=null&&books.size()>0)
    	{
    		return books.get(0);
    	}else return null;
	}
}
