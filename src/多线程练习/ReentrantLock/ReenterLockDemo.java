package 多线程练习.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class ReenterLockDemo implements Runnable {
    //1.定义一个ReentrantLock
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;
    @Override
    public void run() {
        for(int j = 0; j < 10; j++){
            //2.加锁
            lock.lock();
        }
        try {
            i++;
        } finally {
            //3.释放锁
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReenterLockDemo reenterlock = new ReenterLockDemo();
        Thread t1 = new Thread(reenterlock);
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i);
    }
}
