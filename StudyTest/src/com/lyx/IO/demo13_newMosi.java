package com.lyx.IO;

/**
 * @Package: com.lyx.IO
 * @ClassName: demo13_newMosi
 * @Author: LYX
 * @CreateTime: 2020/8/19 16:13
 * @Description:
 */
public class demo13_newMosi {
    public static void main(String[] args) {
        yonyouStudent yy = new yonyouStudent(new Student());
        yy.getCode();
    }

}

interface Code{
    public void getCode();
}
class Student implements Code{
    @Override
    public void getCode() {
        System.out.println("JavaSE");
    }
}
class yonyouStudent implements Code{
    //1、获取被装饰类的引用
    private Student student;

    //2、在构造方法中传入被装饰类对象
    public yonyouStudent(Student student) {
        this.student = student;
    }
    //3、对原有的功能升级
    @Override
    public void getCode() {
        student.getCode();
        System.out.println("redis");
        System.out.println("tomcat");
        System.out.println("JavaWeb");
    }
}