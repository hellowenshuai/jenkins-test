package com.design;

public class Single {
    //1.私有化构造器
    private Single(){}
    //2定义一个类变量
    public  static volatile Single instance;
    //3.获取一个对象，存在效率问题，使用双重校验锁-线程安全
    public static Single getInstance() {
        if (instance == null) {
            //当对象未创建时，才进入到锁区域，避免无所谓的加锁操作
            synchronized (Single.class) {
                if (instance == null) {
                    instance = new Single();
                }
            }
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
