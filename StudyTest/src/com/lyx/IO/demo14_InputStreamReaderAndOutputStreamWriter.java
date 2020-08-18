package com.lyx.IO;

import com.sun.source.tree.CaseTree;

import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @Package: com.lyx.IO
 * @ClassName: demo14_InputStreamReaderAndOutputStreamWriter
 * @Author: LYX
 * @CreateTime: 2020/8/19 17:02
 * @Description:
 */
public class demo14_InputStreamReaderAndOutputStreamWriter {
    public static void main(String[] args) throws IOException {
//        demo1();
//        demo2();
        TreeMap<Character, Integer> tm = new TreeMap<>();
        BufferedReader fr = new BufferedReader(new InputStreamReader(new FileInputStream("back/xxx.txt"), "utf-8"));
        int ch;
        while ((ch = fr.read()) != -1) {
            char c = (char) ch;
            tm.put(c, !tm.containsKey(c) ? 1 : tm.get(c) + 1);

        }
        fr.close();
        System.out.println(tm);
        BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("back/times.txt"), "utf-8"));

        for(Character c : tm.keySet()){
            switch (c){
                case '\t':
                    fw.write("\\t" + "=" + tm.get(c));
                    break;
                case '\n':
                    fw.write("\\n" + "=" + tm.get(c));
                    break;
                case '\r':
                    fw.write("\\r" + "=" + tm.get(c));
                    break;
                default:
                    fw.write(c + "=" + tm.get(c));
                    break;
            }
            fw.newLine();
        }
        fw.close();
    }

    private static void demo2() throws IOException {
        BufferedReader br =          //更高效的读
                new BufferedReader(new InputStreamReader(new FileInputStream("back/utf-8.txt"), "utf-8"));
        BufferedWriter bw =         //更高效的写
                new BufferedWriter(new OutputStreamWriter(new FileOutputStream("back/gbk.txt"), "GBK"));

        int c;
        while ((c = br.read()) != -1) {
            bw.write(c);
        }
        br.close();
        bw.close();
    }

    private static void demo1() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("back/utf-8.txt"), "utf-8");        //指定码表读字符
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("back/gbk.txt"), "GBK");        //指定码表写字符
        int c;
        while ((c = isr.read()) != -1) {
            osw.write(c);
        }
        isr.close();
        osw.close();
    }
}
