package od真题.总览._17API集群负载统计.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-23
 **/
public class Solution {
    public int getKey(String[] strings, String key, int depth) {
        Map<Integer, Map<String, Integer>> mp = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String targetStr = strings[i];
            String str = "";
            int d = 0;//层次
            for (int j = 0; j < targetStr.length(); j++) {
                char ch = targetStr.charAt(j);
                if (ch == '/') {
                    if (!str.isEmpty()) {
                        if (!mp.containsKey(d)) {
                            mp.put(d, new HashMap<>());
                        }
                        mp.get(d).put(str, mp.get(d).getOrDefault(str, 0) + 1);
                        str = "";
                    }
                    d++;
                } else {
                    str += ch;
                }
            }
            //将最后一层的字符串写入到d对应的映射表中
            if(!mp.containsKey(d)){
                mp.put(d, new HashMap<>());
            }
            mp.get(d).put(str, mp.get(d).getOrDefault(str, 0) + 1);
        }
        
        int count = mp.get(depth).getOrDefault(key, 0);
        return count;
    }
}
