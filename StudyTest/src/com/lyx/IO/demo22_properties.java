package com.lyx.IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @Package: com.lyx.IO
 * @ClassName: demo22_properties
 * @Author: LYX
 * @CreateTime: 2020/9/1 19:26
 * @Description:
 */
public class demo22_properties {
    public static void main(String[] args) throws IOException {
//        demo1();
        Properties prop = new Properties();
        System.out.println("读取前：" + prop);
        prop.load(new FileReader("back/properties.properties"));
        System.out.println("读取后：" + prop);
        prop.setProperty("qq","11001100110");   //修改的是内存中的数据，而不是写在硬盘上的数据。所以properties.properties文件没有被修改
        System.out.println("修改后：" + prop);
        /*读取前：{}
        读取后：{qq=1013201390, telephone=17621806946, username=lyx}
        修改后：{qq=110011001100, telephone=17621806946, username=lyx}*/
        prop.store(new FileWriter("back/properties.properties"),"XXXOOO");      //ＸＸＸＯＯＯ这个属性是文件注释。会写在文件中，
    }

    private static void demo1() {
        Properties prop = new Properties();
        prop.setProperty("name", "张三");
        prop.setProperty("tel", "115226622");

//        System.out.println(prop);       //输出 {name=张三, tel=115226622}
        Enumeration<String> en = (Enumeration<String>) prop.propertyNames();
        while (en.hasMoreElements()) {
//            System.out.println(en.nextElement());     //读取枚举中的元素
            String key = en.nextElement();      //获取Properties中的每一个键
            String value = prop.getProperty(key);       //根据键获取值
            System.out.println(key + " : " + value);
        }
    }

}
