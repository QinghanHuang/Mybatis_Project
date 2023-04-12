package com.library.entity;

import lombok.*;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Student {
    private int sid;
    private final String grade;
    private final String sname;
    private final String sex;
}
