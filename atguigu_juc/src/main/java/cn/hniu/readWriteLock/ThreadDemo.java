package cn.hniu.readWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <p>
 *  读写锁
 * </p>
 *
 * @author: liuxi
 * @date: 2020/8/23
 */
public class ThreadDemo {
    private int number = 0;

    // 读写锁
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    // 读
    public void get(){
        try {
            // 上读锁
            readWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " : " + number);
        } finally {
            // 释放读锁
            readWriteLock.readLock().unlock();
        }
    }

    // 写
    public void set(int number){
        try {
            // 上写锁
            readWriteLock.writeLock().lock();
            // 赋值
            this.number = number;
            System.out.println(Thread.currentThread().getName());
        }finally {
            // 释放写锁
            readWriteLock.writeLock().unlock();
        }
    }
}
