package 力扣真题.字符串.反转字符串;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-01-11
 **/
public class Solution2 {
    // 第二种方法用temp来交换数值更多人容易理解些
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
