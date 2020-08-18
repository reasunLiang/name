package com.lyx.IO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Package: com.lyx.IO
 * @ClassName: demo10_copyFileWriter
 * @Author: LYX
 * @CreateTime: 2020/8/18 10:29
 * @Description:
 */
public class demo10_copyFileWriter {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("aaa.txt");
        FileWriter fw = new FileWriter("zzz.txt");
        int c ;
        while ((c = fr.read()) != -1){
            fw.write(c);
        }
        fr.close();
        fw.close();
    }
}
