package od真题.总览._120小朋友最少调整次数;

import java.util.*;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-12
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> mp = new HashMap<>();
        boolean[] f = new boolean[1000];
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();

        //读取输入的字符串,分别处理成数字列表
        String stra = scanner.nextLine();
        String strb = scanner.nextLine();
        stra += " ";
        strb += " ";
        int current = 0;

        //处理输入的字符串并将数字添加到aList中
        for (int i = 0; i < stra.length(); i++) {
            if (Character.isDigit(stra.charAt(i))) {
                current = current * 10 + stra.charAt(i) - '0';
            } else {
                aList.add(current);
                current = 0;
            }
        }
        current = 0;
        //处理输入的字符串并将数字添加到bList中
        for (int i = 0; i < strb.length(); i++) {
            if (Character.isDigit(strb.charAt(i))) {
                current = current * 10 + strb.charAt(i) - '0';
            } else {
                bList.add(current);
                current = 0;
            }
        }
        
        int n = bList.size();
        
        //标记每个学生的组数
        for(int i = 0; i < n; i += 3){
            for(int j = 0; j < 3; j++){
                mp.put(bList.get(i + j), i / 3 + 1);
            }
        }
        int ans = 0;
        
        //不断重新排序,直到所有学生都在三连中
        while(true){
            boolean ff = false;
            //遍历aList,考虑连续的学生是否在同一组
            for(int i = 0; i < n; i++){
                int currentNum = aList.get(i);
                if(f[mp.get(currentNum)]){
                    continue;
                }
                int num = 1;
                //判断是否存在连续的学生在同一组
                if(i + 1 < n && mp.get(aList.get(i + 1)).equals(mp.get(currentNum))){
                    num++;
                }
                if (i + 2 < n && num == 2 && mp.get(aList.get(i + 2)).equals(mp.get(currentNum))) {
                    num++; 
                }
            }
        }
    }
}
