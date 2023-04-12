package com.library;

import com.library.entity.Book;
import com.library.entity.Student;
import com.library.mapper.Mapper;
import com.library.utils.SqlUntil;
import org.apache.ibatis.session.SqlSession;

import java.util.Scanner;

/**
 * 1.导入dependency,设置mybatis-config(连接数据库)
 * 2.在数据库新建表格,在entity新建对应的类
 * 3.创建mapper接口,写实现sql的方法和注解,将mapper 添加到mybatis-config
 */
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("==============================");
                System.out.println("1. Input Student Info");
                System.out.println("2. Input Book Info");
                System.out.print("Please Input Index to operate(other key to exit): ");
                int input;
                try {
                    input = scanner.nextInt();
                    scanner.nextLine();
                    switch (input) {
                        case 1:
                            addStudent(scanner);
                            break;
                        case 2:
                            break;
                        default:
                            System.out.println("Exit,ByeBye!");
                            return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }

            }

        }


//        test
//        //1.获得sqlSession
//        SqlSession sqlSession = SqlUntil.getSession(true);
//        //2.通过接口获得实现类mapper
//        Mapper mapper = sqlSession.getMapper(Mapper.class);
//        //3.调用接口方法
////        int i = mapper.addStudent(new Student("1", "aaa", "male"));
////        System.out.println(i);
//
//        int i1 = mapper.addBook(new Book("test5", 11.5));
//        System.out.println(i1);

    }
    private static void  addStudent(Scanner scanner){

        System.out.print("Please input the Name of student: ");
        String name=scanner.nextLine();

        System.out.print("Please input the Sex of student(male/female): ");
        String sex = scanner.nextLine();

        System.out.print("Please input the Grade of student(1/2/3): ");
        String grade = scanner.nextLine();

        Student student=new Student(grade,name,sex);
        SqlUntil.doSqlWork(mapper -> {
            int i = mapper.addStudent(student);
            if(i>0){
                System.out.println("Student input success!");
            }else {
                System.out.println("Student input failed!");
            }
        });
    }
}
