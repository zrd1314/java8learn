package com.etc.java8.learn.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:zrd
 * @Description:
 * @Date:2018-8-6 22:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private String name;
    private  Integer age;
    private double salary;
}
