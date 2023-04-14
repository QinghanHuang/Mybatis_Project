package com.library.entity;

import lombok.*;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int sid;
    private String grade;
    private String sName;
    private String sex;

    public Student(String grade, String sName, String sex) {
        this.grade = grade;
        this.sName = sName;
        this.sex = sex;
    }
}
