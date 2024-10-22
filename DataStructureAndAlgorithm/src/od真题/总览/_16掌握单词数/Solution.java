package od真题.总览._16掌握单词数;

import org.junit.Test;

import java.util.*;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-22
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] w = new String[n];
        for(int i = 0; i < n; i++){
            w[i] = sc.next();
        }
        String t = sc.next();
        
        System.out.println(getResult(w, t));
        
    }
    
    @Test
    public void test01(){
        String[] w = {"cat", "bt", "hat", "tree"};
        String t = "atach??";
        System.out.println(getResult(w, t));

        String[] w2 = {"apple", "car", "window"};
        String t2 = "welldoneapplec?";
        System.out.println(getResult(w2, t2));
    }
    
    private static int getResult(String[] w, String t){
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        //开始程序步骤
        int count = 0;
        for(int i = 0; i < w.length; i++){
            Map<Character, Integer> tempMap = new HashMap<>(map);
            if(check(w[i], tempMap)){
                count++;
            }
        }
        return count;
    }
    
    private static boolean check(String target, Map<Character, Integer> map){
        char[] chars = target.toCharArray();
        char wh = '?';
        for(int i = 0; i < chars.length; i++){
            if(map.containsKey(chars[i])){
                map.put(chars[i], map.get(chars[i]) - 1);
                if(map.get(chars[i]) == 0){
                    map.remove(chars[i]);
                }
            }else{
                if(map.containsKey(wh)){
                    map.put(wh, map.get(wh) - 1);
                    if(map.get(wh) == 0){
                        map.remove(wh);
                    }
                }else{
                    return false; 
                }
            }
        }
        return true;
    }
}
