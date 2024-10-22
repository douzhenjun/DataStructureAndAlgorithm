package 多线程练习.sychronized_design.accountRunnableTest;

/**
 * 多个线程同时获取cpu资源可能会导致数据不安全
 */
public class AccountRunnableTest implements Runnable {
    int balance;


    public AccountRunnableTest(int balance) {
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
        //1.获得账户的余额
        int temp = this.getBalance();
        //2.判断余额是否大于200,如果是,则执行出钞操作
        if(temp >= 200){
            System.out.println("正在出钞,请稍候...");
            try {
                //3.当前线程睡眠5s
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //4.将余额更新,取款操作完成
            temp -= 200;
            this.setBalance(temp);
            System.out.println("取款成功!剩余金额为"+this.getBalance());
        }else{
            System.out.println("取款失败,余额不足!");
        }
    }

    public static void main(String[] args) {
        AccountRunnableTest art = new AccountRunnableTest(1000);

        Thread t1 = new Thread(art);
        Thread t2 = new Thread(art);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("最终的账户余额为:"+art.getBalance());
    }
}
