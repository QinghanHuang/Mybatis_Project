package com.library.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Borrow {
    private int borrowId;
    private Student student;
    private Book book;

    public Borrow(Student student, Book book) {
        this.student = student;
        this.book = book;
    }
}
