package com.library.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Book {
    private int bid;
    private String bookInfo;
    private double price;

    public Book(String bookInfo, double price) {
        this.bookInfo = bookInfo;
        this.price = price;
    }
}
