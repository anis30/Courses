package com.controller;
import java.util.List;
 

 
//import javax.ws.rs.core.MediaType;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.PutMapping;  
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
 
import com.model.Books;
import com.service.BooksService;  
@RestController
//@RestController ==> 2 annotations-@ResponseBody   and also @Controller
public class BooksController   
{  
//autowire the BooksService class  
@Autowired  
BooksService booksService;  
//creating a get mapping that retrieves all the books detail from the database   
@GetMapping("/book")  
private List<Books> getAllBooks()   
{  
return booksService.getAllBooks();  
}  
 
 
//creating a get mapping that retrieves the detail of a specific book  
@GetMapping(path="/book/{bookid}"   ,produces="application/xml")

private Books getBooks(@PathVariable("bookid") int bookid)   
{  
return booksService.getBooksById(bookid);  
}  
 
 
//creating a delete mapping that deletes a specified book  
@DeleteMapping("/book/{bookid}")  
private void deleteBook(@PathVariable("bookid") int bookid)   
{  
booksService.delete(bookid);  
}  
//creating post mapping that post the book detail in the database  
@PostMapping("/books")  
private Books saveBook(@RequestBody Books books)   
 
{  
booksService.saveOrUpdate(books); 
System.out.println("Posting data Successfull");
return books;
//return books.getBookid();  
}  
 
 
//creating put mapping that updates the book detail   
@PutMapping("/bookupdate/{bookid}")  
private Books update(@PathVariable ("bookid") int bookid,@RequestBody Books books)   
{ 
	books.setBookid(bookid);
	Books updatedBooks=booksService.saveOrUpdate(books);
 
 
return updatedBooks;  
}
 
 
	


}