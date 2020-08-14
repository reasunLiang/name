package com.lyx.Collection.test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @Package: com.lyx.Collection
 * @ClassName: ArrayListDiff
 * @Author: LYX
 * @CreateTime: 2020/7/30 10:43
 * @Description:
 */
public class ArrayListDiff {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("a");
        al.add("a");
        al.add("a");
        al.add("a");
        al.add("a");
        al.add("b");
        al.add("a");
        al.add("a");
        al.add("a");
        al.add("c");
        al.add("c");
        al.add("c");
        al.add("c");
        al.add("D");
        al.add("d");
        al.add("d");
        al.add("d");
        al.add("d");
        al.add("b");
        getSingle(al);
        System.out.println(al);
    }

    private static void getSingle(List<String> al) {
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.addAll(al);
        al.clear();
        al.addAll(lhs);
    }
}
