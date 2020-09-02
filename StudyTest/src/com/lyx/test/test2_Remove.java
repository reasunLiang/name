package com.lyx.test;

import java.io.File;

/**
 * @Package: com.lyx.test
 * @ClassName: test2_Remove
 * @Author: LYX
 * @CreateTime: 2020/9/2 10:11
 * @Description: 需求：2.从键盘接受一个文件夹路径，删除该文件夹
 *
 * 删除该文件夹
 * 分析：
 * 1.获取改文件夹下的所有的文件和文件夹
 * 2.遍历数组
 * 3.判断是文件直接删除
 * 4.如果是文件夹，递归掉调用
 * 5.循环结束后，把控文件夹删掉
 */
public class test2_Remove {
    public static void main(String[] args) {
        File dir = test1_File.getDir();
        remove(dir);
    }

    public static void remove(File dir){
        File[] fs = dir.listFiles();
        for(File f : fs ){
            if(f.isFile()){
                f.delete();
                System.out.println(f.getName() + "文件已被删除");
            }
            else{
                remove(f);
            }
        }
        dir.delete();
        System.out.println(dir.getName() + "文件夹已被删除");
    }


}
