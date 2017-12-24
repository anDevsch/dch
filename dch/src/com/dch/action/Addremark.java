package com.dch.action;

import java.util.Date;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.dch.bean.Book;
import com.dch.bean.Book_remark;
import com.dch.bean.Rema_remark;
import com.dch.bean.User;
import com.dch.service.BookService;
import com.dch.service.RemarkService;
import com.opensymphony.xwork2.ActionSupport;

public class Addremark extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2420583831987262108L;
	private BookService bookService;
	private RemarkService remarkService;
	public String execute() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		
		try{
			User user=(User)ServletActionContext.getRequest().getSession().getAttribute("loginUser");
			if(user==null||user.equals("")){
				response.getWriter().write("{state:'error',reason:'请先登录'}");return null;
			}
			
			HttpServletRequest request = ServletActionContext.getRequest();
			String status = request.getParameter("status");
		
			if(status.equals("1")){
				String book_id = request.getParameter("to_id");
				String context = request.getParameter("context");
				Book book = bookService.GetBookById(book_id);
				if(book!=null){
					Book_remark brem = new Book_remark();
					brem.setUser_id(user);
					brem.setBook_id(book);
					brem.setContext(context);
					brem.setRemarkdatetime(new Date());
					brem.setZan(0);
					brem.setRemark_status(0);
					//brem.setRema_remarks_id(new HashSet<Rema_remark>());
			        book.getBook_remarks_id().add(brem);
			        bookService.mergeBook(book);
			        response.getWriter().write("{state:'success',reason:'',data:'评论成功'}");
					return null;
				}else{
					response.getWriter().write("{state:'success',reason:'',data:'异常错误101，请刷新后重试'}");
					return null;
				}
			}
			else if(status.equals("2")){
				String remark_id = request.getParameter("to_id");
				String context = request.getParameter("context");
				Book_remark remark = remarkService.GetRemarkById(remark_id);
				if(remark!=null){
					Rema_remark rrem = new Rema_remark();
					rrem.setUser_id(user.getId());
					rrem.setRemark_id(remark);
					rrem.setContext(context);
					rrem.setRemarkdatetime(new Date());
					rrem.setZan(0);
					rrem.setRemark_status(0);
					//brem.setRema_remarks_id(new HashSet<Rema_remark>());
			        remark.getRema_remarks_id().add(rrem);
			        remarkService.updateRemark(remark);
			        response.getWriter().write("{state:'success',reason:'',data:'评论成功'}");
					return null;
				}else{
					response.getWriter().write("{state:'success',reason:'',data:'异常错误102，请刷新后重试'}");
					return null;
				}
			}else{
				response.getWriter().write("{state:'success',reason:'',data:'异常错误103，请刷新后重试'}");
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			response.getWriter().write("{state:'success',reason:'',data:'异常错误104，请刷新后重试'}");
			return null;
		}
		
		
		
	}
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	public RemarkService getRemarkService() {
		return remarkService;
	}
	public void setRemarkService(RemarkService remarkService) {
		this.remarkService = remarkService;
	}
}
