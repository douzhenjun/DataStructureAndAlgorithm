package od真题.总览._61整数对最小和;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-27
 **/
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] nums1 = new int[m];
        for (int i = 0; i < m; i++) {
            nums1[i] = scanner.nextInt();
        }
        System.out.println(Arrays.stream(nums1).boxed().collect(Collectors.toList()));
        int n = scanner.nextInt();
        int[] nums2 = new int[n];
        for (int j = 0; j < n; j++) {
            nums2[j] = scanner.nextInt();
        }
        System.out.println(Arrays.stream(nums2).boxed().collect(Collectors.toList()));
        int k = scanner.nextInt();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int res = 0;
        int i = 0;//nums1的下标
        int j = 0;//nums2的下标
        while (k > 0) {
            res += (nums1[i] + nums2[j]);
            if (i == nums1.length - 1 && j < nums2.length - 1) {
                j++;
            }
            if (j == nums2.length - 1 && i < nums1.length - 1) {
                i++;
            }
            if (i < nums1.length - 1 && j < nums2.length - 1) {
                if (nums1[i] > nums2[j]) {
                    i++;
                } else if (nums1[i] == nums2[j]) {
                    if (nums1[i + 1] > nums2[j + 1]) {
                        j++;
                    } else {
                        i++;
                    }
                } else {
                    j++;
                }
            }
            k--;
        }
        System.out.println(res);
    }
}
