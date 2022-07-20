package com.api.book.bootrestbook.services;

//import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collector;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.enitity.BookDetails;

@Service
public class BookServices {

    @Autowired
   private BookRepository bookRepository;
        
    

    // private static List<BookDetails> list = new ArrayList<>();
    // static{
    //     list.add(new BookDetails(1,"c in depth", "xyz"));
    //     list.add(new BookDetails(2,"d in depth", "xyz1"));
    //     list.add(new BookDetails(3,"e in depth", "xyz2"));
    //     list.add(new BookDetails(4,"f in depth", "xyz3"));
    //     list.add(new BookDetails(5,"g in depth", "xyz4"));

    // }
    
 
    // get all books
    public List<BookDetails> getAllBook()
    { //commit bcz this is for list return
       // return list;
       List<BookDetails> list = (List<BookDetails>) this.bookRepository.findAll();
       return list;
    }
    // get single book by id 
    public BookDetails getBookById(int id){
        BookDetails book = null;
        try{
       // list.stream().filter(e-> e.getId()==id).findFirst().get();
        book = this.bookRepository.findById(id);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return book;
    }
    //add book
    public BookDetails addBook(BookDetails b){
        // list.add(b);
        // return b;

        BookDetails result = bookRepository.save(b);
        return result;
    }
    //delete book from list
    public void deleteBook(int id){
     //  list = list.stream().filter(book-> book.getId()!=id).collect(Collectors.toList());
     bookRepository.deleteById(id);
    }

    //update the book
    public void updateBook( BookDetails book, int id){
    //     list.stream().map(b->{
    //         if(b.getId() == id){
    //             b.setAuthor(book.getAuthor());
    //             b.setTitle(book.getTitle());
    //         }
    //         return b;
    //     }).collect(Collectors.toList());
    

    book.setId(id);
    bookRepository.save(book);
    }
}
