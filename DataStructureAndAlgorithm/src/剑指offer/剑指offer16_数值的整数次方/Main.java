package 剑指offer.剑指offer16_数值的整数次方;

public class Main {
    public static void main(String[] args) {
        Method01 m1 = new Method01();
        double result = m1.Power(5, -1);
        double result1 = m1.Power(5, 0);
        double result2 = m1.Power(5, 2);
        double result3 = m1.Power(0, 0);
        double result4 = m1.Power(0, -4);

        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);

    }
}
