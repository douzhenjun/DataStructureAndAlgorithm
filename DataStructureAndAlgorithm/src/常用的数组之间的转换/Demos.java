package 常用的数组之间的转换;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-03
 **/
public class Demos {
    //int[]转List<Integer>
    @Test
    public void test01(){
        int[] data = {4, 5, 3, 6, 2, 5, 1};
        List<Integer> dataList = Arrays.stream(data).boxed().collect(Collectors.toList());
        System.out.println(dataList);
        System.out.println(dataList.getClass());
    }

    //int[]转Integer[]
    @Test
    public void test02(){
        int[] data = {4, 5, 3, 6, 2, 5, 1};
        Integer[] integers = Arrays.stream(data).boxed().toArray(Integer[]::new);
        System.out.println(Arrays.toString(integers) + " " + integers.getClass());
    }

    //List<Integer> 转 Integer[]
    @Test
    public void test03(){
        int[] data = {4, 5, 3, 6, 2, 5, 1};
        List<Integer> dataList = Arrays.stream(data).boxed().collect(Collectors.toList());
        
        Integer[] integers = dataList.toArray(new Integer[0]);
        System.out.println(Arrays.toString(integers) +" "+ integers.getClass());
    }
    
    //Integer[]转int[]
    @Test
    public void test04(){
        int[] data = {4, 5, 3, 6, 2, 5, 1};
        List<Integer> dataList = Arrays.stream(data).boxed().collect(Collectors.toList());
        Integer[] integers = dataList.toArray(new Integer[0]);
        
        int[] arr = Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();
        System.out.println(Arrays.toString(arr));
        System.out.println(arr.getClass());
    }

    //Integer[]转成List<Integer>
    @Test
    public void test05(){
        int[] data = {4, 5, 3, 6, 2, 5, 1};
        List<Integer> dataList = Arrays.stream(data).boxed().collect(Collectors.toList());
        Integer[] integers = dataList.toArray(new Integer[0]);

        List<Integer> integerList = Arrays.asList(integers);
        System.out.println(integerList);
        System.out.println(integerList.getClass());
    }
    
    //List<Integer>转换成int[]
    @Test
    public void test06(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(array));
        System.out.println(array.getClass());
    }
}
