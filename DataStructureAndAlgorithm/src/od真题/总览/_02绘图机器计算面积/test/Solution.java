package od真题.总览._02绘图机器计算面积.test;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-22
 **/
public class Solution {
    /*
      input:  
      4 10
      1 1
      2 1
      3 1
      4 -2
      output:
       12
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        
        int area = 0;//输出的面积
        int lastY = 0;//记录上一次的纵坐标
        int lastX = 0;//记录上一次的横坐标
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            area += (x-lastX) * Math.abs(lastY);
            lastX = x;
            lastY += y;
        }
        area += (e-lastX) * Math.abs(lastY);
        System.out.println(area);
    }
}
