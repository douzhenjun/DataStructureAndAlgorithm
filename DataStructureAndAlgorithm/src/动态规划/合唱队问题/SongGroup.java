package 动态规划.合唱队问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 输入一个身高序列, 输出最少去掉几个同学, 能够形成合唱队形.
 * 实例:186 186 150 200 160 130 197 200
 * 输出:4
 */
public class SongGroup {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        List<Integer> lst = new ArrayList<>();
//        String line = sc.nextLine();
//        Scanner sc2 = new Scanner(line);
//        while(sc2.hasNextInt()){
//            lst.add(sc2.nextInt());
//        }
//        int length = lst.size();
//        System.out.println(length);
        List<Integer> lst = new ArrayList<>();
        int[] lst2 = {186, 186, 150, 200, 160, 130, 197, 200};
        for (int i : lst2) {
            lst.add(i);
        }
        
        int length = lst.size();//定义保存身高的数组的长度
        List<Integer> leftList = new ArrayList<>();//定义位置左边满足条件的个数
        List<Integer> rightList = new ArrayList<>();//定义位置右边满足条件的个数
        //左右列表初始化长度为length
        for (int i = 0; i < length; i++) {
            leftList.add(0);
            rightList.add(0);
        }
        
        //最左边元素左边人数为1(包括自己),最右边元素右边人数为1
        leftList.set(0,1);
        rightList.set(length-1,1);
        
        //对左列表赋值,包括自己在内,左边的元素小于该值,则人数加1
        for (int i = 0; i < length; i++) {
            leftList.set(i , 1);
            for (int j = 0; j <= i; j++) {
                if(lst.get(j) < lst.get(i)){
                    leftList.set(i, Math.max(leftList.get(i),leftList.get(j)+1));
                }
            }
        }
        
        //对右列表赋值,包括自己在内,右边的元素小于该值,则人数加1
        for (int i = length-1; i >= 0; i--){
            rightList.set(i, 1);
            for (int j = length-1; j >= i; j--){
                if(lst.get(j) < lst.get(i)){
                    rightList.set(i, Math.max(rightList.get(i),rightList.get(j)+1));
                }
            }
        }
        
        //定义规划二维数组, dp[i][i]用以保存以lst[i]为中心的最长合唱队列长度, 
        // dp[i][j]则用来保存dp[i][i]和dp[j][j]中的最大值, 这样推算dp[length-1][length-1]是最大值
        int[][] dp = new int[length][length];
//        int maximum = -1;
        
        //初始化dp[i][i]
        for(int i=0;i<dp.length;i++){
            dp[i][i] = leftList.get(i)+rightList.get(i)-1;
//            maximum = (dp[i][i]>maximum)?dp[i][i]:maximum;
        }
        
        //计算dp[i][j] = Math.max(dp[i][i],dp[j][j])
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = Math.max(dp[i][i], dp[j][j]);
//                maximum = (dp[i][i]>maximum)?dp[i][i]:maximum;
            }
        }
        
        System.out.println(length-dp[length-1][length-1]);
    }
}
