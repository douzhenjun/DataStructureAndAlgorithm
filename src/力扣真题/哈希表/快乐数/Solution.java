package 力扣真题.哈希表.快乐数;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-27
 **/
public class Solution {
    public boolean isHappy(int n){
        if(n == 0){
            return false;
        }
        if(n == 1){
            return true;
        }
        int sum = 0;
        List<Integer> array = new ArrayList<>();
        int num = n;//初始化num=n,用于循环中的计算
        while(sum != 1){
            sum = 0;
            int res = 0;//余数
            while(num > 0){
                res = num % 10;
                sum += res * res;
                num = num / 10;
            }
            if(!array.contains(sum)){
                array.add(sum);
            }else{
                return false;
            }
            num = sum;
        }
        return true;
    }
}
