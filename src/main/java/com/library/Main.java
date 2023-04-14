package com.library;

import com.library.service.Service;
import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.LogManager;

/**
 * 1.导入dependency,设置mybatis-config(连接数据库)
 * 2.在数据库新建表格,在entity新建对应的类
 * 3.创建mapper接口,写实现sql的方法和注解,将mapper 添加到mybatis-config
 * 4.在sqlUtil里添加getSession或者doSql的方法(可以使用consumer传入mapper函数式编程)
 * 5.在主页面点用sqlUtil执行数据库操作
 * 6.添加日志系统
 * 6.1配置日志,使用properties
 * 6.2在main中使用logManager读取log配置
 * 6.3使用lombok log注解 开启注解
 * 7.
 */


public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            LogManager logManager = LogManager.getLogManager();
            logManager.readConfiguration(Resources.getResourceAsStream("logging.properties"));


            while (true) {
                System.out.println("==============================");
                System.out.println("1. Input Student Info");
                System.out.println("2. Input Book Info");
                System.out.println("3. Input Borrow Info");
                System.out.println("4. Show All Students Info");
                System.out.println("5. Show All Books Info");
                System.out.println("6. Show All Borrow Info");
                System.out.print("Please Input Index to operate(other key to exit): ");
                int input;
                try {
                    input = scanner.nextInt();
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                scanner.nextLine();
                switch (input) {
                    case 1:
                        Service.addStudent(scanner);
                        break;
                    case 2:
                        Service.addBook(scanner);
                        break;
                    case 3:
                        Service.addBorrow(scanner);
                        break;
                    case 4:
                        Service.showStudentInfo();
                        break;
                    case 5:
                        Service.showBookInfo();
                        break;
                    case 6:
                        Service.showBorrowInfo();
                        break;

                    default:
                        System.out.println("Exit,ByeBye!");
                        return;
                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
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




}
