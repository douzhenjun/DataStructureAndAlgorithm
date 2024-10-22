package java基础案例.死锁;

public class DeadLockDemo {
    //线程死锁
    public static void main(String[] args) {
        Culprit c = new Culprit();
        Police p = new Police();
        new MyThread(c, p).start();
        c.say(p);
    }

    static class MyThread extends Thread{
        private Culprit c;
        private Police p;

        public MyThread(Culprit c,  Police p){
            this.c = c;
            this.p = p;
        }

        public void run(){
            p.say(c);
        }
    }


    //罪犯
    static class Culprit{
        public synchronized void say(Police p){
            System.out.println("罪犯:你放了我,我放人质.");
            p.fun();
        }

        public synchronized void fun(){
            System.out.println("罪犯被放走了,罪犯也放了人质.");
        }
    }


    //警察
    static class Police{
        public synchronized void say(Culprit c){
            System.out.println("警察:你放了人质,我放过你.");
            c.fun();
        }

        public synchronized void fun(){
            System.out.println("警察救了人质,罪犯跑了.");
        }
    }


}
