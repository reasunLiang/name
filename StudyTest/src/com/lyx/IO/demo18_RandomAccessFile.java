package com.lyx.IO;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.RandomAccess;

/**
 * @Package: com.lyx.IO
 * @ClassName: demo18_RandomAccessFile
 * @Author: LYX
 * @CreateTime: 2020/8/26 10:04
 * @Description:
 */
public class demo18_RandomAccessFile {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("back/randomAccessFile.txt","rw");
        raf.write(97);
        raf.write(97);
        raf.write(97);
        raf.write(97);
        raf.write(97);
        raf.write(97);
        raf.write(97);
        raf.write(97);
        raf.write(97);
        raf.write(97);
        raf.write(97);
        raf.write(97);
        raf.write(97);
        raf.write(97);
//        raf.close();
//        int x = raf.read();
//        System.out.println(x);
//        raf.close();
        raf.seek(10);                //在指定位置设置指针
        raf.write(98);
        raf.close();
    }
}
