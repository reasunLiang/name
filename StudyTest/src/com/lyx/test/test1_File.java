package com.lyx.test;

import java.io.File;
import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * @Package: com.lyx.test
 * @ClassName: test1_File
 * @Author: LYX
 * @CreateTime: 2020/9/1 20:15
 * @Description: 需求：1.从键盘接收一个文件夹路径，统计该文件夹大小
 *
 *  从键盘接受一个文件夹路径
 *  1，创建键盘录入对象
 *  2，定义一个无线循环
 *  3，将键盘录入的结果存储并封装成File对象
 *  4，对File对象判断
 *  5，将文件夹路径对象返回
 *
 *  统计该文件夹大小
 *  1，定义一个求和变量
 *  2.获取该文件夹下的所有文件和文件夹listFiles()
 *  3，遍历数组
 *  4，判断是文件就计算大小并累加
 *  5，判断是文件夹，递归调用
 */
public class test1_File {
    public static void main(String[] args) {
        File dir = getDir();
        System.out.println(getFileLength(dir));
    }

    public static File getDir(){
        //1，创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入文件夹路径：");

        //2，定义一个无线循环
        while(true){
            //3，将键盘录入的结果存储并封装成File对象
            String line = sc.nextLine();
            File dir = new File(line);

            //4,对对象进行判断
            if(dir.isFile()){
                System.out.println("您输入的是一个文件路径，请输入文件夹路径：");
            }
            else if(!dir.exists()){
                System.out.println("您录入的文件夹路径不存在，请输入一个文件夹路径：");
            }else {
                //5,将文件夹路径返回。
                return dir;
            }
        }
    }

   //    1，定义一个求和变量
   //  2.获取该文件夹下的所有文件和文件夹listFiles()
    public static long getFileLength(File dir){
        //
        int len = 0;
        File[] subFiles = dir.listFiles();
        for(File subFile : subFiles ){
            if(subFile.isFile()){
                 len += subFile.length();
            }
            else{
                len += getFileLength(subFile);
            }
        }
        return len;
    }
}
