package 剑指offer.剑指offer31_栈的压入弹出序列;

import org.junit.Test;

/**
 * @author dou_zhenjun
 * @date 2023/2/28
 */

public class TestDemo {

    @Test
    public void test01(){
        Integer[] arr1 = {1, 2, 3, 4, 5};
        Integer[] arr2 = {3, 4, 2, 1, 5};
        System.out.println(StackTest.isPopQueue(arr1, arr2));
    }

    @Test
    public void test02(){
        Integer[] arr1 = {1, 2, 3, 4, 5};
        Integer[] arr2 = {5, 4, 2, 3, 1};
        System.out.println(StackTest.isPopQueue(arr1, arr2));
    }

    @Test
    public void test03(){
        Integer[] arr1 = {1};
        Integer[] arr2 = {1};
        System.out.println(StackTest.isPopQueue(arr1, arr2));
    }

    @Test
    public void test04(){
        Integer[] arr1 = {1, 2, 3, 4, 5};
        Integer[] arr2 = {6, 4, 3, 2, 1};
        System.out.println(StackTest.isPopQueue(arr1, arr2));
    }
    
}
