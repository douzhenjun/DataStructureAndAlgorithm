package 多线程练习.connector.producerAndConsumerModel;

import static java.lang.Thread.sleep;

public class ConsumerThread implements Runnable{
    private StoreHouse sh;

    public ConsumerThread(StoreHouse sh){
        this.sh = sh;
    }
    @Override
    public void run() {
        while(true){
            sh.consume();
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
