package com.dch.service;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dch.bean.Book;
import com.dch.bean.Dymess;
import com.dch.dao.DynamicDao;
import com.dch.viewbean.Grobe;
@Service  
@Transactional//事务管理
public class DynamicService {
	@Resource  
	private DynamicDao dynamicDao;
	public List<Dymess> top7Dymess()
	{
		return this.dynamicDao.top7dynamic();
	}
	
	public void addDymess(Dymess dymess)
	{
		this.dynamicDao.addDymess(dymess);
	}
	public void deleteDymess(Dymess dymess)
	{
		this.dynamicDao.deleteDymess(dymess);
	}
	public void updateDymess(Dymess dymess)
	{
		this.dynamicDao.updateDymess(dymess);
	}
	public List<Dymess> clifydymess(String where,int page,int spilt,Grobe g){
    	return this.dynamicDao.clifydymess(where, page, spilt, g);
    }
}
