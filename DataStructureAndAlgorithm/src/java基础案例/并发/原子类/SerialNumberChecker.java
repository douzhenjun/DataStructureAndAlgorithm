package java基础案例.并发.原子类;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//选择一个不会耗尽内存的集合(循环集合),防止消耗大量内存,假设你在生产序列数时,产生数值
//覆盖冲突的可能性极小.
class CircularSet{
    private int[] array;
    private int len;
    private int index = 0;

    public CircularSet(int size){
        array = new int[size];
        len = size;
        for(int i = 0; i < size; i++){
            array[i] = -1;
        }
    }

    public synchronized void add(int i){
        array[index] = i;
        index = ++index % len;
    }

    public synchronized boolean contains(int val){
        for(int i = 0; i < len; i++){
            if(array[i] == val){
                return true;
            }
        }
        return false;
    }
}

//检查序列数,设置10个线程,分别执行生成序列数的方法
public class SerialNumberChecker {
    private static final int SIZE = 10;
    private static CircularSet serials = new CircularSet(1000);
    private static ExecutorService exec = Executors.newCachedThreadPool();

    //确保每个线程生成的序列数是唯一的,若不唯一,则该线程退出
    static class SerialChecker implements Runnable{

        @Override
        public void run() {
            while(true){
                int serial = SerialNumberGenerator.nextSerialNumber();//serialNumber++
                if (serials.contains(serial)) {
                    System.out.println("Duplicate: " + serial);//若集合中有这个数字,那么输出它,并令线程退出
                    System.exit(0);
                }
                serials.add(serial);//如果集合中没有这个数字,那么添加到serial中
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < SIZE; i++){
            exec.execute(new SerialChecker());
        }
        if(args.length > 0){
            TimeUnit.SECONDS.sleep(Integer.valueOf(args[0]));
            System.out.println("No duplicates detected");
            System.exit(0);
        }
    }
}
