package od真题.总览._61整数对最小和;

import java.util.ArrayList;
import java.util.Collections;
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
        List<Integer> v = new ArrayList<>();
        while(scanner.hasNextInt()){
            v.add(scanner.nextInt());
        }
        int k = v.get(v.size() - 1);
        v.remove(v.size() - 1);
        List<Integer> nums1 = new ArrayList<>();
        List<Integer> nums2 = new ArrayList<>();
        for(int i = 1; i <= v.get(0); i++){
            nums1.add(v.get(i));
        }
        for(int i = v.get(0) + 2; i < v.size(); i++){
            nums2.add(v.get(i));
        }
        List<Integer> sum = new ArrayList<>();
        for(int x : nums1){
            for(int y : nums2){
                sum.add(x + y);
            }
        }
        Collections.sort(sum);
        long s = 0;
        for(int i = 0; i < Math.min(k, sum.size()); i++){
            s += sum.get(i);
        }
        System.out.println(s);
    }
}
