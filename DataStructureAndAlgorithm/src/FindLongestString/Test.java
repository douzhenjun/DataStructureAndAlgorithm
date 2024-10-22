package FindLongestString;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('b', 2);
        System.out.println(map.get('a'));
        map.put('a', 3);
        System.out.println(map.get('a'));
        int num = map.get('c');
        System.out.println(num);
    }
}
