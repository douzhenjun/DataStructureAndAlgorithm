package od真题.分类.排序._63最大N个数和最小N个数的和;

import java.util.*;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-27
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();//数组的大小
        List<Integer> w = new ArrayList<>();
        for(int i = 0; i < m; i++){
            w.add(scanner.nextInt());
        }
        int n = scanner.nextInt();//2 * n <= m则输入合法,否则输入非法
        
        Set<Integer> set = new HashSet<>(w);
        w.clear();
        w.addAll(set);//对数组进行去重
        Collections.sort(w);
        m = w.size();//去重后的数组的长度
        if(m < 2 * n || w.get(0) < 0 || w.get(m-1) > 1000){
            System.out.println(-1);
        }else{
            int result = w.subList(0, n).stream().mapToInt(Integer::intValue).sum()
                    + w.subList(m-n, m).stream().mapToInt(Integer::intValue).sum();
            System.out.println(result);
        }
    }
}
