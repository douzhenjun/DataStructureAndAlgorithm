package 力扣真题.哈希表.有效的字母异位词;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2023-10-13
 **/
public class Solution {
    public boolean isAnagram(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        if(lenT > lenS || lenT < lenS){
            return false;
        }
        Map<Character, Integer> record = new HashMap<>(26);
        //初始化哈希表,把s中的元素和出现次数记录在records中
        for(int i = 0; i < lenS; i++){
            record.put(s.charAt(i), record.getOrDefault(s.charAt(i), 0)+1);
        }
        //遍历目标字符串,每次遍历到的元素到record中查找是否存在,并在查找后对该元素的出现次数-1
        for(int j = 0; j < lenT; j++){
            if(record.containsKey(t.charAt(j))){
                if(record.get(t.charAt(j)) == null){
                    return false;
                }
                record.put(t.charAt(j), record.get(t.charAt(j))-1);
                if(record.get(t.charAt(j)) == 0){
                    record.remove(t.charAt(j));
                }
            }
        }
        if(record.size() > 0){
            return false;
        }
        //当遍历完字符串以后只有当哈希表为空说明是,否则不是
        return true;
    }
}
