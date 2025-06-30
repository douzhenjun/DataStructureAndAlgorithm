package 动态规划.动态规划求一个字符串是否是另一个字符串的子串问题;
/*
* 利用Java中的函数indexOf(int ch, int fromIndex)
* 从fromIndex开始寻找字符ch是否包含在字符串中,如果存在返回ch第一次出现的位置.否则返回-1.
* 其实就是双指针法.
* */
public class JudgeIfSubString2 {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for(char c : s.toCharArray()){
            index = t.indexOf(c, index+1);
            if(index == -1){
                return false;
            }
        }
        return true;
    }
}
