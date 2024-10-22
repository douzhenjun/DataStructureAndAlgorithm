package 力扣真题.贪心算法.分发糖果.参考答案;

import java.util.Arrays;

import static 多线程练习.ReentrantLock.ReenterLockDemo.i;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-12
 **/
public class Solution {
    public int candy(int[] ratings){
        int len = ratings.length;
        int[] candyVec = new int[len];
        Arrays.fill(candyVec, 1);
        for(int i = 1; i < len; i++){
            if(ratings[i] > ratings[i-1]){
                candyVec[i] = candyVec[i-1]+1;
            }
        }
        for(int j = len-2; j >= 0; j--){
            if(ratings[j] > ratings[j+1]){
                candyVec[j] = Math.max(candyVec[j], candyVec[j+1]+1);
            }
        }
        int result = 0;
        for(int num : candyVec){
            result += num;
        }
        return result;
    }
}
