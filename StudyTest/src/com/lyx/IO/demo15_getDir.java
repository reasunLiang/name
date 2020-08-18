package com.lyx.IO;

import java.io.File;

/**
 * @Package: com.lyx.IO
 * @ClassName: demo15_getDir
 * @Author: LYX
 * @CreateTime: 2020/8/20 16:13
 * @Description:
 */
public class demo15_getDir {
    public static void main(String[] args) {
        getDirection(new File("D:\\yonyou"));
    }

    private static void getDirection(File file) {
        File[] files = file.listFiles();
        if(file == null) return ;
        for (File l : files){
            if(!l.isFile()) {
                System.out.println("文件夹 ：" + l.getName());
                getDirection( l.getAbsoluteFile());
            }
            else{
                System.out.println("文件 ：" + l.getName());
            }
        }
    }
}



