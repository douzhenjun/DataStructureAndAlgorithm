package od真题.总览._44田地最小覆盖;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-25
 **/
public class Solution {
    
    //坐标对象
    static class Pair<F, S>{
        private final F first;
        private final S second;
        
        public Pair(F first, S second){
            this.first = first;
            this.second = second;
        }
        
        public F getFirst(){
            return first;
        }
        
        public S getSecond(){
            return second;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Map<Integer, Vector<Pair<Integer, Integer>>> mp = new HashMap<>();

        // 读取矩阵数据并记录非零元素的位置
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int a = scanner.nextInt();
                if (a != 0) {
                    if (!mp.containsKey(a)) {
                        mp.put(a, new Vector<>());
                    }
                    mp.get(a).add(new Pair<>(i, j));
                }
            }
        }
        
        int ans = 0;
        //遍历记录的非零元素及其位置,计算包含该元素的矩阵的最大面积
        for(Map.Entry<Integer, Vector<Pair<Integer, Integer>>> entry : mp.entrySet()){
            int u = entry.getKey();
            Vector<Pair<Integer, Integer>> v = entry.getValue();
            int minrow = Integer.MAX_VALUE;
            int maxrow = 0;
            int mincol = Integer.MAX_VALUE;
            int maxcol = 0;

            //计算当前非零元素所在矩形的行列范围
            for(Pair<Integer, Integer> t : v){
                minrow = Math.min(minrow, t.getFirst());
                maxrow = Math.max(maxrow, t.getFirst());
                mincol = Math.min(mincol, t.getSecond());
                maxcol = Math.max(maxcol, t.getSecond());
            }
            
            //计算当前矩形的面积,并更新最大面积
            ans = Math.max(ans, (maxrow - minrow + 1) * (maxcol - mincol + 1));
        }
        System.out.println(ans);
    }
}
