package od真题.总览._112运输时间;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-11
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //读取m和n
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        //初始化最大花费时间
        double ans = 0;
        //创建数组w用来存储每个人的速度
        int[] w = new int[m];
        //读取数组w的值,即每个人的速度
        for(int i = 0; i < m; i++){
            w[i] = scanner.nextInt();
        }
        //遍历数组计算最大花费时间ans
        for(int i = 0; i < m; i++){
            double t = (double) n / w[i];
            //如果是第一辆车, 或者追不上提前一小时出发的车
            if(i == 0 || t >= ans - 1){
                ans = t;
            }else{
                ans = ans - 1;
            }
        }
        System.out.println(ans);
    }
}
