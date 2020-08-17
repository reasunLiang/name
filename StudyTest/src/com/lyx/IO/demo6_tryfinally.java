package com.lyx.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Package: com.lyx.IO
 * @ClassName: demo6_tryCatch
 * @Author: LYX
 * @CreateTime: 2020/8/17 11:42
 * @Description:
 */
public class demo6_tryfinally {
    public static void main(String[] args) throws IOException {
        //作用域，如果不赋值null;下面try中没有创建，fis就会出错
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("yyy.txt");
            fos = new FileOutputStream("zzz.txt");
            int b;
            while ((b = fis.read())!= -1){
                fos.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            //嵌套try
            try {
                if (fis != null)
                    fis.close();
            }
            finally {
                if(fos != null)
                    fos.close();
            }
        }
    }
}
