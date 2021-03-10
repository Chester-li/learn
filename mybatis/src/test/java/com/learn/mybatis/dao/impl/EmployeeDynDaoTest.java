package com.learn.mybatis.dao.impl;

import com.learn.mybatis.dao.EmployeeDao;
import com.learn.mybatis.dao.EmployeeDynDao;
import com.learn.mybatis.pojo.Employee;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class EmployeeDynDaoTest {

    EmployeeDynDao employeeDynDao;

    @Before
    public void setUp() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        employeeDynDao = sqlSession.getMapper(EmployeeDynDao.class);
    }

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
        employee.setId(7);
        employeeDynDao.update(employee);
    }

    @Test
    public void deleteById() {
        employeeDynDao.deleteById(7);
    }
}