package com.lyx.test;

import java.util.Scanner;

/**
 * @Package: com.lyx.test
 * @ClassName: test5_Fibonacci
 * @Author: LYX
 * @CreateTime: 2020/9/4 15:45
 * @Description:

 * 故事得从西元1202年说起,话说有一位意大利青年 , 名叫斐波那契。
 * 在他的一部著作中提出了-一个有趣的问题:假设-对刚出生的小兔- 一个月后就能长成大兔,再过一个月就能生下一对小兔,并且此后每个月都生一对小兔,
 * 一年内没有发生死亡,问: 一对刚出生的兔子,一年内繁殖成多少对兔子?
 * 1 1 2 3 5 8 13
 * 第一个月一对小兔子                1
 * 第二个月一对大兔子                1
 * 第三个月一对大兔子生了-对小兔子     2
 * 第四个月一对大兔子生了一对小兔子     3
 * 一对小兔子长成大兔子
 * 第五个月两对大兔子生两对小兔子      5
 * 一对小兔子 长成大兔子
 */
public class test5_Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println( fun(sc.nextInt()));
    }

    public static int fun(int num){
        if(num == 1 || num == 2){
            return  1;
        }
        else{
            return fun(num-2) + fun(num - 1);
        }
    }
}
