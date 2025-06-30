package 力扣真题.字符串.重复的子字符串;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-01-11
 **/
class Solution {

    //获得字符串s的next数组,其中next[s.length-1]就是最长相等前后缀的长度
    private int[] getNext(String s) {
        int[] next = new int[s.length()];
        int i = 0;
        next[0] = i;
        for (int j = 1; j < s.length(); j++) {
            //如果出现匹配失败的情况,把遍历s的前缀的指针i向前移动到next[j-1]的位置
            while (i > 0 && s.charAt(j) != s.charAt(i)) {
                i = next[i - 1];
            }
            //如果匹配成功,那么i++,继续遍历下一个前缀和后缀的相关元素
            if (s.charAt(j) == s.charAt(i)) {
                i++;
            }
            next[j] = i;
        }
        return next;
    }

    //设len = s.length, 那么如果一个字符串满足len%(len-next[len-1])==0,则表示
    //s由不包含于最长相等前后缀的子串重复组成.
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int[] next = getNext(s);
        if (next[len - 1] > 0 && len % (len - next[len - 1]) == 0) {
            return true;
        }
        return false;
    }
}
