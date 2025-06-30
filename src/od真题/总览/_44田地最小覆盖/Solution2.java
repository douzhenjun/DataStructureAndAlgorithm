package od真题.总览._44田地最小覆盖;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-25
 **/
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();//m
        int n = scanner.nextInt();//n
        int[][] tudi = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tudi[i][j] = scanner.nextInt();
            }
        }
        System.out.println(getMaxField(tudi));
    }
    
    @Test
    public void test01(){
      int[][] tudi = {{1, 0, 1}, {0, 0, 0}, {0, 1, 0}};
        System.out.println(getMaxField(tudi));
    }

    public static int getMaxField(int[][] tudi) {
        Map<Integer, ArrayList<int[]>> mp = new HashMap<>();
        for (int i = 0; i < tudi.length; i++) {
            for (int j = 0; j < tudi[0].length; j++) {
                if (tudi[i][j] != 0) {
                    if (!mp.containsKey(tudi[i][j])) {
                        mp.put(tudi[i][j], new ArrayList<>());
                    }
                    mp.get(tudi[i][j]).add(new int[]{i, j});
                }
            }
        }
        int res = 0;//保存结果
        for (Map.Entry<Integer, ArrayList<int[]>> entry : mp.entrySet()) {
//            int num = entry.getKey();
            ArrayList<int[]> pairs = entry.getValue();
            int maxRow = 0;
            int maxCol = 0;
            int minRow = Integer.MAX_VALUE;
            int minCol = Integer.MAX_VALUE;
            for (int[] ele : pairs) {
                minRow = Math.min(minRow, ele[0]);
                minCol = Math.min(minCol, ele[1]);
                maxRow = Math.max(maxRow, ele[0]);
                maxCol = Math.max(maxCol, ele[1]);
            }
            res = Math.max(res, (maxRow - minRow + 1) * (maxCol - minCol + 1));
        }
        return res;
    }
}
