package java基础案例.并发.不正确地访问资源;

public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();

    public void cancel(){
        canceled = true;
    }

    public boolean isCanceled(){
        return canceled;
    }
}
