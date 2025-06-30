package od真题.总览._11橱窗宝石;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-22
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//宝石数量
        int[] gems = new int[n];
        int i = 0;
        while(i < n){
            gems[i] = sc.nextInt();
            i++;
        }
        int money = sc.nextInt();
        System.out.println(getMaxNumber(gems, money));
    }
    public static int getMaxNumber(int[] gems, int money){
        int sum = 0;
        int maxCount = 0;
        int left = 0;
        int right = 0;
        while(right < gems.length){
            sum += gems[right];
            while(sum > money){
                sum -= gems[left];
                left++;
            }
            maxCount = Math.max(maxCount, right-left+1);
            right++;
        }
        return maxCount;
    }
}
