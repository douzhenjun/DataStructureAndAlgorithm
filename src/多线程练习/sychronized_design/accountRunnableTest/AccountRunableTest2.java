package 多线程练习.sychronized_design.accountRunnableTest;

/**
 * 为了避免AccountRunnableTest的线程不安全问题,可以让t1执行完以后t2再执行.但这样会使得多线程失去了意义.
 * 我们希望多线程的同步依然能够实现,同时保证线程1再取款操作完成之前线程2不能进行取款操作
 * (可以进行别的不影响数据安全的操作)
 *
 */
public class AccountRunableTest2 {
    public static void main(String[] args) {
        AccountRunnableTest art = new AccountRunnableTest(1000);
        Thread t1 = new Thread(art);
        Thread t2 = new Thread(art);

        t1.start();

        try {
            t1.join();
            t2.start();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("最终的账户余额为:"+art.getBalance());
    }
}
