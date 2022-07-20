package com.api.book.bootrestbook.enitity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Author {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)

    private int authorId;
    private String firstName;
    private String lastName;

    @OneToOne(mappedBy = "author")
    @JsonBackReference
    private BookDetails book;


    public Author(int authorId, String firstName, String lastName) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Author() {
    }
    public int getAuthorId() {
        return authorId;
    }
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setBook(BookDetails book) {
        this.book = book;
    }
    public BookDetails getBook() {
        return book;
    }
    
    
}
