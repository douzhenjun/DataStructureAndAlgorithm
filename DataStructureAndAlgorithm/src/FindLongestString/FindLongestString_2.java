package FindLongestString;

import java.util.LinkedList;
import java.util.Queue;

public class FindLongestString_2 {

    public int lengthOfLongestSubstring(String s){
        Queue<Character> queue = new LinkedList<>();
        int max = 0;
        for(char c : s.toCharArray()){
            while(queue.contains(c)){
                queue.poll();
            }
            //添加到队尾
            queue.add(c);
            //记录下最大长度
            max = Math.max(max, queue.size());
        }
        return max;
    }

}
