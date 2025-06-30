package 力扣真题.回溯.字符串的排列;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-08-21
 **/
public class Solution {
    public String[] permutation(String s){
        Set<String> res = new HashSet<>();
        backtrack(s.toCharArray(), "", new boolean[s.length()], res);
        return res.toArray(new String[res.size()]);
    }
    
    private void backtrack(char[] chars, String temp, boolean[] visited, Set<String> res){
        if(temp.length() == chars.length){
            res.add(temp);
            return;
        }
        for(int i = 0; i < chars.length; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            backtrack(chars, temp + chars[i], visited, res);
            visited[i] = false;
        }
    }
}
