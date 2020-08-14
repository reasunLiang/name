package com.lyx.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Package: com.lyx.IO
 * @ClassName: demo2_Copy
 * @Author: LYX
 * @CreateTime: 2020/8/13 9:33
 * @Description:
 */
public class demo2_Copy {
    public static void main(String[] args) throws IOException {
//        demo();
        FileInputStream fis = new FileInputStream("4fcea9eeba889.jpg");     //创建输入流，键盘，鼠标等外部设备往内存写
        FileOutputStream fos = new FileOutputStream("copy.jpg");    //创建输出流，内存王外存写s

        //采用一个中间数组读一次写一次
        int len = fis.available();              //获取文件的所有的字节数
        System.out.println(len);
        byte[] arr = new byte[len];                 //创建一个和字节数相同的字节数组
        fis.read(arr);                               //将图片一次性读出到数组里
        fos.write(arr);
        fis.close();
        fos.close();

    }

    private static void demo() throws IOException {
        FileInputStream img = new FileInputStream("4fcea9eeba889.jpg");     //创建输入流，键盘，鼠标等外部设备往内存写
        FileOutputStream fos = new FileOutputStream("copy.jpg");    //创建输出流，内存王外存写

        int b;
        while ((b = img.read()) != -1) {        //不断读取每个字节
            fos.write(b);                   //将每个字节写出
        }
        img.close();        //关闭，释放资源
        fos.close();
    }
}
