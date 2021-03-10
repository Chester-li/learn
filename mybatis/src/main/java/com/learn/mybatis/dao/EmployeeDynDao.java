package com.learn.mybatis.dao;

import com.learn.mybatis.pojo.Employee;

import java.util.List;

/**
 * @author chaoshuai.li
 * @date 2021/3/10
 * @description
 */
public interface EmployeeDynDao {

    Employee findById(long id);

    List<Employee> findAll();

    int insert(Employee employee);

    void update(Employee employee);

    void deleteById(long id);

}
