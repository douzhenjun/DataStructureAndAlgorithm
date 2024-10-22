package 华为面试模拟题.在线游戏运营商;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-28
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<int[]> inputList = new ArrayList<>();
        while(true){
            String line = scanner.nextLine();
            if(line.isEmpty()){
                break;
            }
            int[] tmpArray = new int[2];
            String[] input = line.split(",");
            tmpArray[0] = Integer.parseInt(input[0]);
            tmpArray[1] = Integer.parseInt(input[1]);
            if(tmpArray[0] >= 0 && tmpArray[0] < 10000 && tmpArray[1] >= 0 && tmpArray[1] < 10000){
                inputList.add(tmpArray);
            }
        }
        System.out.println(findNumOfPeople(inputList));
    }
    
    private static int findNumOfPeople(List<int[]> inputList){
        //按照左端点从小到大排序
        inputList.sort((x, y) -> {
            return Integer.compare(x[0], y[0]);
        });
        int size = inputList.size();
        int res = 1;
        if(size < 2){
            return res;
        }
        int count = 1;//记录连续交叉的区间最大数量
        for(int i = 1; i < size; i++){
            if(inputList.get(i)[0] <= inputList.get(i-1)[1]){
                count++;
                res = Math.max(res, count);
                inputList.get(i)[1] = Math.min(inputList.get(i-1)[1], inputList.get(i)[1]);
            }else{
                count = 1;
            }
        }
        return res;
    }
}
