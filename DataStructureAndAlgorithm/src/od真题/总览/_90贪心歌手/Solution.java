package od真题.总览._90贪心歌手;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-04
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//期限天数
        int n = sc.nextInt();//经过的城市数量
        
        List<Integer> a = new ArrayList<>();
        for(int i = 0; i < n + 1; i++){
            a.add(sc.nextInt());//输入每个站点的开销
            t -= a.get(i);//减去路上的开销
        }
        
        List<Integer> val = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            int m = sc.nextInt();
            int d = sc.nextInt();
            for(int j = 1; j <= t; j++){
                if(m <= 0){
                    break;
                }
                val.add(m);//生成站点的价值序列
                m -= d;//每天的价格递减
            }
        }
        Collections.sort(val, Collections.reverseOrder());
        int ans = 0;
        for(int i = 0; i < t; i++){
            ans += val.get(i);
        }
        System.out.println(ans);
    }
}
