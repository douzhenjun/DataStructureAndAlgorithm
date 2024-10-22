package 力扣真题.回溯.分割回文串;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-08-21
 **/
public class Solution2 {
    public List<List<String>> partition(String s){
        List<List<String>> res = new ArrayList<>();
        backTrack(s, 0, res, new ArrayList<>());
        return res;
    }
    
    public void backTrack(String s, int index, List<List<String>> res, List<String> cur){
        if(index >= s.length()){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = index; i < s.length(); i++){
            if(!isParlidrome(s, index, i)){
                continue;
            }
            cur.add(s.substring(index, i + 1));
            backTrack(s, i + 1, res, cur);
            cur.remove(cur.size() - 1);
        }
    }
    
    public boolean isParlidrome(String str, int left, int right){
        while(left < right){
            if(str.charAt(left++) != str.charAt(right--)){
                return false;
            }
        }
        return true;
    }
}
