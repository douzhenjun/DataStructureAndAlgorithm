package od真题.总览._105推荐多样性;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-08
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //读取输入的行数和列数
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        //用于存储输入数据的二维列表
        List<List<Integer>> arr = new ArrayList<>();
        //不定行输入,通过捕捉异常来判断是否结束输入
        while (true) {
            try {
                //读取一行数据并转换为整数列表
                List<Integer> row = new ArrayList<>();
                Scanner lineScanner = new Scanner(scanner.nextLine());
                while (lineScanner.hasNextInt()) {
                    row.add(lineScanner.nextInt());
                }
                arr.add(row);
            } catch (Exception e) {
                break;
            }
        }
        //用于存储输出的二维数组
        int[][] mp = new int[m][n];
        //用于存储一维数组
        List<Integer> nums = new ArrayList<>();
        int[] target = new int[arr.size()];
        //将列表数据转换成一维数据,填充整个二维窗口
        while (nums.size() < n * m) {
            for (int i = 0; i < arr.size(); i++) {
                int nxt = Math.min(arr.get(i).size(), target[i] + 4);
                for (int j = target[i]; j < nxt; j++) {
                    nums.add(arr.get(i).get(j));
                    target[i] = nxt;
                }
            }
        }
        //将一维数组转换成二维数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mp[i][j] = nums.get(i * n + j);
            }
        }
        //输出二维数组
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                System.out.print(mp[i][j] + " ");
            }
        }
    }
}
