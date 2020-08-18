package com.lyx.IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.lyx.IO
 * @ClassName: demo11_BufferReaderOrWriter
 * @Author: LYX
 * @CreateTime: 2020/8/19 14:57
 * @Description:
 */
public class demo11_BufferReaderOrWriter {
    public static void main(String[] args) throws IOException {
//        demo1();
//        memo2();
        BufferedWriter bw = new BufferedWriter(new FileWriter("revxxx.txt"));
        BufferedReader br = new BufferedReader(new FileReader("xxx.txt"));
        String line;
        List<String> arr = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            arr.add(line);
        }
        for (int i = arr.size() - 1; i >= 0; i--) {
            bw.write(arr.get(i));
            bw.newLine();
        }
        bw.close();
        br.close();
    }

    private static void memo2() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("aaa.txt"));
        BufferedReader br = new BufferedReader(new FileReader("xxx.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();           //写出回车换行符，跨平台  \r\n只支持的是windows系统
        }
        br.close();
        bw.close();
    }

    private static void demo1() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("xxx.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}
