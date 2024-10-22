package FindLongestString;

import java.util.HashMap;

/**
 *问题描述:
 * 给定一个字符串,请你找出其中不含有重复字符的最长子串的长度.
 */


public class FindLongestString {

    public static void main(String[] args) {
        String str = "abccba";
        str = "aaaa";
        str = "abcde";
        str = "aaaabcdee";
        str = "abc34343223212323";
        int num = lengthOfLongestSubstring(str);
        System.out.println(num);
    }

    /*
    采用双指针方法求解
    * */
    public static int lengthOfLongestSubstring(String s){
        if(s.length() == 0){
            return 0;
        }
        //键是字符串的每个不重复字符,值是这个字符所对应的字符串中的索引
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0, j = 0; i < s.length(); i++){
            //如果发现str[i]在map集合中出现过,说明第一次出现了重复的元素,这个时候J向右移动
            //j指向之前str[i]对应的索引+1.
            if(map.containsKey(s.charAt(i))){
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            //将i的大小作为键str[i]的值对应
            map.put(s.charAt(i),i);
            //i每增加一次,就将i-j+1与max比较一次并将较大的那个赋值给新的max,最稳妥
            max = Math.max(max, i-j+1);
        }
        return max;
    }
}

