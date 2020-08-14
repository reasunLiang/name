package com.lyx.File;

import java.io.File;

/**
 * @Package: com.lyx.File
 * @ClassName: demo3_Rename
 * @Author: LYX
 * @CreateTime: 2020/8/12 11:24
 * @Description:
 */
public class demo3_Rename {
    public static void main(String[] args) {
//        demo();
        File dir = new File("D:\\U盘\\新建文件夹\\壁纸");
//        String[] arr = dir.list();
//        for (String a : arr) {
//            if (a.endsWith(".jpg") || a.endsWith(".JPG"))
//                System.out.println(a);
//        }
        File[] files = dir.listFiles();
        for (File f : files) {
            if(f.isFile() && f.getName().endsWith(".JPG"))
                System.out.println(f);
        }
    }

    private static void demo() {
        File file1 = new File("aaa");
        File file = new File("ccc\\aaa");
        System.out.println(file1.renameTo(file));
    }
}
