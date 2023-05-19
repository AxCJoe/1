package com.softusing.joe.controller;

import com.softusing.joe.domain.Book;
import com.softusing.joe.service.BookMybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//　Javaで書かれたREST APIのコントローラークラスを表しています。@RestControllerアノテーションは、
// このクラスがREST APIのエンドポイントを処理するために使用されることを示しています。
// @RequestMappingアノテーションは、このクラスがリクエストを処理するためにマップされるURLパスを指定しています。
// ここでは、"/api/v3"パスにマップされています。

@RestController
@RequestMapping("/api/v3")
public class BookMybatisApp {



    @Autowired
    private BookMybatisService bookMybatisService;

    @GetMapping("/books")
    public List<Book> getAll()
    {
        return bookMybatisService.findAll();
    }

    @PostMapping("/books")

    public int post(Book book){
//    public Book post(@RequestParam String name,
//                     @RequestParam String author,
//                     @RequestParam String description,
//                     @RequestParam int status)
//    {
//        Book book = new Book();
//
//        book.setName(name);
//        book.setAuthor(author);
//        book.setDescription(description);
//        book.setStatus(status);

        return bookMybatisService.save(book);


    }


    @PutMapping("/books")
    public int update(
            @RequestParam long id,
            @RequestParam String name,
            @RequestParam String author,
            @RequestParam String description,
            @RequestParam int status)
    {
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setAuthor(author);
        book.setDescription(description);
        book.setStatus(status);

        return bookMybatisService.save(book);
    }



    @DeleteMapping("/books/{id}")
    public void delOne(@PathVariable int id)
    {
        bookMybatisService.delete(id);
    }



}
