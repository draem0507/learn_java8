package com.lewis.functional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-01-09 19:13
 * @desc: 类描述
 *
 *  使用案例
 * 布尔表达式
 * 创建对象
 * 消费一个对象
 * 从一个对象中 选择/提取
 * 合并两个值 比较两个对象
 * 表3-3 Lambdas及函数式接口的例子 Lambda 的例子
 * 对应的函数式接口
 * <p>
 *
 *  使用案例      lamdba布尔表达式  												 对应的函数式接口
 * 布尔表达式    (List<String>list)-->list.empty()				Predicate<List<String>>
 * 创建对象			() -> new Apple(10)											 Supplier<Apple>
 * 消费一个对象		(Apple a) ->
 * 							System.out.println(a.getWeight())				Consumer<Apple>
 *
 *
 * 从一个对象中    (String s) -> s.length()								Function<String, Integer>或
 * 选择/提取																								ToIntFunction<String>
 * 合并两个值			int(int a,  b) -> a * b									IntBinaryOperator
 * 							(Apple a1, Apple a2) ->
 * 比较两个对象		a1.getWeight().compareTo(a2.getWeight())			Comparator<Apple>或 BiFunction<Apple, Apple, Integer>
 * 																													或ToIntBiFunction<Apple, Apple>
 * </p>
 */
public class FunctionTest {

    public static void main(String[] args) {
        /**function 的基本调用*/
        Function<Integer,Integer> add=(x)->x+1;
        Function<Integer,Integer> mul=(x)->x*2;
        Function<Integer,Integer> then=add.andThen(mul);
        int result =then.apply(1);
        System.out.println(result);//4
        System.out.println(add.compose(mul).apply(1));//3

        //
        Comparator.comparing(FunctionTest::instantceMethod);//实例方法
        final Consumer<FunctionTest> staticMethod = FunctionTest::instantceMethod;
        Arrays.asList(1,2).forEach(FunctionTest::staticMethod);//静态方法
        Arrays.asList(1,2).forEach(System.out::println);//静态方法

    }

    private static void staticMethod(Integer integer) {
        System.out.println(integer.intValue());

    }


    public int  instantceMethod(){
        System.out.println("instantceMethod");
        return 1;
    }

}
