package com;

/**
 * 有一座高度是n级台阶的楼梯，从下往上走，每跨一步只能向上1级或者2级台阶。要求用程序来求出一共有多少种走法。
 */
public class SuanFa {

    static int fun(int n) {
        int num = 0;
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        } else {
            num = fun(n - 1) + fun(n - 2);
        }
        Object c = num;
        return num;
    }

    public static void main(String[] args) {
        int number = fun(20);
        System.out.println("number:"+number);
    }

}
 class Threads4{
    public static void main(String[] args){
//        new Threads4().go();
        System.out.println(17^5);

    }
    public void go(){
        Runnable r=new Runnable(){
            public void run(){
                System.out.print("foo");
            }
        };
        Thread t=new Thread(r);
        t.start();
    }
}