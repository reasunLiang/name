package com.lyx.Collection.TreeSet;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Package: com.lyx.Collection.TreeSet
 * @ClassName: Demo1_TreeSet
 * @Author: LYX
 * @CreateTime: 2020/7/30 10:55
 * @Description:
 */
public class Demo1_TreeSet {
    /**
     * @parm arg
     * TreeSet集合是用来对象进行排序的，并且可以保证元素的唯一性。
     */
    public static void main(String[] args) {
//        demo1();
//        demo2();
//        demo3();
//        demo4();
    }

    private static void demo4() {
        TreeSet<String> ts = new TreeSet<>(new CompareByLen());
        ts.add("aaaaaaaa");
        ts.add("z");
        ts.add("mba");
        ts.add("WC");
        ts.add("cba");
        System.out.println(ts);
    }

    private static void demo3() {
        TreeSet<Person> ts = new TreeSet<>();
        ts.add(new Person("张三",12));
        ts.add(new Person("李四",12));
        ts.add(new Person("赵六",18));
        ts.add(new Person("王五",13));
        ts.add(new Person("王五",13));
        ts.add(new Person("赵六",12));
        System.out.println(ts);
    }

    private static void demo2() {
        TreeSet<Person> ts = new TreeSet<>();
        ts.add(new Person("张三",12));
        ts.add(new Person("李四",12));
        ts.add(new Person("王五",13));
        ts.add(new Person("王五",13));
        ts.add(new Person("赵六",12));
        System.out.println(ts);
    }

    private static void demo1() {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(3);
        ts.add(3);
        ts.add(1);
        ts.add(1);
        ts.add(1);
        ts.add(2);
        ts.add(2);
        ts.add(2);
        System.out.println(ts);
    }
}
class CompareByLen implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length() == 0 ? o1.compareTo(o2) : o1.length() - o2.length();
    }
}
