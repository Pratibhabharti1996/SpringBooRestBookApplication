package com.api.book.bootrestbook.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.book.bootrestbook.enitity.BookDetails;

public interface BookRepository extends CrudRepository<BookDetails, Integer> {

    public BookDetails findById(int id);
    
}
