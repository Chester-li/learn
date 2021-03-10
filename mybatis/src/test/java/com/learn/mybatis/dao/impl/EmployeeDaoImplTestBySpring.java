package com.learn.mybatis.dao.impl;

import com.learn.mybatis.dao.EmployeeDynDao;
import com.learn.mybatis.pojo.Employee;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//junit整合spring的测试//立马开启了spring的注解
@ContextConfiguration(locations = "classpath:applicationConfig.xml")//加载核心配置文件，自动构建spring容器

public class EmployeeDaoImplTestBySpring {

    @Autowired
    EmployeeDynDao employeeDynDao;


    @Test
    public void queryUserById() {
        Employee employee = employeeDynDao.findById(1);
        System.out.println(employee);
    }

    @Test
    public void queryUserAll() {
        List<Employee> employees = employeeDynDao.findAll();
        System.out.println(employees);
    }

    @Test
    public void insert() {
        Employee employee = new Employee();
        employee.setAge(10);
        employee.setSex(1);
        employee.setUserName("abm");
        employee.setCreated(new Date());
        employee.setBirthday(new Date());
        int insertResult = employeeDynDao.insert(employee);
        System.out.println(insertResult);
    }

    @Test
    public void update() {
        Employee employee = new Employee();
        employee.setAge(10);
        employee.setSex(1);
        employee.setUserName("ibm");
        employee.setBirthday(new Date());
        employee.setId(9);
        employeeDynDao.update(employee);
    }

    @Test
    public void deleteById() {
        employeeDynDao.deleteById(7);
    }
}