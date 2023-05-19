package com.softusing.joe.controller;

//import com.softusing.Jia.entity.Book;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/v1")
public class HelloController {

    //    @Autowired
//    private Book book;
    @PostMapping("/say")
    public String hello() {
        return "hello";
    }

    @GetMapping("/books")
    @ResponseBody
    public Object getAll(@RequestParam("page") int page, @RequestParam(value = "size", defaultValue = "10") int size) {
        Map<String, Object> book = new HashMap<>();
        book.put("name", "aaa");
        book.put("isbn", "1234567890");
        book.put("author", "bbb");
        Map<String, Object> book2 = new HashMap<>();
        book2.put("name", "aaa");
        book2.put("isbn", "1234567890");
        book2.put("author", "bbb");
        List<Map> contents = new ArrayList<>();
        contents.add(book);
        contents.add(book2);

        Map<String, Object> pagemap = new HashMap<>();
        pagemap.put("page", page);
        pagemap.put("size", size);
        pagemap.put("contents", contents);

        return pagemap;
    }

    @GetMapping("/books/{id}")
    public Object getOne(@PathVariable long id) {
        return null;
    }

    @PostMapping("/books")
    public Object post(@RequestParam("name") String name,
                       @RequestParam("author") String author,
                       @RequestParam("isbn") String isbn) {
        Map<String, Object> book = new HashMap<>();
        book.put("name", name);
        book.put("author", author);
        book.put("isbn", isbn);

        return book;



    }
}
