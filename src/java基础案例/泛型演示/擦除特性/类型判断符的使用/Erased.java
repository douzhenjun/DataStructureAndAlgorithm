//package thinkinginjava.泛型演示.擦除特性;
//
//public class Erased<T> {
//    private final int SIZE = 100;
//    public Class<T> kind;
//
//    public Erased(Class<T> kind){
//        this.kind = kind;
//    }
//    public void f(Object arg){
//        if(arg instanceof T){
//            System.out.println("good");
//        }
//        T var = new T();
//        T[] array = new T[SIZE];
//        T[] array2 = (T)new Object[SIZE];
//    }
//
//    public static void main(String[] args) {
//        Erased erased = new Erased(String.class);
//        Object obj = new Object();
//        erased.f(obj);
//    }
//}
//
