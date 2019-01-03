package com.lewis.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2018-12-21 16:32
 * @desc: 类描述
 */
public class Test {

    public static void main(String[] args) {

        //MAP
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());

        /**
         * filter
         */
        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 获取空字符串的数量
        long count = strings.stream().filter(string -> string.isEmpty()).count();


        /**
         * limit
         */

        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

        /**
         * sorted
         */
        random.ints().limit(10).sorted().forEach(System.out::println);

        /**
         * Collectors
         * Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。Collectors 可用于返回列表或字符串：
         */

        int sum = strings.stream().filter(b -> b.contains("a")).sorted((a, b) -> a.length() - b.length()).mapToInt(String::length).sum();
        System.out.println(sum);
        List<String> list = strings.stream().filter(b -> b.contains("a")).sorted((a, b) -> a.length() - b.length()).collect(Collectors.toList());
        list.forEach(System.out::println);

        /**
         * Statistics
         */

        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();


        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());


        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

    }
}

class Student {
    private String name;
    private Double score;

    public Student(String name, Double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Double getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "{"
                + "\"name\":\"" + name + "\""
                + ", \"score\":\"" + score + "\""
                + "}";
    }

    public void test1() {
        List<Student> studentList = new ArrayList<Student>() {
            {
                add(new Student("stu1", 100.0));
                add(new Student("stu2", 97.0));
                add(new Student("stu3", 96.0));
                add(new Student("stu4", 95.0));
            }
        };
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o1.getScore(), o2.getScore());
            }
        });
        System.out.println(studentList);
    }


}

