package 力扣真题.数组.最小子串问题.test;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        String result = "";
        Map<Character, Integer> targetMap = new HashMap<>();//目标哈希表
        Map<Character, Integer> tmpMap = new HashMap<>();//滑动窗口

        //初始化目标表,将t中的字符及其出场次数统计出来
        for (Character ch : t.toCharArray()) {
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            Character ch2 = s.charAt(right);
            tmpMap.put(ch2, tmpMap.getOrDefault(ch2, 0) + 1);

            boolean isFind = true;//找到这样的子串
            if (tmpMap.size() >= targetMap.size()) {
                //去tmpMap中判断是否覆盖targetMap中的元素
                for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
                    if (tmpMap.containsKey(entry.getKey())) {
                        if (tmpMap.get(entry.getKey()) < entry.getValue()) {
                            isFind = false;
                            break;
                        }
                    }
                }
                //如果找到了这样的子串,去更新结果,看是不是最小的
                while (isFind && tmpMap.size() >= targetMap.size()) {
                    String subString = s.substring(left, right + 1);
                    if (result.length() == 0 || subString.length() < result.length()) {
                        result = subString;
                    }
                    if(right - left + 1 == t.length()){
                        return result;
                    }
                    //如果找到了这样的子串,移动左指针,更新tmpMap的结果
                    left++;
                    if(left > right){
                        return result;
                    }
                    tmpMap.put(s.charAt(left), tmpMap.get(s.charAt(left)) - 1);
                    if (tmpMap.get(s.charAt(left)) == 0) {
                        tmpMap.remove(s.charAt(left));
                    }

                    for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
                        if (!tmpMap.containsKey(entry.getKey())) {
                            isFind = false;
                            break;
                        } else {
                            if (tmpMap.get(entry.getKey()) < targetMap.get(entry.getKey())) {
                                isFind = false;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}