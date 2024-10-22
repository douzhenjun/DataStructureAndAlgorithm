package java基础案例.泛型演示.泛型数组;

public class GenericArray<T> {
    private T[] array;
    @SuppressWarnings("unchecked")
    public GenericArray(int sz){
        array = (T[])new Object[sz];
    }
    public void put(int index, T item){
        array[index] = item;
    }
    public T get(int index){
        return array[index];
    }

    public T[] rep(){
        return array;
    }

    public static void main(String[] args){
        /*编译时一定能通过,运行时,类型擦除,相当于GenericArray gai = new GenericArray(10);
        * 此时构造器内部的array = new Object[sz],当gai调用rep()方法时,从编译期看,是没有问题的.
        * 但一旦运行,将返回一个Object[]类型的数组,用Integer[]类型的引用指向它显然会引发异常.*/
        GenericArray<Integer> gai = new GenericArray<Integer>(10);
        Integer[] ia = gai.rep();
//        Object[] oa = gai.rep();
    }
}
