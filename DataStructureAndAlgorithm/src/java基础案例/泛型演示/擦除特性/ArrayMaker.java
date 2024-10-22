package java基础案例.泛型演示.擦除特性;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
当我们创建一个泛型数组时,
* */
public class ArrayMaker<T> {
    private Class<T> kind;

    public ArrayMaker(Class<T> kind){
        this.kind = kind;
    }

    @SuppressWarnings("unchecked")
    T[] create(int size){
        return (T[]) Array.newInstance(kind, size);//newInstance(Class<?> componentType, int length)方法创建一个
                                                    //具有制定组件类型和长度的新数组.
    }

    public static void main(String[] args) {
        ArrayMaker<String> stringMaker = new ArrayMaker<>(String.class);
        String[] stringArray = stringMaker.create(9);
        System.out.println(Arrays.toString(stringArray));
        Array.set(stringArray, 0, "aaa");
        Array.set(stringArray, 1, 1);
        System.out.println(Arrays.toString(stringArray));
    }
}
