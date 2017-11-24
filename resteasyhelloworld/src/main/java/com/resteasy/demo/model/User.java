package com.resteasy.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by chaoshuai.li on 2017/11/23.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String uri;
}
