package com.lyx.Collection.test;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Random;

/**
 * @Package: com.lyx.Collection
 * @ClassName: RandomDiff
 * @Author: LYX
 * @CreateTime: 2020/7/30 10:32
 * @Description:
 */
public class RandomDiff {
    public static void main(String[] args) {
        Date d = new Date();
        Random random = new Random(d.getTime());
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        while(lhs.size()<=10){
            lhs.add(random.nextInt(20) + 1);
        }
        System.out.println(lhs);
    }
}
