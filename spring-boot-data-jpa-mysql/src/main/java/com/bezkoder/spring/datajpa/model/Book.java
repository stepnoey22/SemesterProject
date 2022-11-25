package com.bezkoder.spring.datajpa.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	private long id;

	@Column(name = "bookName")
	private String bookName;

	@Column(name = "description")
	private String description;

    @JsonIgnore
	@ManyToOne
	@JoinColumn(name="shop_id")
	private Shop shop;

	public Book() {

	}

	public Book(String bookName, String description) {
		this.bookName = bookName;
		this.description = description;
	}

	

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public long getId() {
		return id;
	}

	public String getbookName() {
		return bookName;
	}

	public void setbookName(String bookName) {
		this.bookName = bookName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", desc=" + description + "]";
	}

}

