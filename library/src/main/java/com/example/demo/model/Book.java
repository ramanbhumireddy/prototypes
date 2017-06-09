package com.example.demo.model;

public class Book {
	
	private long bookId;
	private String author;
	private String title;
	private double price;
	private boolean available;
	
	
	public Book(long bookId, String author, String title, double price, boolean available) {
		this.bookId = bookId;
		this.author = author;
		this.title = title;
		this.price = price;
		this.available = available;
	}

	public long getBookId() {
		return bookId;
	}
	
	
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	
	
	

}
