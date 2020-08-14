package com.lyx.Collection.Map;

import com.lyx.Collection.TreeSet.Student;
import java.util.TreeMap;

/**
 * @Package: com.lyx.Collection.Map
 * @ClassName: LinkedHashMap
 * @Author: LYX
 * @CreateTime: 2020/8/2 16:09
 * @Description:
 */
public class LinkedHashMap_ {
    public static void main(String[] args) {
//        demo();
        System.out.println('\ufeff');
    }

    private static void demo() {
        TreeMap<Student,String> lhp = new TreeMap<>();
        lhp.put(new Student("张三",23),"上海");
        lhp.put(new Student("李四",13),"北京");
        lhp.put(new Student("王五",43),"广州");
        lhp.put(new Student("赵六",33),"深圳");
        System.out.println(lhp);
    }
}
