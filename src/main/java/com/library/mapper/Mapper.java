package com.library.mapper;

import com.library.entity.Book;
import com.library.entity.Student;
import org.apache.ibatis.annotations.Insert;

public interface Mapper {
    @Insert("Insert into student(grade,sname,sex) values(#{grade},#{sname},#{sex})")
    int addStudent(Student student);

    @Insert("Insert into book(bookinfo,price) values(#{bookinfo},#{price})")
    int addBook(Book book);
}
