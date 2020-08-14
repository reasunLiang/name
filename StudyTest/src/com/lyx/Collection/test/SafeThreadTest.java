package com.lyx.Collection.test;

import java.util.ArrayList;

/**
 * @Package: com.lyx.Collection.test
 * @ClassName: SafeThreadTest
 * @Author: LYX
 * @CreateTime: 2020/7/31 10:18
 * @Description:
 */
public class SafeThreadTest {

    public static void main(String[] args) throws InterruptedException {
        final ArrayList<Integer> arr = new ArrayList<>();
        new Thread(() -> {
            for(int i = 1 ;i < 100 ;i++) {
                arr.add(i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(()-> {
            for(int i = 100 ;i < 200 ;i++) {
                arr.add(i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(1000);
        for (int i = 0; i< arr.size() ;i++){
            System.out.println("这是第" +i + "个元素"  +  arr.get(i));
        }
    }
}