package od真题.分类.排序._49按身高和体重排排队;

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
        int[] height = new int[n];
        int[] weight = new int[n];

        for (int i = 0; i < n; i++) {
            height[i] = scanner.nextInt();
        }
        List<int[]> person = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            person.add(new int[]{height[i], weight[i], i + 1});
        }
        person.sort((x, y) -> {
            if(x[0] != y[0]) return Integer.compare(x[0], y[0]);
            if(x[1] != y[1]) return Integer.compare(x[1], y[1]);
            return Integer.compare(x[2], y[2]);
        });
        
        for(int i = 0; i < n; i++){
            System.out.println(person.get(i)[2]);
            if(i + 1 < n){
                System.out.print(" ");
            }
        }
    }
}
