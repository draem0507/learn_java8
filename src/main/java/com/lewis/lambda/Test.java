package com.lewis.lambda;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-01-02 20:52
 * @desc: lambda学习
 * @<p> 可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
 * 可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
 * 可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
 * 可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值。
 * </p>
 * @refer http://www.runoob.com/java/java8-lambda-expressions.html
 */
public class Test {


    // 类型声明
    MathOperation addition = (int a, int b) -> a + b;

    // 不用类型声明
    MathOperation subtraction = (a, b) -> a - b;

    // 大括号中的返回语句
    MathOperation multiplication = (int a, int b) -> {
        return a * b;
    };

    // 没有大括号及返回语句
    MathOperation division = (int a, int b) -> a / b;


    GreetingService greetingService = message -> System.out.println("我爱你 " + message);
    GreetingService greetingService2 = (message) -> {
        System.out.println("i love you " + message);
    };

}

interface MathOperation {

    int operation(int a, int b);
}

interface GreetingService {
    void sayMessage(String message);
}