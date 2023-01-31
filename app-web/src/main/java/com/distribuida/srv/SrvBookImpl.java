package com.distribuida.srv;


import com.distribuida.dto.Author;
import com.distribuida.dto.Book;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpMethod.*;

@ApplicationScoped
public class SrvBookImpl implements SrvBook {

    private final String PATH_URL = "http://gateway:7070/book";

    @Inject
    RestTemplate restTemplate;

    @Override
    public List<Book> findAll() {

        var response = restTemplate
                .exchange(PATH_URL, GET, null, new ParameterizedTypeReference<List<Book>>() {
                });

        return response.getBody();
    }


    @Override
    public Book findById(int id) {
        ResponseEntity<Book> res = restTemplate.getForEntity(PATH_URL + "/" + id, Book.class);
        return res.getBody();
    }

    @Override
    public void deleteBook(int id) {
        restTemplate.delete(PATH_URL + "/" + id);
    }

    @Override
    public void updateBook(int id, Book book) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity entity = new HttpEntity(book, headers);
        restTemplate.exchange(PATH_URL + "/" + id, PUT, entity, Book.class);
    }

    @Override
    public void createBook(Book book) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity entity = new HttpEntity(book, headers);
        restTemplate.exchange(PATH_URL, POST, entity, Book.class);
    }

}
