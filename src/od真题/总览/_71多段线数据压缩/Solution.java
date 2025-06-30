package od真题.总览._71多段线数据压缩;

import java.util.*;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-29
 **/
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> w = new ArrayList<>();
        while(scanner.hasNextInt()){
            w.add(scanner.nextInt());
        }
        //存储结果的列表
        List<Map.Entry<Integer, Integer>> res = new ArrayList<>();
        res.add(new AbstractMap.SimpleEntry<>(w.get(0), w.get(1)));
        
        int n = w.size();
        for(int i = 2; i < n; i += 2){
            if(res.size() == 1){
                res.add(new AbstractMap.SimpleEntry<>(w.get(i), w.get(i + 1)));
            }else{
                int m = res.size();
                int a = res.get(m - 1).getKey() - res.get(m - 2).getKey();
                int b = res.get(m - 1).getValue() - res.get(m - 2).getValue();
                int g = gcd(Math.abs(a), Math.abs(b));
                int a1 = a / g;
                int b1 = b / g;
                
                a = w.get(i) - res.get(m - 1).getKey();
                b = w.get(i + 1) - res.get(m - 1).getValue();
                g = gcd(Math.abs(a), Math.abs(b));
                
                int a2 = a / g;
                int b2 = b / g;
                
                if(a1 == a2 && b1 == b2){
                    res.remove(res.size() - 1);
                }
                res.add(new AbstractMap.SimpleEntry<>(w.get(i), w.get(i + 1)));
            }
        }
        
        for(Map.Entry<Integer, Integer> entry : res){
            System.out.print(entry.getKey() + " " + entry.getValue() + " ");
        }
        
    }
    
    private static int gcd(int a , int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp; 
        }
        return a;
    }
}
