package 多线程练习.sychronized_design.accountRunnableTest;

/**
 * 在使用sychronized修饰对象时,同一时刻只能有一个线程对该对象进行访问,在synchronized修饰方法,代码块时,同一时刻
 * 只能由一个线程执行该方法体或代码块,其他线程只能等待当前线程执行完毕并且释放锁资源后才能访问改对象或执行同步代码块.
 */
public class AccountRunnableTest3 implements Runnable {

    int balance;

    private Demo demo = new Demo();

    public AccountRunnableTest3(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public void run() {
        synchronized (demo) {
            int temp = this.getBalance();
            if(temp >= 200){
                System.out.println("正在出钞,请稍候...");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                temp -= 200;
                this.setBalance(temp);
                System.out.println("取款成功!剩余金额为"+this.getBalance());
            }else{
                System.out.println("取款失败,余额不足!");
            }
        }
    }
    public static void main(String[] args) {
        AccountRunnableTest3 art3 = new AccountRunnableTest3(1000);

        Thread t1 = new Thread(art3);
        Thread t2 = new Thread(art3);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("账户余额为:"+art3.getBalance());
    }

    class Demo{};
}



