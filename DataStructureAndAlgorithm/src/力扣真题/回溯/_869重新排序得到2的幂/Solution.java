package 力扣真题.回溯._869重新排序得到2的幂;

import java.util.Arrays;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-07-13
 **/
public class Solution {
    public boolean reorderedPowerOf2(int n){
        char[] numChar = String.valueOf(n).toCharArray();
        Arrays.sort(numChar);
        return backtrack(numChar, new boolean[numChar.length], 0, 0);
    }
    
    public boolean backtrack(char[] numChar, boolean[] visit, int index, int num){
        if(index == numChar.length){
            return isPowerOfTwo(num);
        }
        for(int i = 0; i < numChar.length; i++){
            //有前导0的跳过
            if(num == 0 && numChar[i] == '0'){
                continue;
            }
            //被访问过的字符直接跳过
            if(visit[i]){
                continue;
            }
            //如果前一个元素被访问过并且这一次要访问的元素和上一个元素相等,那么跳过
            if(i > 0 && numChar[i - 1] == numChar[i] && visit[i - 1]){
                continue;
            }
            //遍历到当前元素,设置被访问标记
            visit[i] = true;
            //递归调用backtrack,如果递归调用的结果为真,返回真
            if(backtrack(numChar, visit, index + 1, num * 10 + numChar[i] - '0')){
                return true;
            }
            //回溯,设置该元素访问状态为false,达到重排列的效果
            visit[i] = false;
        }
        return false;
    }

    private boolean isPowerOfTwo(int num) {
        return (num & (num - 1)) == 0;
    }
}
