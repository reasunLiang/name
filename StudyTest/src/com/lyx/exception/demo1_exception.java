package com.lyx.exception;

/**
 * @Package: com.lyx.exception
 * @ClassName: demo1_exception
 * @Author: LYX
 * @CreateTime: 2020/8/9 14:18
 * @Description:
 */
public class demo1_exception {

    public static void main(String[] args) {
//        demo();
//        demo2();
        int[] arr = {11,22,33,44,55};
        try {
            System.out.println(arr[10]);
            System.out.println(10 / 0 );
        }catch (ArithmeticException | ArrayIndexOutOfBoundsException e){
            System.out.println("出错了");
        }
    }

    private static void demo2() {
        int[] arr = {11,22,33,44,55};
        try{
            System.out.println( 10 / 0);
            System.out.println(arr[10]);
            arr = null;
            System.out.println(arr[0]);
        }catch (ArithmeticException e) {
            System.out.println("除数不能为零");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("索引越界了");
        }catch (Exception e){
            System.out.println("出错了");
        }
        System.out.println("over");
    }

    private static void demo() {
        try{
            int x = 10 / 0 ;        //这里出错了，给main处理 ，如果main没有try-cath的处理方式，就会调用jvm处理，在控制台上打印出异常
            System.out.println(x);
        }catch(ArithmeticException a){  //如果有try-catch的话，就会new出ArithmeticException给a接住。
            System.out.println("出错了，除数不能为零");
        }
    }
}
