package com.lyx.IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Package: com.lyx.IO
 * @ClassName: demo17_ByteArrayOutputSream
 * @Author: LYX
 * @CreateTime: 2020/8/21 20:05
 * @Description:   内存输出流
 *
 * FileInputSrteam读取中文的时候出现了乱码
 *
 * 解决方法
 * 1.用字符流
 * 2.用byteArrayOutputStream
 */
public class demo17_ByteArrayOutputSream {
    public static void main(String[] args) throws IOException {
//        demo1();
        FileInputStream fis = new FileInputStream("back/xxx.txt");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len;
        byte[] bytes = new byte[5];
        while((len = fis.read(bytes)) != -1){
            baos.write(bytes,0,len);            //写入ByteArrayOutputStream，最后一次性输出。
//            System.out.println(new String(bytes,0,len)); //使用普通的方法读取的时候，就会出错。
        }
        System.out.println(baos);
        fis.close();
    }

    private static void demo1() throws IOException {
        FileInputStream fis = new FileInputStream("back/xxx.txt");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();   //在内存中创建了可以增长的内存数组

        int b ;
        while ((b = fis.read()) != -1 ){
            baos.write(b);
        }
        byte[] bytes = baos.toByteArray();          //将缓冲区的数据全部获取出来，并赋值给arr数组
        System.out.println(new String(bytes));
        fis.close();
    }
}
