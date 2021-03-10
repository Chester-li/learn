package com.learn.mybatis.dao;

import com.learn.mybatis.pojo.Employee;

import java.util.List;

/**
 * @author chaoshuai.li
 * @date 2021/3/10
 * @description
 */
public interface EmployeeDao {

    Employee queryUserById(long id);

    List<Employee> queryUserAll();

    void insert(Employee employee);

    void update(Employee employee);

    void deleteById(long id);

}
