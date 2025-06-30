package java基础案例.并发.原子类;

public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;//属于静态变量
    public static int nextSerialNumber(){
        return serialNumber++;
    }
}
