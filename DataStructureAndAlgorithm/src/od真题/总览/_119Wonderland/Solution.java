package od真题.总览._119Wonderland;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-11
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入并转为整数列表
        String costInput = scanner.nextLine();
        String daysInput = scanner.nextLine();
        String[] costArray = costInput.split(" ");
        String[] daysArray = daysInput.split(" ");
        List<Integer> cost = new ArrayList<>();
        List<Integer> days = new ArrayList<>();

        for (String str : costArray) {
            cost.add(Integer.parseInt(str));
        }

        for (String str : daysArray) {
            days.add(Integer.parseInt(str));
        }

        int[] choose = {1, 3, 7, 30};  // 不同的购买方案
        boolean[] isPlay = new boolean[366];

        // 标记游玩日期
        for (int x : days) {
            isPlay[x] = true;
        }

        int[] f = new int[366];
        Arrays.fill(f, (int)1e9);
        f[0] = 0;

        for (int i = 1; i < 366; i++) {
            if (isPlay[i]) {  // 当天是游玩日
                for (int j = 0; j < 4; j++) {  // 考虑四种不同的购买方案
                    f[i] = Math.min(f[i], f[Math.max(0, i - choose[j])] + cost.get(j));
                }
            } else {
                f[i] = f[i - 1];
            }
        }

        System.out.println(f[365]);
    }
}
