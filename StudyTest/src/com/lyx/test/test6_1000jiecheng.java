package com.lyx.test;

import java.math.BigInteger;

/**
 * @Package: com.lyx.test
 * @ClassName: test6_1000jiecheng
 * @Author: LYX
 * @CreateTime: 2020/9/4 19:28
 * @Description:
 */
public class test6_1000jiecheng {
    public static void main(String[] args) {

        BigInteger bi = new BigInteger("1");
        for(int i = 1 ; i<= 1000; i++){
            BigInteger bi2 = new BigInteger(i + "");
            bi = bi.multiply(bi2);
        }
        String str = bi.toString();
        int count = 0;
        for(int i = 0; i < str.length() ;i ++ ){
            if('0' == str.charAt(i)){
                count++;
            }
        }
        System.out.println(count);
        System.out.println(bi);
    }
}
