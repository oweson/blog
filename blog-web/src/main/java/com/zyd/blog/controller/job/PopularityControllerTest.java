package com.zyd.blog.controller.job;

import java.util.*;

public class PopularityControllerTest {
    public static void main(String[] args) {
        Random random = new Random();
        // todo SELECT * FROM `table` ORDER BY RAND() LIMIT 5

        //******************模拟文章主键*************************
        List<Integer> articleTotal = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if(i%2==0 || i%2==1 ){
                articleTotal.add(i);
            }

        }

        Set<Integer> integerSet = new HashSet<>();
        for (int i = 0; i < 23; i++) {
            int nextInt = random.nextInt(articleTotal.size());
            integerSet.add ( articleTotal.get(nextInt));

        }
        System.out.println(integerSet);
        //******************模拟文章主键*************************

//        List<Integer> list = new ArrayList<>(10);
//        for (int i = 0; i < 10; i++) {
//            int total = random.nextInt(10) + 1;
//            list.add(total);
//
//
//        }
//        System.out.println(list);
        // [8, 3, 10, 9, 10, 3, 5, 6, 9, 9]
        // [4, 2, 6, 8, 2, 1, 3, 3, 9, 8]
        // [8, 1, 6, 4, 2, 4, 10, 10, 4, 9]
        // [5, 1, 5, 4, 1, 2, 2, 8, 8, 6]
    }
}
