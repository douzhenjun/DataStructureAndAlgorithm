package od真题.分类.模拟._02绘图机器计算面积;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-22
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//指令的数量
        int e = sc.nextInt();//绘图的终点横坐标
        long lastX = 0;//记录上一个位置的横坐标
        long y = 0;//记录起始点的纵坐标
        long area = 0;//记录面积
        for(int i = 0; i < n ; i++){
            long x = sc.nextLong();
            long d = sc.nextLong();
            area += (x - lastX) * Math.abs(y);
            y += d;     //更新纵坐标
            lastX = x;  //更新上一个位置的横坐标
        }
        area += (e - lastX) * Math.abs(y);
        System.out.println(area);
        sc.close();
    }
}
