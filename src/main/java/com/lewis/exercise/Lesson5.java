package com.lewis.exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-01-11 19:03
 * @desc: 类描述
 */
public class Lesson5 {


    static List<Transaction> transactions = null;

    public static void init() {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

    }

    public static void main(String[] args) {
        init();

        // (1) 找出2011发生的所有交易，并按交易额排序(从低到高)。
        List<Integer> listfor2011 = transactions.stream().filter((transaction) -> transaction.getYear() == 2011).sorted(Comparator.comparing(Transaction::getTradValue)).map(Transaction::getTradValue).collect(Collectors.toList());


        //(2) 交易员都在哪些不同的城市工作过 ?

        transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().collect(Collectors.toList());
        //(3) 查找所有来自于剑桥的交易员，并按姓名排序。
        transactions.stream().map(Transaction::getTrader).filter(trader -> trader.getName().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());


        //(4) 返回所有交易员的姓名字符串，按字字母顺序排序。

       List<String>names= transactions.stream().map(transaction -> transaction.getTrader().getName()).distinct().sorted().collect(Collectors.toList());
       names.forEach(System.out::println);
       String name=transactions.stream().map(transaction -> transaction.getTrader().getName()).distinct().sorted().reduce("",(n1,n2)->n1+n2);
       System.out.println(name);

        //(5) 有没有交易员是在米兰工作的 ?
        boolean has=transactions.stream().anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        //(6) 打印生活在剑桥的交易员的所有交易额
        transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(transaction -> transaction.getTrader());
        // (7) 所有交易中，最高的交易额是多少 ?
        transactions.stream()
                .map(Transaction::getTradValue)
                .reduce(Integer::max);

        // (8) 找到交易额最小的交易。
        transactions.stream().reduce((t1,t2)->t1.getTradValue()>t2.getTradValue()?t1:t2);



    }


}

class Trader {

    private String name;
    private String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String toString() {
        return "Trader:" + this.name + " in " + this.city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

class Transaction {

    private Trader trader;

    private int year;
    private int tradValue;

    public Transaction(Trader trader, int year, int tradValue) {
        this.trader = trader;
        this.year = year;
        this.tradValue = tradValue;
    }

    public String toString() {
        return "{" + this.trader + ", " +
                "year: " + this.year + ", " +
                "tradValue:" + this.tradValue + "}";
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTradValue() {
        return tradValue;
    }

    public void setTradValue(int tradValue) {
        this.tradValue = tradValue;
    }
}