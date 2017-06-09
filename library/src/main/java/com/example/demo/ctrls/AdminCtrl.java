package com.example.demo.ctrls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.BookDao;
import com.example.demo.model.Book;


@controller
//@RestController
@RequestMapping("/las")
public class AdminCtrl {
	
	@Autowired
	private BookDao bookDao;
	
	@RequestMapping("/adminUser")
	public String getAdminUser(){
		return "this is admin user invoked";
	}
	
	@RequestMapping("/viewBooks")
	public ResponseEntity<List<Book>> viewAllBooks(){
		if(bookDao.allBooks().size() > 0)
			return new ResponseEntity<>(bookDao.allBooks(), HttpStatus.OK);
		else
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/viewBook/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<? extends Object> viewBook(@PathVariable("id") long id){
		if(null == bookDao.getBook(id))
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(bookDao.getBook(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/addBook", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<? extends Object> addBook(@PathVariable("id") long id, @RequestBody Book book){
		try {
			bookDao.getBook(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping("/deleteBook/{id}")
	public ResponseEntity<? extends Object> deleteBook(@PathVariable("id") long id){
		if(null == bookDao.getBook(id))
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else{
			bookDao.deleteBook(id);
			return new ResponseEntity<>( HttpStatus.OK);
		}
	}

}
