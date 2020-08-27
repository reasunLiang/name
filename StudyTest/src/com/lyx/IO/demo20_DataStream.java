package com.lyx.IO;

import java.io.*;

/**
 * @Package: com.lyx.IO
 * @ClassName: demo20_DataStream
 * @Author: LYX
 * @CreateTime: 2020/8/27 17:25
 * @Description:
 */
public class demo20_DataStream {

    public static void main(String[] args) throws IOException {
//        demo();
        DataInputStream dis = new DataInputStream(new FileInputStream("back/e.txt"));
        int b;

        System.out.println(dis.readInt());
        System.out.println(dis.readInt());
        System.out.println(dis.readInt());
        dis.close();
    }

    private static void demo() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("back/e.txt"));
        dos.writeInt(998);
        dos.writeInt(992);
        dos.writeInt(994);
        dos.close();
    }
}
