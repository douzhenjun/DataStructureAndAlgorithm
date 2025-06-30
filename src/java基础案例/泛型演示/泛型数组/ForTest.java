package java基础案例.泛型演示.泛型数组;

public class ForTest {

    public static void main(String[] args) {
        A a = new A();
//        B b = a.show2();//编译时错误
        B b1 = new B();
        A a1 = b1.create();
    }
}

class A{
    public void show(){
        System.out.println("这是A类");
    }

    public A show2(){
        return this;
    }
}

class B extends A{
    public void show(){
        System.out.println("这是B类");
    }

    public A create(){
        return new A();
    }
}