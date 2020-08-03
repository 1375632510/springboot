package cn.analysys.demo.service;

import cn.analysys.demo.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> selectPage(int pagenum);

    int deleteById(int id);

    int insret(Book book);

    int update(Book book);

    Book selectById(int id);
}
