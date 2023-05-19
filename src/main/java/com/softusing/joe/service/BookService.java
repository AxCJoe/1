/*
package com.softusing.joe.service;

import com.softusing.joe.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Book findOne(Long id) {
        Book book = new Book();
        if (bookRepository.findById(id).get() == null){
            book = bookRepository.findById(id).get();
        }
        return book;
    }

    public void del(long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public List<Book> findByAuthorAndStatus(String author, int status) {
        return bookRepository.findByAuthorAndStatus(author, status);
    }

    public List<Book> findByDescriptionEndsWith(String des) {
        return bookRepository.findByDescriptionEndsWith(des);
    }

    public List<Book> findByJPQL(int len) {
        return bookRepository.findByJPQL(len);
    }





}
*/
