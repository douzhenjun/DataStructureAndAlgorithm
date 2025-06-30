package 华为面试模拟题.判断一个字符串是否是另一个字符串的子序列;

import java.util.HashSet;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-05-03
 **/
class Solution {
    public boolean isSubsequence(String s, String t) {
        //双指针
        int index = 0;
        int slen = s.length();
        int tlen = t.length();
        if (slen == 0){
            return true;
        }
        for (int i = 0; i < tlen; i++){
            if ((index < slen ) && (t.charAt(i) != s.charAt(index)) && (t.charAt(i) == s.charAt(0))){
                index = 1;
            }
            else if ((index < slen ) && (t.charAt(i) == s.charAt(index))){
                index += 1;
            }
        }
        System.out.println(index);
        return index == slen ;
    }
}
