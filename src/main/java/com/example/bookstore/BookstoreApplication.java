package com.example.bookstore;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.Department;
import com.example.bookstore.DepartmentRepository;
import com.example.bookstore.Book;
import com.example.bookstore.BookRepository;



@SpringBootApplication
public class BookstoreApplication {
 private static final Logger Log = LoggerFactory.getLogger(BookstoreApplication.class);
 
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	
	
	@Bean
	public CommandLineRunner bookstore(BookRepository brepository, DepartmentRepository drepository) {
		return (args) -> {
			Log.info("save a couple of books");
			drepository.save(new Department("IT"));
			drepository.save(new Department("Business"));
			drepository.save(new Department("Law"));
			
			
			brepository.save(new Book("Ernest Hemingway", "A farewell to Arms", "1232323-21", 1929, 19.99, drepository.findByName("IT").get(0)));
			brepository.save(new Book("George Orwell", "Animal Farm", "2212343-5",  2007, 35.99, drepository.findByName("Business").get(0)));	
			
			Log.info("fetch all books");
			for (Book book : brepository.findAll()) {
			Log.info(book.toString());
				
			}

		};
	}
}
