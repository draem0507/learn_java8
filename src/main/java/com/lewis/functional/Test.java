package com.lewis.functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-01-02 21:25
 * @desc: 函数式接口
 *
 * <p>函数式接口(Functional Interface)就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
 * 函数式接口可以被隐式转换为 lambda 表达式。</p>
 * @refer http://www.runoob.com/java/java8-functional-interfaces.html
 */
public class Test {

    public static void main(String[] args) {
        GreetingService greetingService = message -> System.out.println("hello:" + message);
        greetingService.sayMessage("lwx");
        List<Integer>list = Arrays.asList(1,2,3);
        Predicate<Integer> allPredicate=(n)->true;
        eval(list,allPredicate);
        eval(list, n->n%2==0);
        list.stream().filter(allPredicate).forEach(System.out::println);

    }


    public static void eval(List<Integer> list, Predicate<Integer> integerPredicate) {

        list.forEach((n) -> {
            if(integerPredicate.test(n)){
                System.out.println(n);
            }
        });


    }

}

@FunctionalInterface
interface GreetingService {

    void sayMessage(String message);


    static void hi(){};//允许定义静态方法

    default void dosomething(){}//允许有默认实现

    @Override
     boolean equals(Object object );//包含对Java.lang.Object中public 方法的继承

}

 interface Vehicle {
    default void print(){
        System.out.println("我是一辆车!");
    }
    // 静态方法
    static void blowHorn(){
        System.out.println("按喇叭!!!");
    }
}
interface FourWheeler {
    default void print(){
        System.out.println("我是一辆四轮车!");
    }
}
class Car implements Vehicle, FourWheeler {
    public void print(){
        Vehicle.super.print();
        FourWheeler.super.print();
        Vehicle.blowHorn();
        System.out.println("我是一辆汽车!");
    }
}