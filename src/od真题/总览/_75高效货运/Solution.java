package od真题.总览._75高效货运;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-03
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int wa = scanner.nextInt();//A的重量
        int wb = scanner.nextInt();//B的重量
        int wt = scanner.nextInt();//额定载重
        int pa = scanner.nextInt();//A的利润
        int pb = scanner.nextInt();//B的利润
        
        int ans = 0;
        
        for(int i = 1;i < wt; i++){
            int a = wa * i;//i个货物所占的容积
            if(a >= wt){
                break;//如果超过货车容积,结束循环
            }
            if((wt - a) % wb == 0){
                int j = (wt - a) / wb;//计算运输B的数量
                ans = Math.max(ans, i * pa + j * pb);
            }
        }
        System.out.println(ans);
    }
}
