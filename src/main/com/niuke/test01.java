package com.niuke;

/**
 *数据库基本问题
 * 1，acid是什么 原子性，一致性，隔离性，持久性
 * 只有满足一致性，事务的执行结果才是正确的。
 * 在无并发的情况下，事务串行执行，隔离性一定能够满足。此时只要能满足原子性，就一定能满足一致性。
 * 在并发的情况下，多个事务并行执行，事务不仅要满足原子性，还需要满足隔离性，才能满足一致性。
 * 事务满足持久化是为了能应对系统崩溃的情况。
 * https://cs-notes-1256109796.cos.ap-guangzhou.myqcloud.com/image-20191207210437023.png
 * 2.
 */
public class test01 {
    public static void main(String[] args) {
        int i;
        // i+=1;  //Variable 'i' might not have been initialized
    }
}