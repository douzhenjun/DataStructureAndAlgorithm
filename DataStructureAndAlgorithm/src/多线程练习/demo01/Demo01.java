package 多线程练习.demo01;

/**
 * 案例题目
 * 编程创建两个线程，线程一负责打印1 ~ 100之间的所有奇数，其中线程二负责打印1 ~ 100之间的
 * 所有偶数。
 * 在main方法启动上述两个线程同时执行,主线程等待两个线程终止。
 */
public class Demo01 {
    public static void main(String[] args) {
        Thread thread01 = new Thread01();

        Thread thread02 = new Thread02();

        thread01.start();

        thread02.start();
    }
}
