package 力扣真题.回溯._869重新排序得到2的幂;

import java.util.Arrays;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-07-25
 **/
public class Solution2 {
    public boolean reorderPower2(int n){
        char[] numChar = String.valueOf(n).toCharArray();
        Arrays.sort(numChar);
        for(int i = 0; i < 31; i++){
            char[] bitChar = String.valueOf(1 << i).toCharArray();
            Arrays.sort(bitChar);
            if(Arrays.equals(numChar, bitChar)){
                return true;
            }
        }
        return false;
    }
}
