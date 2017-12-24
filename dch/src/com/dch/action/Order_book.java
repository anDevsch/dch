package com.dch.action;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dch.bean.Book;
import com.dch.bean.Book_remark;
import com.dch.bean.Order;
import com.dch.bean.User;
import com.dch.dao.OrderDao;
import com.dch.service.BookService;
import com.dch.service.UserService;
import com.dch.viewbean.Grobe;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Order_book extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3375152231610514584L;
	private TreeSet<Book_remark> remarks;
	private List<Book> books;
	private Book book;
	private OrderDao orderDao;
	private BookService bookService;
	private UserService userService;
	private String brrot;
	private User uuser;
	private String retut;
	private Order order;
	//private User borru;
	public String execute() throws Exception{
		SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd"); 
		HttpServletRequest request = ServletActionContext.getRequest();
		String book_id=request.getParameter("bookid");
		Book bok=bookService.GetBookById(book_id);
		Grobe g = new Grobe();
		List<Order> os = orderDao.GetOrderBySql("where book_id='"+bok.getId()+"' and struts!=-1 and struts!=3 order by orderdatetime desc", 1, 2, g);
		for(Order o:os){
			setOrder(o);
			setBrrot(sdf.format(o.getOrderdatetime()));
			setRetut(sdf.format(o.getRetdatetime()));
			//setBorru(userService.getUserById(o.getUser());
			User user=(User)ServletActionContext.getRequest().getSession().getAttribute("loginUser");
			User u = new User();
			if(user==null||user.getId()==null||user.getId()==""){u.setStruts(-1);}
			else if(bok.getUser_id().getId().equals(user.getId())){u = userService.getUserById(o.getUser_id());u.setStruts(0);u.setSign("借书者");}
			else if(o.getUser_id().equals(user.getId())){u = userService.getUserById(bok.getUser_id().getId());u.setStruts(1);u.setSign("持书者");}
			setUuser(u);
			break;
			}
		if(bok!=null){
			setBook(bok);
			TreeSet<Book_remark> remark = new TreeSet<Book_remark>(new Book_remark.DateCompare());
			Set<Book_remark> rema = bok.getBook_remarks_id();
			for(Book_remark rem:rema)remark.add(rem);
			setRemarks(remark);
			//System.out.println(bok.getAuthor());
			
			
			//推荐书籍
			List<Book> books=this.bookService.top7book();
			if(books!=null&&books.size()>0)
			{
				setBooks(books);
			}
			return SUCCESS;
		}else {
			//HttpServletResponse response = ServletActionContext.getResponse();
			request.setAttribute("text", "查找书籍信息错误，404");
			request.setAttribute("return", "history.go(-1)");
			return "text";
		}
		
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	public TreeSet<Book_remark> getRemarks() {
		return remarks;
	}
	public void setRemarks(TreeSet<Book_remark> remarks) {
		this.remarks = remarks;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public String getBrrot() {
		return brrot;
	}
	public void setBrrot(String brrot) {
		this.brrot = brrot;
	}
	public String getRetut() {
		return retut;
	}
	public void setRetut(String retut) {
		this.retut = retut;
	}
	public User getUuser() {
		return uuser;
	}
	public void setUuser(User uuser) {
		this.uuser = uuser;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public OrderDao getOrderDao() {
		return orderDao;
	}
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
}
