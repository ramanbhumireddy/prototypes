package com.example.demo.dao;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;

import com.example.demo.model.Book;


@Component
public class BookDao {
	
//public static int save(String callno,String name,String author,String publisher,int quantity){
//	int status=0;
//	try{
//		Connection con=DB.getConnection();
//		PreparedStatement ps=con.prepareStatement("insert into books(callno,name,author,publisher,quantity) values(?,?,?,?,?)");
//		ps.setString(1,callno);
//		ps.setString(2,name);
//		ps.setString(3,author);
//		ps.setString(4,publisher);
//		ps.setInt(5,quantity);
//		status=ps.executeUpdate();
//		con.close();
//	}catch(Exception e){System.out.println(e);}
//	return status;
//}
	
	private CopyOnWriteArrayList<Book> books;
	
	{
		books = new CopyOnWriteArrayList<>();
		books.add(new Book(100, "kk", "Spring Boot", 200.00, true));
		books.add(new Book(101, "kk", "Java", 300.00, true));
		books.add(new Book(102, "kk", "MySql", 400.00, true));
		books.add(new Book(103, "kk", "Oracle", 500.00, true));
	}
	
	public List<Book> allBooks(){
		return books;
	}
	
	public Book getBook(Long bookId){
		Book foundBook = null;
		for (Book book : books) {
			if(bookId.longValue() ==  book.getBookId() ){
				foundBook = book;
				break;
			}
		}
		return foundBook;
	}
	
	public void saveBook(Book book){
		books.add(book);
	}
	
	public void deleteBook(Long id){
		for (Book book : books) {
			if(id ==  book.getBookId() ){
				books.remove(book);
				break;
			}
		}
	}
	
}
