package 考试;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-18
 **/
public class Tests {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split(",");
        String[] nums2 = scanner.nextLine().split(",");
        System.out.println(Arrays.asList(nums));
        System.out.println(Arrays.asList(nums2));
    }
}
