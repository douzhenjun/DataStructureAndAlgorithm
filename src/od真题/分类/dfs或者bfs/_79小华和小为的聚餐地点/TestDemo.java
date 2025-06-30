package od真题.分类.dfs或者bfs._79小华和小为的聚餐地点;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-13
 **/
public class TestDemo {
    public static void main(String[] args) {
        int[] array = new int[2];
        System.out.println(Arrays.stream(array).boxed().collect(Collectors.toList()));
        t1(array);
        System.out.println(Arrays.stream(array).boxed().collect(Collectors.toList()));
    }
    
    private static void t1(int[] array){
        array[0] = 1;
    }
}
