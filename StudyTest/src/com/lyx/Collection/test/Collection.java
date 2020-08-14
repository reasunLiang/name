package com.lyx.Collection.test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @Package: com.lyx
 * @ClassName: Collection
 * @Author: LYX
 * @CreateTime: 2020/7/30 9:47
 * @Description:
 */
public class Collection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入去重字符串：");
        String s =sc.nextLine();
        LinkedHashSet<Character> lhs = new LinkedHashSet<>();
        char[] arr = s.toCharArray();

        for(char a : arr){
            lhs.add(a);
        }
        System.out.println(lhs);
    }
}
