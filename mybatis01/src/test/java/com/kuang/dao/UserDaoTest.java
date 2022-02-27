package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


import java.util.List;
public class UserDaoTest {
    @Test
    public void test(){
        //第一步 ：获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行sql
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();
        for (User list: userList ) {
            System.out.println(list);
        }
        sqlSession.close();

    }

}