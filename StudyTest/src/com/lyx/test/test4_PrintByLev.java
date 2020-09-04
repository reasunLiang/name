package com.lyx.test;

import java.io.File;

/**
 * @Package: com.lyx.test
 * @ClassName: test4_PrintByLev
 * @Author: LYX
 * @CreateTime: 2020/9/4 14:19
 * @Description:
 */
public class test4_PrintByLev {
    public static void main(String[] args) {
        File dir = test1_File.getDir();
        Print(dir, 0);
    }
    private static void Print(File dir, int lev) {
        File[] listFiles = dir.listFiles();
        for (File file : listFiles) {
            for (int i = 0; i < lev; i++) {
                System.out.print("    ");
            }
            System.out.println(file.getName());

            if (file.isDirectory()) {
                Print(file, lev + 1);
            }
        }
    }
}
