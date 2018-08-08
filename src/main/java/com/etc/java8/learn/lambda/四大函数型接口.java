package com.etc.java8.learn.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author:zrd
 * @Description:
 * @Date:2018-8-8 21:11
 * 1 消费型接口 Consumer<T>  void accept(T t)
 * 2  供给型接口 Supplier<T>   T get()
 * 3 函数型接口  Function<T,R>  R apply(T t);
 *  4   断言型接口  Predicate<T>   boolean  test(T t)
 */
public class 四大函数型接口 {
    //消费型接口
    @Test
    public void testConsumer(){
        Consumer<Double> doubleConsumer = (x) -> System.out.println("消费了 "+x+"元");
        doubleConsumer.accept(1200.00);
    }
    //供给型接口
    @Test
    public void testSupplier(){
        Supplier<Employee> employeeSupplier = () -> new Employee("hy",23,8000.00);
        System.out.println("通过供给型接口获取到 "+employeeSupplier.get());
    }
    //函数型接口
    static List<Employee> employees  =new ArrayList<>();
    static {
        employees.add(new Employee("hy",23,8000));
        employees.add(new Employee("zrd",23,15000));
        employees.add(new Employee("hyzrd",26,23000));
    }
    @Test
    public void testFunction(){
        Function<Integer,List<Employee>> listFunction = x -> {
            List<Employee> employeeList = new ArrayList<>();
            employees.forEach((e) -> {
                if(e.getAge() == x){
                    employeeList.add(e);
                }
            });
            return employeeList;
        };
        System.out.println(listFunction.apply(23));
    }

    @Test
    public void testPredicate(){
        Predicate<Employee> employeePredicate = (e) -> e.getName().equals("hy");
        System.out.println(employeePredicate.test(new Employee("hy", 23, 6900)));
    }

    //随机产生10个整数
    @Test
    public void testRandonSupplier(){
       List<Integer> lists = handlerIntegr(10,()-> (int)(Math.random()*100));
        lists.forEach(System.out::println);
    }
    public List<Integer> handlerIntegr(int num,Supplier<Integer> supplier){
        List<Integer> radomList = new ArrayList<>();
        for (int i=0;i<num;i++){
            radomList.add(supplier.get());
        }
        return radomList;
    }

    //将满足条件的字符串放入集合中
    @Test
    public void testPre(){
        List<String> strings = Arrays.asList("hanyao","zrd","lixiaohui");
        handlerString(strings,(x) -> x.length()>4).forEach(System.out::println);
    }

    public List<String> handlerString(List<String> lists, Predicate<String> stringPredicate){
        List<String> strings = new ArrayList<>();
        for (String str : lists) {
            if(stringPredicate.test(str)){
                strings.add(str);
            }
        }
        return strings;

    }
}
