package 多线程练习.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class InterruptiblyLock {
    public ReentrantLock lock1 = new ReentrantLock();//1.第一把所lock1
    public ReentrantLock lock2 = new ReentrantLock();//2.第二把锁lock2
    public Thread lock1(){
        Thread t = new Thread(new Runnable(){
            public void run(){
                try {
                    lock1.lockInterruptibly();//3.1如果当前线程未被中断,则获取锁
                    try {
                        Thread.sleep(500);//4.1这里执行具体的业务逻辑
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock2.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName()+",执行完毕!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally{
                    //5.1在业务逻辑执行结束后,检查当前线程是否持有该锁,如果持有则释放该锁
                    if(lock1.isHeldByCurrentThread()){
                        lock1.unlock();
                    }
                    if(lock2.isHeldByCurrentThread()){
                        lock2.unlock();
                    }
                    System.out.println(Thread.currentThread().getName()+",退出.");
                }
            }
        });
        t.start();
        return t;
    }

    public Thread lock2(){
        Thread t = new Thread(new Runnable(){
            public void run(){
                try{
                    lock2.lockInterruptibly();//3.2如果当前线程未被中断,则获取锁
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    lock1.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName()+",执行完毕!");
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    //5.2在业务逻辑执行结束后,检查当前线程是否保持该锁,如果持有则释放锁
                    if(lock1.isHeldByCurrentThread()){
                        lock1.unlock();
                    }
                    if(lock2.isHeldByCurrentThread()){
                        lock2.unlock();
                    }
                    System.out.println(Thread.currentThread().getName()+",退出.");
                }
            }
        });
        t.start();
        return t;
    }

    public static void main(String[] args) {
        Long time = System.currentTimeMillis();
        InterruptiblyLock interruptiblyLock = new InterruptiblyLock();
        Thread thread1 = interruptiblyLock.lock1();
        Thread thread2 = interruptiblyLock.lock2();
        //自旋一段时间,如果等待时间过长,则可能发生了死锁等问题,主动中断并释放锁
        while(true){
            if(System.currentTimeMillis() - time >= 3000){
                thread2.interrupt();
            }
        }
    }
}
