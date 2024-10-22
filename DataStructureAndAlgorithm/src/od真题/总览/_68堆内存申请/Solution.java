package od真题.总览._68堆内存申请;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-28
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        List<Pair> arr = new ArrayList<>();
        int l;
        int r;
        while (scanner.hasNextInt()) {
            l = scanner.nextInt();
            r = scanner.nextInt();
            arr.add(new Pair(l, l + r - 1));
        }
        
        Collections.sort(arr, (x, y) -> {
            return x.first - y.first;
        });
        int m = arr.size();
        if (!check(arr)) {
            System.out.println(-1);
        } else {
            int pos = -1;//起始位置
            int diff = (int) 1e9;//偏移量
            for (int i = 0; i < m; i++) {
                if (i == 0) {
                    if (arr.get(i).first >= n && Math.abs(arr.get(i).first - n) < diff) {
                        pos = 0;
                        diff = Math.abs(arr.get(i).first - n);
                    }
                } else if (arr.get(i).first - arr.get(i - 1).second > n &&
                        Math.abs(arr.get(i).first - arr.get(i - 1).second - n) < diff) {
                    pos = arr.get(i - 1).second + 1;
                    diff = Math.abs(arr.get(i).first - arr.get(i - 1).second - n);
                }
            }
            if(99 - arr.get(m - 1).second >= n && Math.abs(99 - arr.get(m - 1).second - n) < diff){
                pos = arr.get(m - 1).second + 1;
            }
            System.out.println(pos);
        }
    }

    static class Pair implements Comparable<Pair> {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.first, other.first);
        }
    }
    
    private static boolean check(List<Pair> arr){
        int m = arr.size();
        for(int i = 0; i < m; i++){
            int x = arr.get(i).first;
            int y = arr.get(i).second;
            //判断是否满足条件：x和y非负，且x<100, y<100, 且x小于y
            if(x < 0 || y < 0 || x >= 100 || y >= 100 || x > y){
                System.out.println(x + " " + y);
                return false;
            }
            //判断是否有重叠空间
            if(i > 0 && x <= arr.get(i-1).second){
                return false;
            }
        }
        return true;
    }
}
