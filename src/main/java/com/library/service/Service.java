package com.library.service;

import com.library.entity.*;
import com.library.utils.SqlUtil;
import lombok.extern.java.Log;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;

@Log
public class Service {
    public static void addStudent(Scanner scanner) {

        System.out.print("The Name of student: ");
        String name = scanner.nextLine();

        System.out.print("The Sex of student(male/female): ");
        String sex = scanner.nextLine();

        System.out.print("The Grade of student(1/2/3): ");
        String grade = scanner.nextLine();

        Student student = new Student(grade, name, sex);
        try {
            SqlUtil.doSqlWork(mapper -> {
                int i = mapper.addStudent(student);
                if (i > 0) {
                    log.info("add a student: " + student);
                    System.out.println("Student input success!");
                } else {
                    System.out.println("Student input failed!");
                }
            });
        } catch (Exception e) {
            System.out.println("Invalid Input,Please Try Again");
        }
    }

    public static void addBook(Scanner scanner) {

        System.out.print("The Info of book: ");
        String bookInfo = scanner.nextLine();

        System.out.print("The Price of book: ");
        Double price = scanner.nextDouble();

        Book book = new Book(bookInfo, price);

        try {
            SqlUtil.doSqlWork(mapper -> {
                int i = mapper.addBook(book);
                if (i > 0) {
                    log.info("add a book: " + book);
                    System.out.println("Book input success!");
                } else {
                    System.out.println("Book input failed!");
                }
            });
        } catch (Exception e) {
            System.out.println("Invalid Input,Please Try Again");
        }
    }

    public static void addBorrow(Scanner scanner) {

        System.out.print("The SID of Student: ");
        String sid = scanner.nextLine();

        System.out.print("The BID of book: ");
        String bid = scanner.nextLine();

        try {
            SqlUtil.doSqlWork(mapper -> {
                int i = mapper.addBorrow(Integer.parseInt(sid), Integer.parseInt(bid));
                if (i > 0) {
                    log.info("add a borrow info: " + sid + '\t' + bid);
                    System.out.println("Borrow Info input success!");
                } else {
                    System.out.println("Borrow Info input failed!");
                }
            });
        } catch (Exception e) {
            System.out.println("Invalid Input,Please Try Again");
        }
    }


    public static void showStudentInfo() {
        System.out.println("The Student Info show below: ");
        System.out.println("==============================");
        System.out.println("SID\tNAME\tSEX\tGRADE");
        SqlUtil.doSqlWork(mapper -> {
            List<Student> students = mapper.showStudentInfo();
            for (int i = 0; i < students.size(); i++) {
                System.out.print(students.get(i).getSid() + "\t");
                System.out.print(students.get(i).getSName() + '\t');
                System.out.print(students.get(i).getSex() +'\t');
                System.out.println(students.get(i).getGrade());
            }
        });
    }


    public static void showBookInfo() {
        System.out.println("The Book Info show below: ");
        System.out.println("==============================");
        System.out.println("BID\tBOOKINFO\tPRICE");
        SqlUtil.doSqlWork(mapper -> {
            List<Book> books = mapper.showBookInfo();
            for (int i = 0; i < books.size(); i++) {
                System.out.print(books.get(i).getBid() + "\t");
                System.out.print(books.get(i).getBookInfo() + "\t\t");
                System.out.println(books.get(i).getPrice());
            }
        });
    }

    public static void showBorrowInfo() {
        System.out.println("The Borrow Info show below: ");
        System.out.println("==============================");
        System.out.println("BORROWID\tSTUDENT\t\tBOOK");
        SqlUtil.doSqlWork(mapper -> {
            List<Borrow> borrowList=mapper.showBorrowInfo();
            for (int i = 0; i < borrowList.size(); i++) {
                System.out.print(borrowList.get(i).getBorrowId()+"\t\t");
                System.out.print(borrowList.get(i).getStudent().getSName()+"\t\t");
                System.out.println(borrowList.get(i).getBook().getBookInfo());
            }
        });

    }
}