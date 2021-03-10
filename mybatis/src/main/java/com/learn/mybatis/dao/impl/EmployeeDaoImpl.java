package com.learn.mybatis.dao.impl;

import com.learn.mybatis.dao.EmployeeDao;
import com.learn.mybatis.pojo.Employee;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author chaoshuai.li
 * @date 2021/3/10
 * @description
 */
public class EmployeeDaoImpl implements EmployeeDao {

    public SqlSession sqlSession;

    public EmployeeDaoImpl(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    @Override
    public Employee queryUserById(long id) {
        return sqlSession.selectOne("MyMapper.findEmployee", id);
    }

    @Override
    public List<Employee> queryUserAll() {
        return sqlSession.selectList("MyMapper.selectAll");
    }

    @Override
    public void insert(Employee employee) {
        sqlSession.insert("MyMapper.insert", employee);
    }

    @Override
    public void update(Employee employee) {
        sqlSession.update("MyMapper.update", employee);
    }

    @Override
    public void deleteById(long id) {
        sqlSession.delete("MyMapper.delete", id);
    }
}
