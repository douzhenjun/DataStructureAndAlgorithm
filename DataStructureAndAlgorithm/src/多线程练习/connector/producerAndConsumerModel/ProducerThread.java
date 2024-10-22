package 多线程练习.connector.producerAndConsumerModel;

import static java.lang.Thread.sleep;

public class ProducerThread implements Runnable {
    private StoreHouse sh;

    public ProducerThread(StoreHouse sh){
        this.sh = sh;
    }
    @Override
    public void run() {
        while(true){
            sh.produce();
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }

}
