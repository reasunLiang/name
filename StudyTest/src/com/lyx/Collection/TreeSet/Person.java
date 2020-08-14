package com.lyx.Collection.TreeSet;


/**
 * @Package: com.lyx.Collection.TreeSet
 * @ClassName: Person
 * @Author: LYX
 * @CreateTime: 2020/7/30 11:01
 * @Description:
 */
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    

//    @Override
//    public int compareTo(Person o){
//        int num = this.age - o.age;
//        return this.name.compareTo(o.name) == 0 ? num:this.name.compareTo(o.name);
//    }
}
