package com.example.bookstore;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController   {
	
	@Autowired
	private BookRepository bookRespository;
	
	@Autowired
	private DepartmentRepository departmentRepository; 
	
	//show all books
    @RequestMapping(value="/booklist")
public String bookList(Model model){
    model.addAttribute("books", bookRespository.findAll());
    	return "booklist";
    }
    
    // RESTful services to get all students
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest(){   
    	return (List<Book>) bookRespository.findAll();
    }
    
    //RESTful service to get students by id
    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Book findBookRest(@PathVariable("id") Long bookId){
		return bookRespository .findOne(bookId);
    	
    }
   
 // Adding new Books
    @RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("departments", departmentRepository.findAll() );
		return "addBook";
    }
    
  
    
    //saving the books
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
    	bookRespository.save(book);
        return "redirect:booklist";
}
    
    
    // Delete Books
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletebook(@PathVariable("id") Long bookId, Model model){
    	bookRespository.delete(bookId);
		return "redirect:../booklist";
    	
    }
     
}