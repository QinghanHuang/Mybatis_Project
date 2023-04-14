package com.library.mapper;

import com.library.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface Mapper {
    @Insert("Insert into student(grade,s_name,sex) values(#{grade},#{sName},#{sex})")
    int addStudent(Student student);

    @Insert("Insert into book(book_info,price) values(#{bookInfo},#{price})")
    int addBook(Book book);


    @Select("select * from student ")
    List<Student> showStudentInfo();

    @Select("select * from book ")
    List<Book> showBookInfo();

    @Select("select * from student where sid=#{sid}")
    Student getStudentBySid(int sid);

    @Select("select * from book where bid=#{bid}")
    Book getBookByBid(int bid);

    //多个参数要增加注解
    //@Param 后面对应的是 #{}的行参
    @Insert("Insert into borrow(sid,bid) values(#{s},#{b})")
    int addBorrow(@Param("s") int sid, @Param("b") int bid);


    @Results({
            @Result(column = "borrow_id",property = "borrowId",id = true),
            @Result(column = "sid", property = "student", one =@One(select = "getStudentBySid")),
            @Result(column = "bid", property = "book", one =@One(select = "getBookByBid"))
    })
    @Select("select * from borrow ORDER BY sid")
    List<Borrow> showBorrowInfo();

}
