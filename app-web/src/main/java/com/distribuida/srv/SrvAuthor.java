package com.distribuida.srv;

import com.distribuida.dto.Author;
import java.util.List;

public interface SrvAuthor {

    List<Author> findAll();
    Author findById(Long id);
    void deleteAuthor(Long id);
    void updateAuthor(Long id, Author author);
    void createAuthor( Author author);


}
