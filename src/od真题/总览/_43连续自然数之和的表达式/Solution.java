package od真题.总览._43连续自然数之和的表达式;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-25
 **/
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List<Integer>> res = new ArrayList<>();
        int n = scanner.nextInt();
        n *= 2;
        
        for(int k = 1; k * k < n; k++){
            if(n % k != 0){
                continue;
            }
            //判断是否有解
            if((n / k - (k - 1)) % 2 == 0){
                List<Integer> temp = new ArrayList<>();
                temp.add((n / k - k + 1) / 2);
                temp.add(k);
                res.add(temp);
            }
        }

        // 输出所有解
        for (List<Integer> t : res) {
            int a = t.get(0);
            int k = t.get(1);
            System.out.print(n / 2 + "=");
            for (int i = 1; i <= k; i++) {
                System.out.print(a + i - 1);
                if (i < k) System.out.print("+");
            }
            System.out.println();
        }

        System.out.println("Result:" + res.size()); // 输出解的数量
    }
}
