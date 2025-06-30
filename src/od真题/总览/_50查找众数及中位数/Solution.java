package od真题.总览._50查找众数及中位数;

import java.util.*;

/**
 * @Description
 * 
 * @Author douzhenjun
 * @DATE 2024-03-26
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] w = new int[input.length];
        for(int i = 0; i < input.length; i++){
            w[i] = Integer.parseInt(input[i]);
        }
        Map<Integer, Integer> mp = new HashMap<>();//记录数字及其出现的次数
        for(int x : w){
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }
        int maxCnt = Collections.max(mp.values());//获得values最大的那个值
        List<Integer> num = new ArrayList<>();
        for(int k : mp.keySet()){
            if(mp.get(k) == maxCnt){
                num.add(k);
            }
        }
        Collections.sort(num);
        int n = num.size();
        if(n % 2 == 1){
            System.out.println(num.get(n / 2));
        }else{
            System.out.println((num.get(n / 2) + num.get(n / 2 - 1)) / 2);
        }
    }
}
