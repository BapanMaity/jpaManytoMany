package com.cg.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name="Authors")
public class Author {
	
	@Id
	@Column(name="author_id", length=10)
	private int authorId;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Author_books", joinColumns = { 
			@JoinColumn(name = "author_id") }, inverseJoinColumns = { 
			@JoinColumn(name = "book_id") })
	private Set<Book> book = new HashSet<>();
	@Column(name="author_name", length=20)
	private String authorName;

	public Author(int authorId, String authorName) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
	}

	public Author() {
		super();
		
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName
				+ "]";
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public Set<Book> getBooks() {
		return book;
	}

	public void setBooks(Set<Book> book) {
		this.book = book;
	}
	
	public void addBooks(Book book) {
		this.getBooks().add(book);
	}
	
}
