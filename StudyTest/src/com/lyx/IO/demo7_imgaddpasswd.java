package com.lyx.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Package: com.lyx.IO
 * @ClassName: demo7_imgaddpasswd
 * @Author: LYX
 * @CreateTime: 2020/8/17 12:50
 * @Description:
 */
public class demo7_imgaddpasswd {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("copy.txt");
        FileOutputStream fos = new FileOutputStream("copy1.txt");
        int b;
        while((b = fis.read()) != -1){
            fos.write(b ^ 123);
        }
        fos.close();
        fis.close();
    }
}
