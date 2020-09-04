package com.lyx.test;

import java.io.*;

/**
 * @Package: com.lyx.test
 * @ClassName: test3_Copy
 * @Author: LYX
 * @CreateTime: 2020/9/2 13:59
 * @Description:    需求3 ：从键盘录入两个文件夹路径，将其中一个文件夹中（包含内容）copy到另一个文件夹中
 */
public class test3_Copy {
    public static void main(String[] args) throws IOException {

        File dest = test1_File.getDir();
        File dir = test1_File.getDir();
        if(dest.equals(dir)){
            System.out.println("目标文件是源文件夹的子文件夹。");
        }
        else{
            Copy(dest,dir);
        }
    }

    public static void Copy(File dest, File dir) throws IOException {
        //在目标路径创建文件夹。
        File newDir = new File(dest,dir.getName());
        newDir.mkdir();

        //获取文件夹下的路径，储存在File数组中
        File[] listFiles = dir.listFiles();
        //遍历数组
        for(File file : listFiles){
            if(file.isFile()){
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(newDir,file.getName())));
                int b;
                while ((b=bis.read()) != -1){
                    bos.write(b);
                }
                bos.close();
                bis.close();
            }
            else{
                Copy(newDir,file);
            }
        }
    }
}
