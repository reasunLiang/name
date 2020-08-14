package com.lyx.Collection.Map;

import com.lyx.Collection.TreeSet.Student;
import com.lyx.Collection.test.Collection;

import java.util.*;

/**
 * @Package: com.lyx.Collection.Map
 * @ClassName: HashMapHashMap
 * @Author: LYX
 * @CreateTime: 2020/8/6 11:16
 * @Description:
 */
public class HashMapHashMap {
    public static void main(String[] args) {
        /**
         *HashMap和Hashtable的区别
         */
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("d");
        list.add("b");
        list.add("f");
        list.add("e");
        Collections.sort(list);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
    }
}
