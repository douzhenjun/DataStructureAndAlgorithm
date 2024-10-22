package java基础案例.泛型演示.擦除特性;

public class ForTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Integer i = new Integer(0);
        A a = new A(i);
        System.out.println(a);
    }
}

class A<T>{
    private T t;

//    public A(Integer i) {
//    }

//    public A(T t){
//        this.t = t;
//    }

    public <T> A(T t){
        
    }
}