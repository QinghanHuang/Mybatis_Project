package com.library.entity;

import lombok.Data;

@Data
public class Book {
    private int bid;
    private final String bookinfo;
    private final double price;
}
