package com.crud.operation.model.java8;

import java.util.Arrays;
import java.util.List;

public class TestJava8 {
    public static void main(String[] args) {
//        MyFunction function = (i) -> i*10;
//        System.out.println(function.test(15));

//        MyFunction function = (s1, s2) -> s1 +":"+ s2;
//        System.out.println(function.test1("abc", "def"));
//
//        Function<Integer, String> function = (t)-> "output:"+t;
//        System.out.println(function.apply(90));

        // Print all numbers greater than 4 in sorted order using stream API
        List<Integer> list = Arrays.asList(23,4,6,8,9,1,2,10);

        list
                .stream()
                .filter(t -> t > 4)
                .sorted()
                .forEach(System.out::println);
    }
}
