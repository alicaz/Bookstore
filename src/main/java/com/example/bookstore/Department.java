package com.example.bookstore;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long departmentid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
	private List<Book> books;
	
	public Department(){}
	
	public Department(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return departmentid;
	}

	public void setId(Long id) {
		this.departmentid = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	@Override
	public String toString(){
		return "Department [name=" + name + ", id="+ departmentid +"]";
	}
	

}
