package 多线程练习.callable.demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MyCallable implements Callable<String> {
    //1.通过实现Callable接口创建MyCallable线程
    private String name;
    public MyCallable(String name){
        this.name = name;
    }
    @Override
    public String call() throws Exception{
        return name;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //2.创建一个固定大小为5的线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);
        //3.创建有多个返回值的任务列表list
        List<Future> list = new ArrayList<Future>();
        for(int i = 0; i < 5; i++){
            //4.创建一个有返回值的实例
            Callable c = new MyCallable(i+"");
            //5.提交线程,获取Future对象并将其保存到Future List中
            Future future = pool.submit(c);
            System.out.println("submit a callable thread:"+i);
            list.add(future);
        }
        //6.关闭线程池,等待线程执行结束
        pool.shutdown();
        //7.遍历所有线程的运行结果
        for(Future future:list){
            System.out.println("get the result from callable thread:"+
                    future.get().toString());
        }
    }
}
