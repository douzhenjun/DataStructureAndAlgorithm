package od真题.总览._96数的分解;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-06
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        n *= 2;//将问题转化为2n的形式
        int flag = 1;//判断有没有解
        for(int k = 2; k < Math.sqrt(n); k++){
            if(n % k != 0){
                continue;
            }
            //判断是否有解
            if((n / k - (k - 1)) % 2 == 0){
                int startNum = (n / k - k + 1) / 2;
                System.out.print(n / 2 + "=");
                
                //输出等号右边的部分
                for(int x = startNum; x < startNum + k; x++){
                    System.out.print(x);
                    if(x != startNum + k - 1){
                        System.out.print("+");
                    }
                }
                flag = 0;
                break;
            }
        }
        if(flag == 1){
            System.out.println("N");
        }
    }
}
