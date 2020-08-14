package com.lyx.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Package: com.lyx.IO
 * @ClassName: demo3_arrayCopy
 * @Author: LYX
 * @CreateTime: 2020/8/13 10:42
 * @Description:
 */
public class demo3_arrayCopy {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("xxx.mp4");
        FileInputStream fis = new FileInputStream("D:\\进击的巨人\\我是谁：\\我是谁：没有绝对安全的系统(蓝光中英双字幕.mp4");
//        demo();
//        FileInputStream fis = new FileInputStream("xxx.txt");
//        FileOutputStream fos = new FileOutputStream("aaa.txt");
        byte[] arr = new byte[1024 * 8];
        int len ;
        while ((len = fis.read(arr)) != -1){
             fos.write(arr,0,len);
        }
        fis.close();
        fos.close();
    }

    private static void demo() throws IOException {
        FileInputStream fis = new FileInputStream("xxx.txt");
        byte[] arr = new byte[2];
        int a = fis.read(arr);
        System.out.println(a);
        for (byte b : arr) {
            System.out.println(b);
        }

        int b = fis.read(arr);
        System.out.println(b);
        for (byte c : arr){
            System.out.println(c);
        }
    }
}
