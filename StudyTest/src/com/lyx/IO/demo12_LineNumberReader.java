package com.lyx.IO;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * @Package: com.lyx.IO
 * @ClassName: demo12_LineNumberReader
 * @Author: LYX
 * @CreateTime: 2020/8/19 15:29
 * @Description:
 */
public class demo12_LineNumberReader {
    public static void main(String[] args) throws IOException {
        LineNumberReader lnr = new LineNumberReader(new FileReader("./back/xxx.txt"));
        String line;
        lnr.setLineNumber(100);         //设置行号为100 ，从101开始打印
        while ((line = lnr.readLine()) != null) {
            System.out.println(lnr.getLineNumber() + ": " + line);      //在每行前面添加个行号
        }
        lnr.close();
    }
}
