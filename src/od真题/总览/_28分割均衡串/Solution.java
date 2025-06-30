package od真题.总览._28分割均衡串;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-24
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int ans = 0;
        int sum = 0;
        
        for(char ch : s.toCharArray()){
            if(ch == 'X'){
                sum++;
            }else{
                sum--;
            }
            if(sum == 0){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
