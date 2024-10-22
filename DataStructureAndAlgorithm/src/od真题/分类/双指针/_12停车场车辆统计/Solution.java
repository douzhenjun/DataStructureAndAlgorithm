package od真题.分类.双指针._12停车场车辆统计;

import org.junit.Test;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-22
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] cars1 = str.split(",");
        int[] cars = new int[cars1.length];
        for(int i = 0; i < cars.length; i++){
            if(cars1[i].equals("1")){
                cars[i] = 1;
            }
        }
        System.out.println(getLeastCars(cars));
    }
    
    @Test
    public void test(){
        int[] cars = {1, 0, 1};
        System.out.println(getLeastCars(cars));
        int[] cars2 = {1, 1, 0, 0, 1, 1, 1, 0, 1};
        System.out.println(getLeastCars(cars2));
    }
    
    private static int getLeastCars(int[] cars){
        int left = 0;
        int right = 0;
        int res = 0;
        while(left < cars.length){
            if(cars[left] == 0){
                left++;
                continue;
            }
            right = left;
            while(right < cars.length && cars[right] != 0){
                right++;
            }
            int count = right - left;
            while(count > 0){
                if(count >= 3){
                    count -= 3;
                }else if(count >= 2){
                    count -= 2;
                }else{
                    count--;
                }
                res++;
            }
            left = right;
        }
        return res;
    }
}
