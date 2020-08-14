package com.lyx.Collection.Map;

import com.lyx.Collection.TreeSet.Student;

import java.util.*;

/**
 * @Package: com.lyx.Collection.Map
 * @ClassName: TreeMapStu
 * @Author: LYX
 * @CreateTime: 2020/8/2 16:13
 * @Description:
 */
public class TreeMapStu {
    public static void main(String[] args) {

//        demo();
        demo2();
    }

    private static void demo2() {
        //将字符串的中出现的字符统计出现的次数
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> tm = new HashMap<>();
        for (char c : chars) {
            tm.put(c, !tm.containsKey(c) ? 1 : tm.get(c) + 1);
        }

        System.out.println(tm);
    }

    //TreeMap比较器（Comparator）的使用，一级Student的实现Comparable
    private static void demo() {
        TreeMap<Student, String> tm = new TreeMap<>((o1, o2) -> {
            int num = o1.getAge() - o2.getAge();
            return num;
        });

        tm.put(new Student("张三", 23), "上海");
        tm.put(new Student("李四", 13), "北京");
        tm.put(new Student("王五", 43), "广州");
        tm.put(new Student("赵六", 33), "深圳");
        System.out.println(tm);
    }
}
