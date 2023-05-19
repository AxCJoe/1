//package com.softusing.joe.controller;
//
//import com.softusing.joe.domain.Book;
//import com.softusing.joe.service.BookMybatisService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v2")
//public class BookApp {
//
//    @Autowired
//    private BookMybatisService bookService;
//
//    @GetMapping("/books")
//    public List<Book> getAll()
//    {
//        return bookService.findAll();
//    }
//
//    @PostMapping("/books")
//
//    public int post(Book book){
////    public Book post(@RequestParam String name,
////                     @RequestParam String author,
////                     @RequestParam String description,
////                     @RequestParam int status)
////    {
////        Book book = new Book();
////
////        book.setName(name);
////        book.setAuthor(author);
////        book.setDescription(description);
////        book.setStatus(status);
//
//        return bookService.save(book);
//
//
//    }
//
////    @GetMapping("/books/{id}")
////
////    public Book getOne(@PathVariable Long id)
////    {
////        return bookService.findOne(id);
////    }
//
//    @PutMapping("/books")
//        public int update(
//                @RequestParam long id,
//                @RequestParam String name,
//                @RequestParam String author,
//                @RequestParam String description,
//                @RequestParam int status)
//    {
//        Book book = new Book();
//        book.setId(id);
//        book.setName(name);
//        book.setAuthor(author);
//        book.setDescription(description);
//        book.setStatus(status);
//
//        return bookService.save(book);
//    }
//
//
//
//    @DeleteMapping("/books/{id}")
//    public void delOne(@PathVariable long id)
//    {
//        bookService.delete(id);
//    }
//
//    /*@PostMapping("/books/by")
//    public List<Book> findBy(@RequestParam String author)
//    {
//        return bookService.findByAuthor(author);
//    }
//
//    @PostMapping("/books/by/as")
//    public List<Book> findByAuthorAndStatus(@RequestParam String author,@RequestParam int status)
//    {
//        return bookService.findByAuthorAndStatus(author,status);
//    }
//
//    @PostMapping("/book/des")
//    public List<Book> findByDescriptionEndsWith(@RequestParam String description)
//    {
//        return bookService.findByDescriptionEndsWith(description);
//    }
//
//    @PostMapping("/books/sql")
//    public List<Book> findBy(@RequestParam int len)
//    {
//        return bookService.findByJPQL(len);
//    }*/
//
//
//}
