package com.lyx.File;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @Package: com.lyx.File
 * @ClassName: demo4_filter
 * @Author: LYX
 * @CreateTime: 2020/8/12 14:55
 * @Description:
 */
public class demo4_filter {
    public static void main(String[] args) {
//        demo1();

        File file = new File("D:\\壁纸");
        String[] arr = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File file1 = new File(dir,name);
                return file1.isFile() && file1.getName().endsWith(".JPG");
            }
        });
        for(String a : arr ){
            System.out.println(a);
        }
    }

    @NotNull
    private static File demo1() {
        File file = new File("D:\\壁纸");
        File[] files = file.listFiles();
        for(File file1 : files){
            if(file1.getName().endsWith(".JPG")){
                System.out.println(file1);
            }
        }
        return file;
    }
}
