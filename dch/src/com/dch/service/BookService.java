package com.dch.service;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dch.bean.Book;
import com.dch.dao.BookDao;
import com.dch.viewbean.Grobe;
@Service  
@Transactional//事务管理
public class BookService {
	@Resource  
	private BookDao bookDao;
	public List<Book> top7book()
	{
		return this.bookDao.top7book();
	}
	
	public void addBook(Book book)
	{
		this.bookDao.addBook(book);
	}
	public void deleteBook(Book book)
	{
		this.bookDao.deleteBook(book);
	}
	public void updateBook(Book book)
	{
		this.bookDao.updateBook(book);
	}
	public void mergeBook(Book book)
	{
		this.bookDao.mergeBook(book);
	}
	public Book GetBookById(String id) {
		return this.bookDao.GetBookById(id);
	}
	public List<Book> clifybook(String where,int page,int spilt,Grobe g){
    	return this.bookDao.clifybook(where,page,spilt,g);
    }
	public Book FindBookByPng(String png){
		return this.bookDao.FindBookByPng(png);
	}
}
