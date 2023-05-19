package com.softusing.joe.service;

import com.softusing.joe.domain.Book;

import java.util.List;

public interface BookMybatisInterface {

//    public List<Book> findAll();

    List<Book> queryBookByArray();


    List<Book> queryBookByArray(int currPage, int pageSize);
}
