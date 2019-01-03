package com.lewis.optional;

import java.util.Optional;

/**
 * @author: draem0507
 * @date: 2019-01-03 14:19
 * @desc: Optional
 */
public class Test {


    public static void main(String[] args) {

        Integer value1=null;
        Optional optional= Optional.ofNullable(value1);
        System.out.println(optional.isPresent());
        Integer value2=2;

        Optional optiona2= Optional.ofNullable(value2);

        System.out.println( add(optional,optiona2));


    }

    public static int add(Optional<Integer>a,Optional<Integer>b){

        int x =a.isPresent()?a.get():0;

        int y =b.isPresent()?b.get():0;
        return x+y;

    }

}
