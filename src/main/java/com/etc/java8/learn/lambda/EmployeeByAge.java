package com.etc.java8.learn.lambda;

/**
 * @Author:zrd
 * @Description:
 * @Date:2018-8-6 23:08
 */
public class EmployeeByAge implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getAge()>=35;
    }
}
