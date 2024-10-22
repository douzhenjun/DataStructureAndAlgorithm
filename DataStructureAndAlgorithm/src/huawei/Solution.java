package huawei;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-05-22
 **/
public class Solution {
    public int func(String s){
        int ans1 = 0;
        int left = 0;
        boolean flag1 = false;
        while(left < s.length()){
            if(s.charAt(left) == '1'){
                flag1 = true;
            }else if(s.charAt(left) == '0' && flag1){
                ans1++;
            }
            left++;
        }
        boolean flag2 = false;
        int ans2 = 0;
        int right = s.length() - 1;
        while(right >= 0){
            if(s.charAt(right) == '0'){
                flag2 = true;
            }else if(s.charAt(right) == '1' && flag2){
                ans2++;
            }
            right--;
        }
        return Math.min(ans1, ans2);
    }
}
