package com.lyx.IO;

import java.io.*;

/**
 * @Package: com.lyx.IO
 * @ClassName: demo1_Stream
 * @Author: LYX
 * @CreateTime: 2020/8/12 19:03
 * @Description:
 */
public class demo1_Stream {
    public static void main(String[] args) throws IOException {
//        demo1();
//        demo2();
//        demo3();
        FileOutputStream fos = new FileOutputStream("xxx.txt",true); //append这个参数为真时，在write的时候采用追加的方式
        fos.write(100);
        fos.write(100);
        fos.write(100);
        fos.close();
    }

    private static void demo3() throws IOException {
        FileOutputStream fos = new FileOutputStream("xxx.txt");     //创建字节输出流对象，如果没有就自动创建一个
        fos.write(97);
        fos.write(98);
        fos.write(99);
        fos.close();
    }

    private static void demo2() throws IOException {
        FileInputStream fis = new FileInputStream("xxx.txt");
        int b ;
        while ((b = fis.read()) != -1) {
            System.out.println(b);
        }
        fis.close();
    }

    private static void demo1() {
        try {
            FileInputStream fileInputStream = new FileInputStream("xxx.txt");
            int x = fileInputStream.read();         //从硬盘上读取一个字节
            int y = fileInputStream.read();         //从硬盘上读取一个字节
            System.out.println(x + " " + y);           //文件结束标记为 -1
            fileInputStream.close();                //关流释放资源质押
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
