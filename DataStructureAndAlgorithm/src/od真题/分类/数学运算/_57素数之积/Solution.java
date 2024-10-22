package od真题.分类.数学运算._57素数之积;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-26
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> res = new ArrayList<>();
        int cnt = 0;
        
        //
        for(int i = 2; i <= n; i++){
            if(n % i == 0){
                res.add(i);
            }
            while(n % i == 0){
                cnt++;
                n /= i;
            }
            if(cnt > 2){
                break;
            }
        }
        if(cnt != 2){
            System.out.println("-1 -1");
        }else{
            System.out.println(res);
        }
    }
}
