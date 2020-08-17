package com.lyx.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Package: com.lyx.IO
 * @ClassName: demo5_Chinese
 * @Author: LYX
 * @CreateTime: 2020/8/17 10:57
 * @Description: 字节流和中文搭配的问题
 *
 */

public class demo5_Chinese {
    public static void main(String[] args) throws IOException {

//        demo();
        //写文件的时候是没有问题的
        FileOutputStream fos = new FileOutputStream("yyy.txt");
        fos.write("您好".getBytes());
        fos.close();
    }


    //读取中文。会出现乱码的时候，不管你创建的byte数组多契合编码中文的大小。也不能保证符号的问题。
    private static void demo() throws IOException {
        FileInputStream fis = new FileInputStream("aaa.txt");
        byte[] arr = new byte[4];
        int len;
        while ((len = fis.read(arr)) != -1){
            System.out.println(new String(arr,0,len));
        }
        fis.close();
    }
}
