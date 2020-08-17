package com.lyx.IO;

import java.io.FileReader;
import java.io.IOException;

/**
 * @Package: com.lyx.IO
 * @ClassName: demo8_FileReader
 * @Author: LYX
 * @CreateTime: 2020/8/17 17:14
 * @Description:
 */
public class demo8_FileReader {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("xxx.txt");
        int b;
        while ((b = fr.read()) != -1){
            System.out.print((char)b);
        }
        fr.close();
    }
}
