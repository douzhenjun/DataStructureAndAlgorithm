package od真题.分类.二分法._69小明找位置;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-29
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> w = new ArrayList<>();
        int x;
        while(scanner.hasNextInt()){
            x = scanner.nextInt();
            w.add(x);
        }
        x = w.remove(w.size() - 1);
        int l = 0;
        int r = w.size();
        while(l < r){
            int mid = (l + r) >>> 1;
            if(w.get(mid) >= x){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        System.out.println(l + 1);
    }
}
