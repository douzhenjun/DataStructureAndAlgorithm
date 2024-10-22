package 力扣真题.二叉树.判断路径之和是否等于指定值.返回所有路径;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-02-26
 **/
public class Test {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        result.add(list1);
        System.out.println(result);
        list1.remove(list1.size()-1);
        System.out.println(result);
        list1.remove(list1.size()-1);
        System.out.println(result);
    }
}
