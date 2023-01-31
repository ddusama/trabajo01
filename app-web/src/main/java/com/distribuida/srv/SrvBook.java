package com.distribuida.srv;

import com.distribuida.dto.Book;
import java.util.List;

public interface SrvBook {
    List<Book> findAll();
    Book findById(int id);
    void deleteBook(int id);
    void updateBook(int id, Book book);
    void createBook( Book book);


}
