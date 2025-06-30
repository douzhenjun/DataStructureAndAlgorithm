package java基础案例.泛型演示.泛型数组;

import java.util.Arrays;

public class GenericArray2<T> {
    private Object[] array;
    public GenericArray2(int sz){
        array = new Object[sz];
    }

    public void put(int index, T item){
        array[index] = item;
    }

    @SuppressWarnings("unchecked")
    public T get(int index){return (T)array[index];}

    @SuppressWarnings("unchecked")
    public T[] rep(){
        return (T[])array;
    }

    public static void main(String[] args) {
        GenericArray2<Integer> gai = new GenericArray2<>(10);
        System.out.println(Arrays.toString(gai.getClass().getTypeParameters()));

        for(int i = 0; i < 10; i++){
            gai.put(i, i);
        }
        for(int i = 0; i < 10; i++){
            System.out.print(gai.get(i)+" ");//为什么这里运行正常?
//            System.out.println(gai.get(i).getClass());
        }
        System.out.println();
        System.out.println(gai.get(0).getClass());
//        Integer[] ia = gai.rep();//为什么这里运行异常?
    }
}
