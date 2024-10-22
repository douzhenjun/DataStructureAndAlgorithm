package 多线程练习.connector.producerAndConsumerModel;

/**
 * 仓库类
 */
public class StoreHouse {
    private /*static*/ int quantity;//定义一个静态的成员变量,表示商品的数量

    //生产方法
    public synchronized void produce() {
            notify();
            if (quantity < 10) {
                System.out.println("线程" + Thread.currentThread().getName() + "开始生产第" + (quantity + 1) + "个商品");
                quantity++;
            }else{
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    //消费方法
    public synchronized void consume(){
            notify();
            if(quantity > 0){
                System.out.println("线程" + Thread.currentThread().getName() + "开始消费第" + quantity +"个商品.");
                quantity--;
            }else{
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    public static void main(String[] args) {
        StoreHouse sh = new StoreHouse();
        ProducerThread pt = new ProducerThread(sh);
        ConsumerThread ct = new ConsumerThread(sh);

        Thread t1 = new Thread(pt);
        Thread t2 = new Thread(ct);

        t1.start();
        t2.start();
    }

}
