package com.softusing.joe.controller;


import com.softusing.joe.domain.Book;
import com.softusing.joe.exception.BookNotFoundException;
import com.softusing.joe.service.BookMybatisInterface;
import com.softusing.joe.service.BookMybatisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class BookController {

    @Autowired
    private BookMybatisService bookMybatisService;

    @GetMapping("/books12")
    public String list() {
        return "books12";
    }

    @GetMapping("/book13")
    public String list(Model model) {
        List<Book> bookList = bookMybatisService.findAll();
        model.addAttribute("bookList", bookList);

        return "book13";


    }


    @GetMapping("/book12/{id}")
    public String detail(@PathVariable long id, Model model) {

        Book book = bookMybatisService.findById(id);
        if (book == null) {
            throw new BookNotFoundException("书单信息不存在");
        }
        model.addAttribute("book", book);
        return "book12";
    }




    @PostMapping("/book13")
    public String post(Book book, final RedirectAttributes attributes) {
        if(book.getId() != null)
        {
            bookMybatisService.update(book);
            attributes.addFlashAttribute("message","<"+book.getName()+">信息提交成功");
        }
        else
        {
            bookMybatisService.save(book);
            attributes.addFlashAttribute("message","<"+book.getName()+">信息提交成功");
        }
        return "redirect:/book13";
    }




    @GetMapping("/book13/input")
    public String inputPage(Model model) {
        model.addAttribute("book", new Book());
        return "input";
    }

    @GetMapping("/book13/{id}/input")
    public String inputEditPage(@PathVariable long id, Model model) {
        Book book = bookMybatisService.findById(id);
        model.addAttribute("book", book);
        return "input";



    }

    @GetMapping("/book13/{page}/{size}")
    public String  getStudentByArray(@PathVariable("page") int page, @PathVariable("size") int size,Model model) {

//        List<Book> book = bookMybatisService.queryBookByArray(page, size);

//        int lastIndex = Math.min(size * page,book.size());

        int totalBooks = bookMybatisService.findAll().size();
        int lastIndex = (int) Math.ceil((double) totalBooks/size);
        List<Book> book = bookMybatisService.queryBookByArray(page, size);


        model.addAttribute("bookList",book);
        model.addAttribute("page",page);
        model.addAttribute("size",size);
        model.addAttribute("lastIndex",lastIndex);
        return "book13";
    }







}
