package com.kuang.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


//sqlSessionFactory-->sqlSession
public class MybatisUtils {
    private static  SqlSessionFactory sqlSessionFactory;
    static {
        try {
            //使用mybatis
            // 是从类的根路径开始读取classes下面开始读的mybatis-config.xml正好在下面
            String resource="mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public  static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}