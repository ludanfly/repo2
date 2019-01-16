package com.itheima.service;

import com.itheima.bean.User;
import com.itheima.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserServiceTest {

    private UserService userService;

    @Before
    public void init(){
        //核心容器
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
        //获取业务层对象
       // userService =(UserService) applicationContext.getBean("userServiceImpl");
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);
    }

    @Test
    public void add() throws SQLException {
        //创建用户对象
        User user = new User();
        user.setUsername("张翠山");
        user.setAddress("金融港");
        user.setSex("男");
        user.setBirthday(new Date());

        userService.add(user);
    }

    @Test
    public void update() throws SQLException {
        //创建用户对象
        User user = new User();
        user.setId(45);
        user.setUsername("张无忌");
        user.setAddress("金融港");
        user.setSex("男");
        user.setBirthday(new Date());

        userService.update(user);
    }

    @Test
    public void delete() throws SQLException {

        userService.delete(45);
    }

    @Test
    public void findById() throws SQLException {
        User user = userService.findById(45);
        System.out.println(user);
    }

    @Test
    public void findAll() throws SQLException {
        List<User> users = userService.findAll();
        System.out.println(users);
    }
}