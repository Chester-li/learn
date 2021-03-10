package com.learn.mybatis.pojo;

import java.util.Date;

import lombok.Data;

/**
 * @author chaoshuai.li
 * @date 2021/3/9
 * @description
 */
@Data
public class Employee {

    private long id;
    private String userName;
    private int age;
    private int sex;
    private Date birthday;
    private Date created;
    private Date updated = new Date();

}
