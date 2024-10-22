package 力扣真题.动态规划.解码方法;

/**
 * @Description
 * 使用动态规划方法求解此题,考虑dp[i]表示s的前i个字符的有效解码个数
 * 当且仅当s[i]有效时(s[i] != '0')它满足dp[i] = dp[i-1]成立
 * 如果当前字符s[i]和它的前一个字符s[i-1]构成的数字有效即s[i-1..i].parseInt > 0 && s[i-1..i].parseInt < 27
 * 那么dp[i] = dp[i-1] + dp[i-2]成立.
 * @Author douzhenjun
 * @DATE 2024-07-04
 **/
public class Solution4 {
    public int numDecodings(String s){
        int length = s.length();
        int lastLast = 0;//f(0)
        int last = 1;//f(1)
        for(int i = 0; i < length; i++){
            int cur = 0;//f(i) = f(i-2) + f(i-1)
            //判断截取一个是否符合
            if(s.charAt(i) != '0'){
                cur = last;
            }
            //判断截取两个是否符合
            if(i >= 1 && (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) <= '6')){
                cur += lastLast;
            }
            lastLast = last;//f(i-2) = f(i-1)
            last = cur;//f(i-1) = f(i)
        }
        return last;
    }
}
