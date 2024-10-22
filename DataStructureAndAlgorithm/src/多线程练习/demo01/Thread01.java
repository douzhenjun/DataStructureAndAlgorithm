package 多线程练习.demo01;

public class Thread01 extends Thread {
    @Override
    public void run() {
        for(int i = 1; i < 101; i++){
            if(i % 2 == 1){
                System.out.println("线程"+currentThread().getName()+"输出:"+i);
            }
        }
    }
}
