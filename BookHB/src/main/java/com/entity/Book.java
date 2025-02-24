package com.entity;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int bid; 
	
	String bname;
	String publisher_name;
	Date published_date;
	String author;
	float price;
	int edition;
	
	public Book() {
		
	}
	
	public Book(String bname, String publisher_name, Date published_date, String author, float price, int edition) {
		this.bname = bname;
		this.publisher_name = publisher_name;
		this.published_date = published_date;
		this.author = author;
		this.price = price;
		this.edition = edition;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getPublisher_name() {
		return publisher_name;
	}

	public void setPublisher_name(String publisher_name) {
		this.publisher_name = publisher_name;
	}

	public Date getPublished_date() {
		return published_date;
	}

	public void setPublished_date(Date published_date) {
		this.published_date = published_date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", publisher_name=" + publisher_name + ", published_date="
				+ published_date + ", author=" + author + ", price=" + price + ", edition=" + edition + "]";
	}
	


}
