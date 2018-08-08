package com.etc.java8.learn.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author:zrd
 * @Description:
 * @Date:2018-8-8 22:11
 *
 * 1   方法引用的条件 为 ： 当函数式接口的 方法的参数列表和返回值  和 Lambda体中 已 实现的方法 的 参数列表和 返回值 一样 才可以使用 方法引用
 *  方法引用的 以下几种 表现形式
 *  对象::实例方法名
 *  类名:静态方法名
 *
 *  2   构造器 引用
 *  表现形式为  ClassName::new
 *  条件为 函数式接口的 方法的参数列表 要与 对应的构造器 的 参数列表要相同
 *  3  数组引用
 *  type[]::n
 */
public class 方法引用和构造器引用 {

    @Test
    public void test1(){
        Consumer<Integer> consumer = (x)  -> System.out.println(x);
        //使用方法引入
        Consumer<Integer> consumer1 = System.out::println;
        consumer1.accept(222);

    }

    @Test
    public void test2(){
        Employee e = new Employee("韩瑶",23,9000);
        Supplier<String> stringSupplier = () -> e.getName();
        //使用方法引用
        Supplier<String> stringSupplier1 = e::getName;
        System.out.println(stringSupplier.get()+"=="+stringSupplier1.get());
    }
    // 类名:静态方法名
    @Test
    public void  test3(){
        //使用Lambda 实现 接口
        Comparator<Integer> comparator = (x,y) -> Integer.compare(x,y);
        //使用方法 引用  类名::静态方法名
        Comparator<Integer> comparator1 =  Integer::compare;
        System.out.println(comparator1.compare(4, 5));
    }

    //类::实例方法名
    @Test
    public void test4(){
        //判断2个字符串是否相等
        //使用Lambda 实现 接口
        BiPredicate<String,String> biPredicate = (x,y) -> x.equals(y);
        //使用方法 引用  类名::实例方法名 (这样的使用条件为 第一个参数为 实例方法的调用者，第二个 参数为 实例方法的参数时才可以使用 )
        BiPredicate<String,String> biPredicate1 = String::equals;
        System.out.println(biPredicate1.test("hanyao", "hanyao"));

    }


    @Test
    public void test5(){
        //Lambda 实现 接口

        Supplier<Employee> supplier = () -> new Employee();
        //使用构造器引用 类名::new
//        Supplier<Employee> supplier1 = Employee::new;
//        System.out.println(supplier.get().hashCode()+"===="+supplier1.get().hashCode());
        Employee  e1 = new Employee();
        Employee  e2 = new Employee();
        System.out.println(e1.equals(e2) );

    }

    //数组引用
    @Test
    public void test6(){
        Function<Integer,Integer[]> function = (x) -> new Integer[x];
        //使用数组引用
        Function<Integer,Integer[]> function1 = Integer[]::new;
        System.out.println("数组的长度为" + function1.apply(10).length);

    }

}
