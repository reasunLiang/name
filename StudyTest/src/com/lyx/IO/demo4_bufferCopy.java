package com.lyx.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Package: com.lyx.IO
 * @ClassName: demo4_BufferCopy
 * @Author: LYX
 * @CreateTime: 2020/8/13 12:44
 * @Description:
 */
public class demo4_bufferCopy {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("xxx.mp4");
        FileInputStream fis = new FileInputStream("D:\\进击的巨人\\我是谁：\\我是谁：没有绝对安全的系统(蓝光中英双字幕.mp4");
        //创建缓冲流，对输入流进行包装让其变得更加强大
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        int b;
        while ((b = bis.read()) != -1){
                bos.write(b);
        }
        bis.close();
        bos.close();

    }
}
