package com.lyx.IO;

import com.lyx.Collection.TreeSet.Person;

import java.io.*;
import java.util.ArrayList;

/**
 * @Package: com.lyx.IO
 * @ClassName: demo19_ObjectStream
 * @Author: LYX
 * @CreateTime: 2020/8/26 13:56
 * @Description:
 */
public class demo19_ObjectStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        demo1();
//        demo2();
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("back/e.txt"));
//        Person p1 = new Person("张三",23);
//        Person p2 = new Person("李四",25);
//        Person p3 = new Person("王五",25);
//        Person p4 = new Person("赵六",26);
//        ArrayList<Person> arr = new ArrayList<>();
//        arr.add(p1);
//        arr.add(p2);
//        arr.add(p3);
//        arr.add(p4);
//        oos.writeObject(arr);
//        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("back/e.txt"));
        ArrayList<Person> arr = (ArrayList<Person>) ois.readObject();
        for (Person p : arr){
            System.out.println(p);
        }
        ois.close();
    }

    private static void demo2() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("back/e.txt"));
        Person person1 = (Person) ois.readObject();
        Person person2 = (Person) ois.readObject();
        System.out.println(person1);
        System.out.println(person2);
    }

    private static void demo1() throws IOException {
        Person p1 = new Person("张三",22);
        Person p2 = new Person("李四",23);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("back/e.txt"));
        oos.writeObject(p1);
        oos.writeObject(p2);
        oos.close();
    }
}
