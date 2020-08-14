package com.lyx.File;

import java.io.File;

/**
 * @Package: com.lyx.File
 * @ClassName: demo1_File
 * @Author: LYX
 * @CreateTime: 2020/8/10 16:06
 * @Description:
 */
public class demo1_File {
    public static void main(String[] args) {
//        demo();
//        demo2();
        File parent = new File("D:\\yonyou\\备份\\0810\\tomcat\\");
        File file = new File(parent,"ds-tomcat-9.0.31.tar.gz");
        System.out.println(file.exists());
    }

    private static void demo2() {
        File file = new File("D:\\yonyou\\备份\\0810\\tomcat\\", "xxx.txt");
        File file1 = new File("D:\\yonyou\\备份\\0810\\tomcat\\", "ds-tomcat-9.0.31.tar.gz");
        System.out.println(file.exists());
        System.out.println(file1.exists());
    }

    private static void demo() {
        File file = new File("D:\\yonyou\\备份\\0810\\tomcat\\ds-tomcat-9.0.31.tar.gz");
        System.out.println(file.exists());
        File file1 = new File("xxx.txt");
        System.out.println(file1.exists());
    }
}
