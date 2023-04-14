package com.test;

import com.library.entity.Book;
import com.library.entity.Student;
import com.library.utils.SqlUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MainTest {
    @Test
    public void test(){
        SqlUtil.doSqlWork(mapper -> {
            Book bookByBid = mapper.getBookByBid(6);
            System.out.println(bookByBid);
        });
    }
    @Test
    public void test1(){
        SqlUtil.doSqlWork(mapper -> {
            List<Book> books = mapper.showBookInfo();
            System.out.println(books);
        });
    }
    @Test
    public void test2(){
        SqlUtil.doSqlWork(mapper -> {
            List<Student> students = mapper.showStudentInfo();
            System.out.println(students);
        });
    }
}
