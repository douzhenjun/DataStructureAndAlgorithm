package 力扣真题.数组.最小子串问题;

import java.util.*;

/**
 * @Description
 * 获得s中覆盖t的最小子串
 * 这个最小子串要满足:1.最小子串中元素覆盖t中的元素,且元素出现的次数>=t中元素出现的次数
 * 2.最小子串中元素只要在t中也出现即可,对顺序没有要求
 * 3.允许出现重复的元素,只要保证重复出现的次数
 * 定义两个哈希表, 一个是用来存放t中字符出现的次数的, 另一个用于存放s的某个子串中字符出现的次数的
 * 滑动窗口法,左指针固定,右指针遍历,当且仅当计算哈希表的元素个数>=目标哈希表的元素个数时
 * 我们还需要判断此时是否计算哈希表的每个元素出现次数不少于对应的目标哈希表
 * 只有这两个条件都为真,则我们找到了这样一个子串,去根据子串是否更小去更新result
 * 同时更新左指针和计算哈希表中的元素
 * @Author douzhenjun
 * @DATE 2023-10-03
 **/
public class Solution {

    public String minWindow(String s, String t) {
        Map<Character, Integer> calMap = new HashMap<>();//定义从s中比较,获得t中字符的哈希表
        Map<Character, Integer> targetMap = new HashMap<>();//定义保存t中字符的哈希表
        //初始化targetMap
        for (int i = 0; i < t.length(); i++) {
            targetMap.put(t.charAt(i), targetMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;//定义左指针
        String result = "";//定义返回的字符串

        //遍历右指针
        for (int right = 0; right < s.length(); right++) {
            //如果右指针所指元素在t中存在,那么新增这个元素或者将这个元素的出现次数+1
            if (targetMap.containsKey(s.charAt(right))) {
                calMap.put(s.charAt(right), calMap.getOrDefault(s.charAt(right), 0) + 1);
            }
            /*
              当哈希表中元素包含t中元素的时候,更新result字符串,同时滑动左指针,去寻找其他的满足要求的窗口
              这个条件要注意,因为要考虑到t中有重复元素的情况,首先需要满足t中所有非重复的元素都在
              calMap中出现过,其次还要保证t中重复的元素的个数要不多于calMap中对应的重复元素的个数
             */
            if (calMap.size() >= targetMap.size()) {
                /*
                  这个只有当
                   1.计算哈希表大小不小于目标哈希表大小
                   2.计算哈希表比目标哈希表中每个元素的出现次数都至少不少
                  的情况下,才生效
                */
                boolean flag = true;
                for (Map.Entry<Character, Integer> entry : calMap.entrySet()) {
                    if (entry.getValue() < targetMap.get(entry.getKey())) {
                        flag = false;
                    }
                }
                while (flag) {
                    String subString = s.substring(left, right + 1);
                    if (result.length() == 0) {
                        result = subString;
                    } else {
                        result = subString.length() < result.length() ? subString : result;
                    }
                    //left++
                    if (calMap.containsKey(s.charAt(left))) {
                        calMap.put(s.charAt(left), calMap.get(s.charAt(left)) - 1);
                        if (calMap.get(s.charAt(left)) == 0) {
                            calMap.remove(s.charAt(left));
                        }
                    }
                    left++;

                    //更新flag
                    if (calMap.size() < targetMap.size()) {
                        flag = false;
                    } else {
                        for (Map.Entry<Character, Integer> entry : calMap.entrySet()) {
                            if (entry.getValue() < targetMap.get(entry.getKey())) {
                                flag = false;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
