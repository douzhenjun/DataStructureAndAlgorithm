package 测试题;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer,Integer> map = new TreeMap<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int index = sc.nextInt();
            int value = sc.nextInt();
            map.put(index,map.getOrDefault(index,0)+value);
        }
        for(Integer i : map.keySet()){
            System.out.println(i+" "+map.get(i));
        }

    }
}
