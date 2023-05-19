package com.softusing.joe.service;


import com.softusing.joe.domain.Book;
import com.softusing.joe.domain.BookExample;
import com.softusing.joe.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service("BookMybatisInterface")
@Service
public class BookMybatisService {

    @Autowired
    private BookMapper bookMapper;

    public int save(Book book) {
        return bookMapper.insert(book);
    }

    public int update(Book book) {
        return bookMapper.updateByPrimaryKey(book);
    }

    public int delete(long id) {
        return bookMapper.deleteByPrimaryKey(id);
    }

    public Book findById(long id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    public List<Book> findAll() {
        return bookMapper.selectByExample(new BookExample());
    }



    public List<Book> queryBookByArray(int currPage, int pageSize) {
        //查询全部数据
        List<Book> book = bookMapper.queryBookByArray();
        //从第几条数据开始
        int firstIndex = (currPage - 1) * pageSize;
        //到第几条数据结束
        int lastIndex = Math.min(currPage * pageSize,book.size());
     /*   if(lastIndex > book.size())
        {
            lastIndex = book.size();
        }*/
        return book.subList(firstIndex, lastIndex); //直接在list中截取




    }


}
