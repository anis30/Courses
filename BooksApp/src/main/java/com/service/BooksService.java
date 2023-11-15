package com.service;  
import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;
 
import com.model.Books;
import com.repository.BooksRepository;  
//defining the business logic  
@Service  
public class BooksService   
{  
@Autowired
BooksRepository booksRepository;  
//getting all books record by using the method findaAll() of CrudRepository  
public List<Books> getAllBooks()   
{  
List<Books> books = new ArrayList<Books>();  
books = (List<Books>) booksRepository.findAll();  
return books;  
}  
//getting a specific record by using the method findById() of CrudRepository  
public Books getBooksById(int id)   
{  
return booksRepository.findById(id).get();  
}  
//saving a specific record by using the method save() of CrudRepository  
public Books saveOrUpdate(Books books)   
{  
return booksRepository.save(books);  
}  
//deleting a specific record by using the method deleteById() of CrudRepository  
public void delete(int id)   
{  
booksRepository.deleteById(id);  
}  
//updating a record  
public void update(Books books, int bookid)   
{  
booksRepository.save(books);  
} 
public void saveMyBook() {

 
Books book=new Books(458,"Python for Beginners","Johnson",809);
System.out.println("Record Inserted");
booksRepository.save(book);
 
 
}
 
public  Books save(Books newBook) {
	Books book=new Books(458,"Python for Beginners","Johnson",809);
	System.out.println("Record Inserted");
	booksRepository.save(book);
	return book;
}
}  