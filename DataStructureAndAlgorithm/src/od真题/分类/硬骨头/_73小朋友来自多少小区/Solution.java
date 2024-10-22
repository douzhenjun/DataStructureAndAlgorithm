package od真题.分类.硬骨头._73小朋友来自多少小区;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-30
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] w = new int[input.length];
        
        for(int i = 0; i < input.length; i++){
            w[i] = Integer.parseInt(input[i]);
        }
        Map<Integer, Integer> cnts = new HashMap<>();
        for(int x : w){
            cnts.put(x, cnts.getOrDefault(x, 0) + 1);
        }
        long ans = 0;
        for(Map.Entry<Integer, Integer> entry : cnts.entrySet()){
            int k = entry.getKey();
            int v = entry.getValue();
            ans += (v + k) / (k + 1) * (k + 1);
        }
        System.out.println(ans);
    }
}
