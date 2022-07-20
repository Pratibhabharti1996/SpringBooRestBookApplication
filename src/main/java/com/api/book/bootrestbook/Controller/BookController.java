package com.api.book.bootrestbook.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.enitity.BookDetails;
import com.api.book.bootrestbook.services.BookServices;

@RestController

public class BookController {

    @Autowired
    private BookServices bookServices;

    @GetMapping("/books")
    public BookDetails getBook()
    {
        BookDetails b = new BookDetails();
        // b.setId(1);

        // b.setAuthor("Balaguruswami");
        // b.setTitle("java fundamental");
        return b;
        
    }
//read all book handler
    @GetMapping("/bookDeatils")
    public ResponseEntity<List<BookDetails>> getBookDetails()
    {
        List<BookDetails> b = this.bookServices.getAllBook();
        if(b.size()<= 0)
        { 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }
        return ResponseEntity.status(HttpStatus.CREATED).body(b);
    }

    //read single book by id handler
   @GetMapping("/bookbyId/{id}")
    public ResponseEntity<BookDetails> getBookById(@PathVariable("id") int id){
        BookDetails b = bookServices.getBookById(id);
        if (b == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(b));

    }
    //create book handler
    @PostMapping("/books")
    public ResponseEntity<BookDetails> addBook(@RequestBody BookDetails b){

        BookDetails b1 = null;
        try{
         b1= this.bookServices.addBook(b);
        return ResponseEntity.of(Optional.of(b1));
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


    }
    //delewte book handler
    @DeleteMapping("/books/{bid}")
    public ResponseEntity<Void> deleteBookById(@PathVariable("bid") int bid){
        try {
            this.bookServices.deleteBook(bid);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            
        } catch (Exception e) {
            
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
       

    }
 //update book handler
 @PutMapping("/books/{bid}")
 public  ResponseEntity<BookDetails> updateBook(@RequestBody BookDetails b, @PathVariable("bid") int bid){
    try {

        this.bookServices.updateBook(b, bid);
        return ResponseEntity.ok().body(b);
        
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        
    }
    


 }   
}