package com.learn.mybatis.dao.impl;

import com.learn.mybatis.dao.EmployeeDao;
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

import static org.junit.Assert.*;

public class EmployeeDaoImplTest {

    private EmployeeDao employeeDao;
    private SqlSession sqlSession;

    @Before
    public void setUp() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        employeeDao = new EmployeeDaoImpl(sqlSession);
    }

    @Test
    public void queryUserById() {
        Employee employee = employeeDao.queryUserById(1);
        System.out.println(employee);
    }

    @Test
    public void queryUserAll() {
        List<Employee> employees = employeeDao.queryUserAll();
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
        employeeDao.insert(employee);
        sqlSession.commit();
    }

    @Test
    public void update() {
        Employee employee = new Employee();
        employee.setAge(10);
        employee.setSex(1);
        employee.setUserName("ibm");
        employee.setBirthday(new Date());
        employee.setId(6);
        employeeDao.update(employee);
        sqlSession.commit();
    }

    @Test
    public void deleteById() {
        employeeDao.deleteById(6);
        sqlSession.commit();
    }
}