package com.etc.java8.learn.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * @Author:zrd
 * @Description:
 * @Date:2018-8-6 20:57
 */
public class TestLambda {

    @Test
    public void getRunnable(){
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("runnable is running");
            }
        };
        runnable.run();
    }

    @Test
    public void useRunnable(){
      Runnable runnable =  () -> {
            System.out.println("runnable is running");
        };
      runnable.run();
    }

    @Test
    public void testComparator(){
        Comparator<Integer> integerComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        TreeSet<Integer> treeSet  = new TreeSet<>(integerComparator);
        treeSet.add(8);
        treeSet.add(3);
        treeSet.add(7);
        treeSet.add(5);
        treeSet.add(1);
        System.out.println(treeSet);
    }

    @Test
    public void useLambdaComparator(){
        Comparator<Integer> integerComparator =  (x,y) ->-Integer.compare(x,y);
        TreeSet<Integer> treeSet  = new TreeSet<>(integerComparator);
        treeSet.add(8);
        treeSet.add(3);
        treeSet.add(7);
        treeSet.add(5);
        treeSet.add(1);
        System.out.println(treeSet);
    }


   static  List<Employee> employeeList;
    static {
        employeeList = new ArrayList<>();
        employeeList.add(new Employee("小明",25,2000.33));
        employeeList.add(new Employee("晶晶",42,5555.55));
        employeeList.add(new Employee("红红",35,6666.88));
        employeeList.add(new Employee("凉凉",38,8887.78));

    }
    //获取年龄大于35的员工信息
    @Test
    public void testEmployee(){
        employeeList.stream()
                     .filter((e) ->  e.getAge()>=35 )
                     .forEach(System.out::println);

    }
    //使用 设计模式 之 策略模式实现
    @Test
    public void testusepattern(){
        List<Employee> employees = new ArrayList<>();
        for(Employee employee:employeeList){
            if(new EmployeeByAge().test(employee)){
                employees.add(employee);
            }
        }
        for (Employee e:employees){
            System.out.println(e);
        }
    }

    @Test
    public void testusepattern2(){
        List<Employee> employees = new ArrayList<>();
        for(Employee employee:employeeList){
            //使用匿名内部类
           if(new MyPredicate() {
                @Override
                public boolean test(Object t) {
                    Employee e = (Employee) t;
                    return e.getAge()<35;
                }
            }.test(employee)){
               employees.add(employee);
           }

        }
        for (Employee e:employees){
            System.out.println(e);
        }
    }
}
