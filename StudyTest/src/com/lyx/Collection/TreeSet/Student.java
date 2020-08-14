package com.lyx.Collection.TreeSet;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * @Package: com.lyx.Collection.TreeSet
 * @ClassName: Student
 * @Author: LYX
 * @CreateTime: 2020/7/31 15:26
 * @Description:
 */
public class Student{
    private String name;
    private int Chinese;
    private int math;
    private int english;
    private int age;

    public Student(String name, int chinese, int math, int english) {
        this.name = name;
        Chinese = chinese;
        this.math = math;
        this.english = english;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChinese() {
        return Chinese;
    }

    public void setChinese(int chinese) {
        Chinese = chinese;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", Chinese=" + Chinese +
                ", math=" + math +
                ", english=" + english +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getChinese() == student.getChinese() &&
                getMath() == student.getMath() &&
                getEnglish() == student.getEnglish() &&
                Objects.equals(getName(), student.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getChinese(), getMath(), getEnglish());
    }
    public int getCount(){
        System.out.println(this.name + "总成绩是 ： " + (this.Chinese + this.english + this.math));
        return this.Chinese + this.english + this.math;
    }

//    @Override
//    public int compareTo(@NotNull Student o) {
//        int num = this.age - o.age;
//        return num;
//    }
}
