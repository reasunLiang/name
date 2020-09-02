package com.lyx.IO;

import com.lyx.Collection.TreeSet.Person;
import java.io.*;
import java.util.Scanner;

/**
 * @Package: com.lyx.IO
 * @ClassName: demo21_PrintStream
 * @Author: LYX
 * @CreateTime: 2020/8/29 14:36
 * @Description:
 */
public class demo21_PrintStream {
    public static void main(String[] args) throws IOException {
//        demo1();
//        demo2();
//        demo3();
//        deno4();
//        demo5();
//        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
//            //InputStreamReader类是从字节流到字符流的桥接器，它使用指定的字符集读取字节并将它们解码为字符。
//        String line = br.readLine();
//        System.out.println(line);
//        br.close();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        sc.close();
    }

    private static void demo5() throws IOException {
        FileInputStream pis= new FileInputStream("back/aaa.txt");
        FileOutputStream pfs = new FileOutputStream("back./bbb.txt");

        int b;
        while ((b = pis.read()) != -1){
            pfs.write(b);
        }
        pfs.close();
    }

    private static void deno4() throws IOException {
        System.setIn(new FileInputStream("back/aaa.txt"));      //改变标准输入流
        System.setOut(new PrintStream("back/bbb.txt"));     //改变标准输出流
        InputStream is = System.in;                               //获取标准的键盘输入流，默认指向键盘，改变后指向文件
        PrintStream ps = System.out;                               //获取标准的键盘输出流，默认指向的是控制台，改变后指向文件

        int b;
        while ((b = is.read()) != -1){
            ps.write(b);
        }
    }

    private static void demo3() throws IOException {
        InputStream is = System.in;
        int x = is.read();
        System.out.println(x);
        is.close();

        InputStream is2 = System.in;
        int y = is2.read();
        System.out.println(y);
    }

    private static void demo2() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream("back/f.txt"),true);
        //pw.println(97);       //自动刷出功能只针对的是println方法
        //pw.write(97);
        pw.print(97);
        pw.println(97);
    }

    private static void demo1() {
        PrintStream ps = System.out;
        ps.println(97);       //获取标注输出流
        ps.write(97);       //查找码表，找到对应的a并打印,关流的时候才会被打印出来
        Person p1 = new Person("张山",23);
        ps.println(p1);
        Person p2 = null;
        ps.println(p2);
        ps.close();
    }
}
