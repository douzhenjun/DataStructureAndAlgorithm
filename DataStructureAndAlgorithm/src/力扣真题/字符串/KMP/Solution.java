package 力扣真题.字符串.KMP;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-01-11
 **/
public class Solution {
    //获得一个字符串的前缀表方法
    public void getNext(int[] next, String s) {
        //初始化next[0]=0
        int j = 0;
        next[0] = j;
        //定义i指向后缀的末尾,j指向前缀的末尾
        for (int i = 1; i < s.length(); i++) {
            //如果出现不匹配的情况,定义一个循环令j指向next[j-1],或者0
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            //如果s[i]=s[j],那么j++,i++
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            //给next[i]赋值
            next[i] = j;
        }
    }

    //解决方法
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        //初始化next数组,也就是前缀表
        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = 0;
        //i用来遍历文本串haystack,j用来指向当haystack[i]匹配needle[j]失败时下一个匹配的模式串的位置
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            //如果haystack[i]=needle[j],那么i,j自增,匹配下一个位置
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            //如果j指向了模式串末尾的下一个元素,这说明存在needle串是haystack的子串,
            // 返回needle串第一个元素在haystack出现的位置,当于indexOf
            if (j == needle.length()) {
                return (i - needle.length() + 1);
            }
        }
        //否则needle并不是haystack的子串,返回-1.
        return -1;
    }
}
