package com.design;

/**
 * 单例模式是一种对象创建模式，用于生产一个对象的实例，它可以确保系统中一个类只产生一个实例，这样做有两个好处：
 *
 * 1.对于频繁使用的对象，可以省略创建对象所花费的时间，这对于那些重量级对象而言，是非常可观的一笔系统开销。
 *
 * 2.由于new操作的次数减少，所以系统内存的使用评率也会降低，这将减少GC压力，缩短GC停顿时间
 */
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

    private static class SingletonHolder {
        private static final Single INSTANCE = new Single();
    }

    public Single getInstance2() {
        return SingletonHolder.INSTANCE;
    }

}
