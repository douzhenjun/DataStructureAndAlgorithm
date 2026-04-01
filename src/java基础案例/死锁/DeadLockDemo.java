package java基础案例.死锁;

public class DeadLockDemo {
    //线程死锁
    public static void main(String[] args) throws InterruptedException {
        Culprit c = new Culprit();
        Police p = new Police();

        //线程1获得c的锁,需要再获得p的锁才能释放
        new Thread(() -> {
            try {
                c.say(p);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        //线程2获得p的锁,需要再获得c的锁才能释放
        new Thread(() -> {
            try {
                p.say(c);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    //罪犯
    static class Culprit {
        public synchronized void say(Police p) throws InterruptedException {
            System.out.println("罪犯:你放了我,我放人质.");
            Thread.sleep(1000);
            p.fun();
        }

        public synchronized void fun() {
            System.out.println("罪犯被放走了,罪犯也放了人质.");
        }
    }


    //警察
    static class Police {
        public synchronized void say(Culprit c) throws InterruptedException {
            System.out.println("警察:你放了人质,我放过你.");
            Thread.sleep(1000);
            c.fun();
        }

        public synchronized void fun() {
            System.out.println("警察救了人质,罪犯跑了.");
        }
    }


}
