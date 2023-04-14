package com.library.utils;

import com.library.mapper.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.*;
import java.util.function.Consumer;

public class SqlUtil {
    //在类加载时就进行创建
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取一个新的会话
     * @param autoCommit 是否开启自动提交（跟JDBC是一样的，如果不自动提交，则会变成事务操作）
     * @return SqlSession对象
     */
    public static SqlSession getSession(boolean autoCommit){
        return sqlSessionFactory.openSession(autoCommit);
    }
    public static void doSqlWork(Consumer<Mapper> consumer){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        consumer.accept(mapper);


    }
}
