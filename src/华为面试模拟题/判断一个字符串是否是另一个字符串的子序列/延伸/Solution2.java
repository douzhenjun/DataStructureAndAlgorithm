package 华为面试模拟题.判断一个字符串是否是另一个字符串的子序列.延伸;

import java.util.LinkedList;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-05-03
 **/
public class Solution2 {
    public int getResult(String s, String t) {
        int res = Integer.MAX_VALUE;
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == t.charAt(0)){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int left = queue.poll();
            int right = left + 1;
            int index = 1;
            while(right < s.length()){
                if(s.charAt(right) == t.charAt(index)){
                    index++;
                    if(index == t.length()){
                        res = Math.min(res, right - left + 1 - t.length());
                    }
                }
                right++;
            }
        }
        if(res == Integer.MAX_VALUE){
            
        }
        return res;
    }
}
