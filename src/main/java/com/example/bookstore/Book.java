package com.example.bookstore;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
public class Book {
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String isbn;
	private String author;
	private long year;
	private double price;
	private String title;
	
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "departmentid")
	private Department department;
	
	public Book() {}
	
	public Book(String isbn, String author, String title, int year, double price, Department department) {
		super();
		this.author = author;
		this.isbn = isbn;
		this.title = title;
		this.year= year;
		this.price= price;
		this.department = department;
		}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public long getYear() {
		return year;
	}
	
	public void setYear(long year) {
		this.year = year;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(long price) {
		this.price = price;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@Override
	public String toString(){
		if(this.department != null)
		return" Book [id=" + id + ", isbn="+ isbn +", author=" + author +", title=" + title +", price=" + price +",year=" + year +"  department =" + this.getDepartment() + "]";
		
		else
			return " Book [id=" + id + ", isbn="+ isbn +", author=" + author +", title=" + title +", price=" + price +",year=" + year +"]";
	}
	 
	
	}

