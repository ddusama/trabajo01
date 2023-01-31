package com.distribuida.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.jakarta.rs.json.annotation.JSONP;
import jakarta.ws.rs.Consumes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {

    private int id;
    private String isbn;

    private Author author;
    private String title;
    private double price;

}
