package java基础案例.并发.原子类;

public class ForTest {
    public static void main(String[] args) {
        String one = "Hello";
        String two = "Hello";
        String three = two.substring(0,5);
        System.out.println(one.equals(three));
        System.out.println(one == three);
    }
}
