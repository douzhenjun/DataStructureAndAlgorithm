package od真题.分类.排序._35机场航班调度程序;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-24
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputArray = scanner.nextLine().split(",");
        Arrays.sort(inputArray);
        System.out.println(String.join(",", inputArray));
    }
}
