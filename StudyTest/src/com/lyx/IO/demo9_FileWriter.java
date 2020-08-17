package com.lyx.IO;

import java.io.*;

/**
 * @Package: com.lyx.IO
 * @ClassName: demo9_FileWriter
 * @Author: LYX
 * @CreateTime: 2020/8/17 17:28
 * @Description: 在电脑D盘下创建一个文件为HelloWorld.txt文件，
 * 判断他是文件还是目录，再创建一个目录IOTest,
 * 之后将HelloWorld.txt移动到IOTest目录下去；
 * 之后遍历IOTest这个目录下的文件
 */
public class demo9_FileWriter {
    public static void main(String[] args) {
//        demo1();
        File file1 = new File("D:/","HelloWorld.txt");
        File file2 = new File("D:/","IOTest");
        File file3 = new File(file2.getPath() + "/" + file1.getName());
        Boolean isCreate;
        try {
            isCreate = file1.createNewFile();
            if (isCreate) {
                System.out.println("文件创建成功");
            } else {
                System.out.println("文件未创建成功");
            }
            if (file1.isFile()) {
                System.out.println("HelloWorld.txt 是文件");
            } else {
                System.out.println("HelloWorld.txt 是文件夹");
            }
            if (file2.mkdirs()) {
                System.out.println("文件夹创建成功");
            } else {
                System.out.println("文件夹未创建成功");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(file1.renameTo(file3)){
            System.out.println("移动成功");
        }
        else{
            System.out.println("移动不成功");
        }

        String[] s = file2.list();
        for (String c : s) {
            System.out.println(c);
        }

    }

    private static void demo1() throws IOException {
        //没有文件会创建，。
        FileWriter fw = new FileWriter("yyy.txt");
        fw.write("大家好，基础班快接近尾声了，大家要努力，要坚持！！");
        fw.close();
    }
}
