package bitedu.bipa.book.controller;


import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bitedu.bipa.book.service.BlmService;
import bitedu.bipa.book.utils.PageDTO;
import bitedu.bipa.book.vo.BookCopy;

@Controller("bookController")
public class BookController {

	@Autowired
	private BlmService service;
	
	public BookController() {
		
	}
	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		PageDTO<BookCopy> list = service.serchBookWithPaging(1);
		
		mav.addObject("dto", list);
		mav.setViewName("./manager/book_list");
		
		return mav;
	}
	
	
	@RequestMapping(value = "/view_regist.do", method = RequestMethod.GET)
	public ModelAndView viewRegist() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("./manager/book_regist");
		
		return mav;
	}
	
	
	@RequestMapping(value = "/regist.do", method = RequestMethod.POST)
	public ModelAndView regist(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView();
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("book_title");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		String date = request.getParameter("publish_date");
		String bookPosition = request.getParameter("book_position");
		String bookStatus = request.getParameter("book_status");
		
		Date publishDate = Date.valueOf(date);
		BookCopy copy = new BookCopy(isbn, title, author, publisher,publishDate, bookPosition, bookStatus);
		
		service.registBook(copy);
		mav.setViewName("redirect:/list.do");
		
		return mav;
	}
}
