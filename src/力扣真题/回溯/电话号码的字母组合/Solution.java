package 力扣真题.回溯.电话号码的字母组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-02-29
 **/
public class Solution {
    Map<Character, String> digitMap = new HashMap<>();
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return result;
        }
        digitMap.put('2', "abc");
        digitMap.put('3', "def");
        digitMap.put('4', "ghi");
        digitMap.put('5', "jkl");
        digitMap.put('6', "mno");
        digitMap.put('7', "pqrs");
        digitMap.put('8', "tuv");
        digitMap.put('9', "wxyz");
        StringBuilder sb = new StringBuilder();
        backtracking(digits, 0, sb);
        return result;
    }

    public void backtracking(String digits, int index, StringBuilder sb){
        if(index == digits.length()){
            result.add(sb.toString());
            return;
        }
        String zimu = digitMap.get(digits.charAt(index));
        for(int j = 0; j < zimu.length(); j++){
            sb.append(zimu.charAt(j));
            backtracking(digits, index+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
