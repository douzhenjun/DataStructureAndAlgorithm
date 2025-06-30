package FindLongestString;

import java.util.HashMap;
import java.util.HashSet;
//我一开始的想法
public class FindLongestString_3 {

    public static void main(String[] args) {
        String strs = "abdcedbaadce";
        strs = "aaa";
        strs = "";
        strs = null;
        strs = "abcde5678";
        strs = "aaaaaaaab";
        int len = getMaxLength(strs);
        System.out.println("字符串"+strs+"中最长的无重复元素子串的长度为:"+len);
    }

    public static int getMaxLength(String str){
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        if(str == null){
            return -1;
        }
        for(int i = 0, j = 0; j < str.length(); j++){
            //如果hash表中包含strs[j]这个字符,说明开始出现重复字符
            if(set.contains(str.charAt(j))){
                //这个时候先判断这个时候的长度是否大于max,将新的最大值赋值给max
                max = Math.max(max, j-i);
                //因为出现了重复元素,开始移动指针i似的i,j之间的元素没有重复的,
                //换句话说,也就是让j移动到第一次出现重复元素的下标后面去
                while(str.charAt(i) != str.charAt(j)){
                    i += 1;
                }
                i += 1;
            }else{
                if(j == str.length()-1){
                    max = Math.max(max, j-i+1);
                }
                set.add(str.charAt(j));
            }
        }
        return max;
    }


}
