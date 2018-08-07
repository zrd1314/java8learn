package com.etc.java8.learn.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @Author:zrd
 * @Description:
 * @Date:2018-8-7 21:16
 *
 *  1 当 Lambda 表达式  有2 个 或以上 多个 参数  有返回值 并且 Lambda体中有多条语句 Lambda体需要有{}
 *  2 Lambda 体中 只有 一条语句  {} 和 return 可以省略
 *  3  当 -> 左侧 只有 一个 参数 时   ， () 可以不写
 *  4  Lambda 的 表达式 的 参数 类型可以不写 ， 因为 jvm 编译器可以通过上下文 推断出 数据类型，  称作类型推断
 *
 *  Lambda 需要“函数式接口” 的支持
 *  接口中只有 一个 抽象方法 使用 @FunctionalInterface
 */

public class Lambda基础语法 {


     // 无参无返回值
      //Lambda 跟 匿名内部类 用法基本 一致
    //     （为 函数式接口的 方法参数）->  （方法 的 要实现的功能）
    @Test
    public void test1(){
        Runnable r =  () -> System.out.println("Hello Lambda");
       // Runnable r =  () ->{};
        r.run();
    }

    // 无参无返回值  当只有一个 参数 时 ，左括号可以不写
    @Test
    public void test2(){
        Consumer<Integer> integerConsumer = (x) -> System.out.println("传入 函数式接口 Consumer 的 accept的值为"+x);
        integerConsumer.accept(1111);
    }

    //有参有返回值
    @Test
    public void test3(){
        Function<String,Employee> stringIntegerFunction = (x) -> {return new Employee("小黑",12,12.3);};
        System.out.println(stringIntegerFunction.apply("xx"));
    }
    //断言型
    @Test
    public void test4(){
        Predicate<Employee> stringPredicate =  (e) ->  e.getName().equals("hanyao");
        stringPredicate.test(new Employee("hanyao",23,8000));
    }


    // lambda 练习

    @Test
    public void test5(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("adc",78,2000.33));
        employeeList.add(new Employee("eqs",35,5555.55));
        employeeList.add(new Employee("eqr",35,6666.88));
        employeeList.add(new Employee("frqw",38,8887.78));
        employeeList.add(new Employee("qweqasass",35,5555.55));
        Comparator<Employee> employeeComparator = (e, e1) ->{
            if(e.getAge() == e1.getAge()){
                if(e.getName().hashCode() > e1.getName().hashCode()){
                    return 1;
                }
                return -1;
            }else{
                if(e.getAge() > e1.getAge()){
                    return 1;
                }
                return -1;
            }
        };
        Collections.sort(employeeList,employeeComparator);
        employeeList.forEach(System.out::println);

    }

    //年龄相同 按照 姓名比较
    @Test
    public void test6(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("adc",78,2000.33));
        employeeList.add(new Employee("eqs",35,5555.55));
        employeeList.add(new Employee("eqr",35,6666.88));
        employeeList.add(new Employee("frqw",38,8887.78));
        employeeList.add(new Employee("qweqasass",35,5555.55));
        Comparator<Employee> employeeComparator = (e1, e2) ->{
            if( e1.getAge() == e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }
            return e1.getAge().compareTo(e2.getAge());
        };
        Collections.sort(employeeList,employeeComparator);
        employeeList.forEach(System.out::println);

    }

    //练习 把 字符串 首字母大写  使用 函数式接口
    @Test
    public void test7(){
        String str ="hanyao";
        MyFunctionInterface myFunctionInterface = (s) -> s.substring(0,1).toUpperCase() + s.substring(1);
        System.out.println(myFunctionInterface.getValue(str));
    }


    public String  handlerString(String str , MyFunctionInterface myFunctionInterface){
      return   myFunctionInterface.getValue(str);
    }
    @Test
    public void test8(){
        System.out.println(handlerString("hanyao", (str) -> str.trim().substring(0, 2).toUpperCase() + str.trim().substring(2)));
    }
}
