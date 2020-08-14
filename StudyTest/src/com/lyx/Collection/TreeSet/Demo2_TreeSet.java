package com.lyx.Collection.TreeSet;

import java.util.*;

/**
 * @Package: com.lyx.Collection.TreeSet
 * @ClassName: Demo2_TreeSet
 * @Author: LYX
 * @CreateTime: 2020/7/31 11:30
 * @Description:
 */
public class Demo2_TreeSet {
    public static void main(String[] args) {
//        demo1();
//        demo2();
//        demo3();
        TreeSet<Student> ts = new TreeSet<>((o1, o2) -> {
            int s1 = o1.getCount();
            int s2 = o2.getCount();
            return s1 - s2 == 0 ? -1 : s2 - s1;
        });
        int chinese,math,english;
        String name;
        Scanner in = new Scanner(System.in);
        for(int i = 0 ; i < 5 ; i++){
            System.out.println("请输入第" + (i+1) + "位学生的名字：");
            name = in.nextLine();
            System.out.println("请输入第" + (i+1) + "位学生的语文成绩：");
            chinese = in.nextInt();
            System.out.println("请输入第" + (i+1) + "位学生的数学成绩：");
            math = in.nextInt();
            System.out.println("请输入第" + (i+1) + "位学生的英语成绩：");
            english = in.nextInt();
            ts.add(new Student(name,chinese,math,english));
            in.nextLine();
        }
        System.out.println(ts);
    }



    private static void demo3() {
        TreeSet ts = new TreeSet((Comparator<String>) (o1, o2) -> {
            int s = Integer.parseInt(o2) - Integer.parseInt(o1);
            return s == 0 ? 1 : s;
        });
        Scanner in = new Scanner(System.in);
        System.out.println("输入整数录入，输入quit退出录入");
        String s = in.nextLine();
        while (!s.equals("quit")){
            ts.add(s);
            s = in.nextLine();
        }
        System.out.println("退出录入，下面是倒叙");
        System.out.println(ts);
    }

    private static void demo2() {
        String s = "dnfhgsifaunfdsadSFSASesafdadgfasgdsd";

        TreeSet<Character> ts = new TreeSet<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                int compare = o1.compareTo(o2);
                return compare == 0 ? 1 : compare;
            }
        });
        char[] c = s.toCharArray();
        System.out.println(c.length);
        for ( char a : c ) {
            ts.add(a);
        }

        System.out.println(ts);
        System.out.println(ts.size());
    }

    private static void demo1() {
        List<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("aaaa");
        list.add("aaaa");
        list.add("bbbb");
        list.add("bbbb");
        list.add("zzzz");
        list.add("zzzz");
        list.add("dddd");
        list.add("1234");
        TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int compare = o1.compareTo(o2);
                return compare ==0 ? 1 : compare;
            }
        });
        ts.addAll(list);
        System.out.println(ts);
    }
}

