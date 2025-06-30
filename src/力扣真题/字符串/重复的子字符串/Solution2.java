package 力扣真题.字符串.重复的子字符串;

/**
 * @Description
 * 如果字符串s由字符串x组成,那么只要判断ss去掉首尾元素之后是否能够包含一个s即可
 * @Author douzhenjun
 * @DATE 2024-01-27
 **/
public class Solution2 {
    public boolean repeatedSubStringPattern(String s){
        String t = s + s;
        return t.substring(1,t.length()-1).contains(s);
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String s1 = "abcabc";
        System.out.println(solution2.repeatedSubStringPattern(s1));
        String s2 = "abcabcd";
        System.out.println(solution2.repeatedSubStringPattern(s2));
    }
}
