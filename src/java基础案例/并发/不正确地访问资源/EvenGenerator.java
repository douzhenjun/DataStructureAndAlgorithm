package java基础案例.并发.不正确地访问资源;

public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;


    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }


    @Override
    public int next() {
        ++currentEvenValue;
        ++currentEvenValue;
        return currentEvenValue;
    }
}
