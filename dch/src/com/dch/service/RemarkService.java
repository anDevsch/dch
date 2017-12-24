package com.dch.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dch.bean.Book_remark;
import com.dch.dao.RemarkDao;
@Service  
@Transactional//ÊÂÎñ»Ø¹ö
public class RemarkService {
	@Resource
	private RemarkDao remarkDao;
	
	public List<Book_remark> top7remark()
	{
		return this.remarkDao.top7remark();
	}
	
	
	public void addRemark(Book_remark remark){
		this.remarkDao.addRemark(remark);
	}
	public void deleteRemark(Book_remark remark){
		this.remarkDao.deleteRemark(remark);
	}
	public void updateRemark(Book_remark remark){
		this.remarkDao.updateRemark(remark);
	}
	public Book_remark GetRemarkById(String id){
		return this.remarkDao.GetRemarkById(id);
	}
}
