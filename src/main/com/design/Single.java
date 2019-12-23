package com.design;

public class Single {
    //1.私有化构造器
    private Single(){}
    //2定义一个类变量
    public  static  Single instance;
    //3.获取一个对象
    public static synchronized Single getInstance() {
        if (instance == null) {
            instance = new Single();
        }
        return instance;
    }

    public static void main(String[] args) {
        Single instance = Single.getInstance();
        Single instance2 = Single.getInstance();
        System.out.println("instance:"+instance);
        System.out.println("instance2:"+instance2);
    }
}
