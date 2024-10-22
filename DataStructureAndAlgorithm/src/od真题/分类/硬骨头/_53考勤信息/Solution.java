package od真题.分类.硬骨头._53考勤信息;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description
 * 维护一个长度为7的窗口, 并统计缺勤/迟到/早退的次数是否超过3
 * 维护一个变量, 统计其缺勤次数, 并在所有下标>0的位置判断是否有连续的迟到/早退
 * 如果都没有, 则返回true
 * 有任意一条不满足, 则返回false
 * @Author douzhenjun
 * @DATE 2024-03-26
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        while(n-- > 0){
            String[] s = scanner.nextLine().split(" ");
            if(check(s)){
                System.out.println("true");
            }else{
                System.out.println("false");
            }
        }
    }
    
    static boolean check(String[] s){
        int[] cnts = new int[4];//用来记录缺勤/迟到/早退/正常上班的次数
        int m = s.length;
        
        //初始化考勤信息映射
        Map<String, Integer> mp = new HashMap<>();
        mp.put("absent", 0);
        mp.put("late", 1);
        mp.put("leaveearly", 2);
        mp.put("present", 3);

        //缺勤不超过一次
        //没有连续的迟到,早退
        //任意连续七次考勤,缺勤/迟到/早退 不超过三次
        for(int i = 0; i < m; i++){
            cnts[mp.get(s[i])]++;
            //维护一个长度为7的滑动窗口, 如果i == 7(也就是第八天), 消除七天之前的记录
            if(i > 6){
                cnts[mp.get(s[i - 7])]--;
            }
            //出勤次数少于4次, return false
            if(i >= 6 && cnts[3] < 4){
                return false;
            }
            //如果连续两次迟到或者早退,return false
            if(i > 0 && 1 <= mp.get(s[i]) && mp.get(s[i]) <= 2 
                    && 1 <= mp.get(s[i-1]) && mp.get(s[i-1]) <= 2
            ){
                return false;
            }
        }
        //统计缺勤次数, 缺勤次数是全局统计的
        int count = 0;
        for(String x : s){
            if(mp.get(x) == 0){
                count++;
            }
        }
        return count <= 1;
    }
}
