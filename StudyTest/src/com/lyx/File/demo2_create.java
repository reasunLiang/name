package com.lyx.File;

import java.io.File;
import java.io.IOException;

/**
 * @Package: com.lyx.File
 * @ClassName: demo2_create
 * @Author: LYX
 * @CreateTime: 2020/8/10 16:57
 * @Description:
 */
public class demo2_create {
    public static void main(String[] args) {
//        demo();
        File file = new File("ccc\\ddd");
        System.out.println(file.mkdirs());

    }

    private static void demo() throws IOException {
        File file = new File("aaa");
        System.out.println(file.createNewFile());
        File file1 = new File("aaa.txt");
        System.out.println(file1.mkdir());
    }
}
