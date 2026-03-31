package java基础案例.dfa_确定有穷自动机;

import java.util.*;

public class SensitiveWordDFA {

    private static Map<Integer, Map<Character, Integer>> transitionMap = new HashMap<>();
    private static Set<Integer> finalStateSet = new HashSet<>();
    private static int stateCounter = 0;

    // 构建DFA
    public static void build(List<String> words) {
        transitionMap.clear();
        finalStateSet.clear();
        stateCounter = 0;
        transitionMap.put(0, new HashMap<>());

        for (String word : words) {
            int currentState = 0;
            for (char ch : word.toCharArray()) {
                Map<Character, Integer> edges = transitionMap.get(currentState);
                if (edges.containsKey(ch)) {
                    currentState = edges.get(ch);
                } else {
                    stateCounter++;
                    edges.put(ch, stateCounter);
                    transitionMap.put(stateCounter, new HashMap<>());
                    currentState = stateCounter;
                }
            }
            finalStateSet.add(currentState);
        }
    }

    // 匹配敏感词
    public static Map<String, Integer> match(String text) {
        Map<String, Integer> result = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            int currentState = 0;
            int matchLen = 0;
            int lastMatchLen = 0;

            for (int j = i; j < text.length(); j++) {
                char ch = text.charAt(j);
                Map<Character, Integer> edges = transitionMap.get(currentState);

                if (edges == null || !edges.containsKey(ch)) break;

                currentState = edges.get(ch);
                matchLen++;

                if (finalStateSet.contains(currentState)) {
                    lastMatchLen = matchLen;
                }
            }

            if (lastMatchLen > 0) {
                String word = text.substring(i, i + lastMatchLen);
                result.put(word, result.getOrDefault(word, 0) + 1);
                i += lastMatchLen - 1;
            }
        }
        return result;
    }

    // 测试
    public static void main(String[] args) {
        // 构建敏感词库
        build(Arrays.asList("冰毒", "法轮", "法轮功", "赌博"));

        // 测试文本
        String text = "我是一个好人，并不会卖冰毒，也不操练法轮功,真的不卖冰毒";

        // 匹配
        Map<String, Integer> hits = match(text);

        System.out.println("文本: " + text);
        System.out.println("命中: " + hits);
        // 输出: {冰毒=2, 法轮功=1}
    }
}
