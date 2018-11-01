package com.cg.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {
	
	@Id
	@Column(name="isbn", length=10)
	private int bookIsbn;
	
	@Column(name="book_title", length=20)
	private String bookTitle;
	
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="book")
	private Set<Author> Aut = new HashSet<>();
	@Column(name="book_price", length=5)
	private double bookPrice;

	public int getBookIsbn() {
		return bookIsbn;
	}

	public void setBookIsbn(int bookIsbn) {
		this.bookIsbn = bookIsbn;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public Book(int bookIsbn, String bookTitle, double bookPrice) {
		super();
		this.bookIsbn = bookIsbn;
		this.bookTitle = bookTitle;
		this.bookPrice = bookPrice;
	}

	public Book() {
		super();
		
	}

	@Override
	public String toString() {
		return "Book [bookIsbn=" + bookIsbn + ", bookTitle=" + bookTitle
				+ ", bookPrice=" + bookPrice + "]";
	}
	
	public Set<Author> getAuthor() {
		return Aut;
	}

	public void setAuthor(Set<Author> Aut) {
		this.Aut = Aut;
	}
	
	
}
