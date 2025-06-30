package 力扣真题.字符串.反转字符串中的单词;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2023-10-30
 **/
public class TestDemos {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "abc 123 34  123   ";//abc 123 34 123
        solution.reverseWords(s);
        
        String s2 = "the sky is blue";
        solution.reverseWords(s2);
    }
}
