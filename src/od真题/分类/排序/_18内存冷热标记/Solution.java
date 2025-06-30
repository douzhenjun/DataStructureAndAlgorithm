package od真题.分类.排序._18内存冷热标记;

import org.junit.Test;

import java.util.*;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-23
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] w = new int[n];
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            w[i] = x;
        }
        int m = sc.nextInt();
        getResult(w, m);
    }
    
    @Test
    public void test01(){
        int[] w = {1, 2, 1, 2, 1, 2, 1, 2, 1, 2};
        int threshold = 5;
        getResult(w, threshold);
    }

    @Test
    public void test02(){
        int[] w = {1, 2, 3, 4, 5};
        int threshold = 3;
        getResult(w, threshold);
    }
    
    private static void getResult(int[] w, int threshold){
        //使用一个哈希表来保存每个内存页出现的次数
        Map<Integer, Integer> cnts = new HashMap<>();
        for(int i = 0; i < w.length; i++){
            cnts.put(w[i], cnts.getOrDefault(w[i], 0) + 1);
        }
        //使用list集合来保存超过阈值的热内存编号
        List<Integer> lst = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : cnts.entrySet()){
            if(entry.getValue() >= threshold){
                lst.add(entry.getKey());
            }
        }
        //按照热内存使用次数排序,对于热内存使用频率相同的,对热内存按照从小到大的编号排序
        Collections.sort(lst, (a, b) -> {
            if(!cnts.get(a).equals(cnts.get(b))){
                return cnts.get(b) - cnts.get(a);
            }
            return a - b;
        });
        System.out.println(lst.size());
        for(int x : lst){
            System.out.println(x);
        }
    }
}
