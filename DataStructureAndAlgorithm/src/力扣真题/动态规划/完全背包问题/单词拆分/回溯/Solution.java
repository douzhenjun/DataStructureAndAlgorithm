package 力扣真题.动态规划.完全背包问题.单词拆分.回溯;

import java.util.List;

/**
 * @Description
 * 在wordDict中找到单词用来装进背包中,背包中的容量等于s的长度,如果单词恰好能够拼成字符串s,则dp[s.length-1]=true
 * 否则为false.
 * dp[j] = dp[j] || dp[j-worDict[i]]
 * @Author douzhenjun
 * @DATE 2024-03-08
 **/
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict){
        return backTracking(s, wordDict, 0);
    }
    
    public boolean backTracking(String s, List<String> wordDict, int startIndex){
        if(startIndex == s.length()){
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = startIndex; i < s.length(); i++){
            sb.append(s.charAt(i));
            if(wordDict.contains(sb.toString())){
                if(backTracking(s, wordDict, i+1)){
                    return true;
                }
            }
        }
        return false;
    }
}
