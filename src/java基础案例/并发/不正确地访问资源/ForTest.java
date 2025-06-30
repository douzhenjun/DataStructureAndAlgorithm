package java基础案例.并发.不正确地访问资源;

public class ForTest {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        a1.increase();
        System.out.println(a1.getId());
        a2.increase();
        System.out.println(a2.getId());
    }
}

class A{
    private int id = 0;

    public void increase(){
        id++;
    }

    public int getId(){
        return this.id;
    }
}