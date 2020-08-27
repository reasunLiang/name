package com.lyx.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @Package: com.lyx.IO
 * @ClassName: demo16_SequenceInputStream
 * @Author: LYX
 * @CreateTime: 2020/8/21 10:20
 * @Description:
 */
public class demo16_SequenceInputStream {
    public static void main(String[] args) throws IOException {
//        demo1();
        FileInputStream fis1 = new FileInputStream("back/xxx.txt");
        FileInputStream fis2 = new FileInputStream("back/yyy.txt");
        FileInputStream fis3 = new FileInputStream("back/zzz.txt");

        Vector<FileInputStream> v = new Vector<>();     //创建集合对象
        v.add(fis1);                                    //将流对象存储进来
        v.add(fis2);
        v.add(fis3);
        Enumeration<FileInputStream> en = v.elements(); //获取枚举集合
        SequenceInputStream sis = new SequenceInputStream(en);

        FileOutputStream fos = new FileOutputStream("back/hhh.txt");
        int c;
        while ((c = sis.read()) != -1) {
            fos.write(c);
        }
        sis.close();
        fos.close();
    }

    private static void demo1() throws IOException {
        FileInputStream fis1 = new FileInputStream("back/xxx.txt");
        FileInputStream fis2 = new FileInputStream("back/yyy.txt");
        SequenceInputStream sis = new SequenceInputStream(fis1, fis2);
        FileOutputStream fos = new FileOutputStream("back/zzz.txt");

        int c;
        while ((c = sis.read()) != -1) {
            fos.write(c);
        }
        fos.close();
        sis.close();
    }
}
