package com.lyx.exception;

/**
 * @Package: com.lyx.exception
 * @ClassName: demo_finally
 * @Author: LYX
 * @CreateTime: 2020/8/10 9:51
 * @Description:
 */
public class demo_finally {
    public static void main(String[] args) throws Exception {
//        demo();
        System.out.println(demo2());

    }

    private static int demo2() {
        int x;
        try {
            x = 20;
            System.out.println(10 / 0);
            return x ;
        }catch (Exception e){
            x = 30;
            return x;
        }finally {
            x = 40;
            return x;
        }
    }

    private static void demo() throws Exception {
        try {
            System.out.println( 10 / 0);
        }catch (RuntimeException e){
            System.out.println("除数不能为0 ");
            Exception a =new Exception("不是吧");
            throw a;
        }finally {
            System.out.println("看看我执行了没");
        }
    }
}
