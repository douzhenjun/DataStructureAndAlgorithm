package od真题.分类.硬骨头._41攀登者2;

import java.util.Scanner;

/**
 * @Description
 * 登山时会消耗登山者的体力,上山时,消耗相邻高度差两倍的体力,下坡时消耗相邻高度差一倍的体力,
 * 平地不消耗体力.登山者体力上限999
 * 登山时的起点和终点可以是地图中任何高度为0的地面.
 * @Author douzhenjun
 * @DATE 2024-03-25
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] hillMap = parseArray(scanner.nextLine());
        int strength = Integer.parseInt(scanner.nextLine());
        System.out.println(countClimbable(hillMap, strength));
    }

    static int[] parseArray(String input) {
        String[] values = input.split("\\s+");
        int[] array = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            array[i] = Integer.parseInt(values[i]);
        }
        return array;
    }

    static int countClimbable(int[] hillMap, int strength) {
        int n = hillMap.length;
        //初始化数组L,R,表示从左右两边攀爬到当前位置的代价
        int[] L = new int[n + 1];
        int[] R = new int[n + 1];
        
        for (int i = 1; i < n - 1; i++) {
            //计算从hillMap[i]向左攀爬到hillMap[j]的体力消耗R[j]
            if (hillMap[i] == 0 && i - 1 > 0 && hillMap[i - 1] != 0) {
                int j = i - 1;
                R[i] = 0;
                while (j >= 0 && hillMap[j] != 0) {
                    if (hillMap[j] > hillMap[j + 1]) {
                        R[j] = R[j + 1] + 2 * (hillMap[j] - hillMap[j - 1]);
                    } else {
                        R[j] = R[j + 1] + (hillMap[j + 1] - hillMap[j]);
                    }
                    j--;
                }
            }
            //计算从hillMap[i]向右攀爬到hillMap[j]的体力消耗L[j]
            if (hillMap[i] == 0 && i + 1 < n && hillMap[i + 1] != 0) {
                int j = i + 1;
                L[i] = 0;
                while (j < n && hillMap[j] > 0) {
                    if (hillMap[j] > hillMap[j - 1]) {
                        L[j] = L[j - 1] + 2 * (hillMap[j] - hillMap[j - 1]);
                    } else {
                        L[j] = L[j - 1] + (hillMap[j - 1] - hillMap[j]);
                    }
                    j++;
                }
            }
        }

        //
        int[] LL = new int[n + 1];
        int[] RR = new int[n + 1];
        for (int i = 1; i < n; i++) {
            if (hillMap[i] == 0) {
                LL[i] = 0;
            } else {
                if (hillMap[i - 1] > hillMap[i]) {
                    LL[i] = LL[i - 1] + 2 * (hillMap[i - 1] - hillMap[i]);
                } else {
                    LL[i] = LL[i - 1] + hillMap[i] - hillMap[i - 1];
                }
            }
        }

        //计算从右边攀爬到当前位置的总代价
        for (int i = n - 2; i >= 0; i--) {
            if (hillMap[i] == 0) {
                RR[i] = 0;
            } else {
                if (hillMap[i + 1] > hillMap[i]) {
                    RR[i] = RR[i + 1] + 2 * (hillMap[i + 1] - hillMap[i]);
                } else {
                    RR[i] = RR[i + 1] + hillMap[i] - hillMap[i + 1];
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i < n - 1; i++) {
            if (hillMap[i] > hillMap[i - 1] && hillMap[i] > hillMap[i + 1]) {
                long ans = 10L * 10L * 10L * 10L * 10L * 10L * 10L * 10L * 10L;
                if (L[i] != -1) {
                    ans = Math.min(ans, L[i] + LL[i]);
                }
                if (R[i] != -1) {
                    ans = Math.min(ans, R[i] + RR[i]);
                }
                if (L[i] != -1 && R[i] != -1) {
                    ans = Math.min(Math.min(L[i] + RR[i], R[i] + LL[i]), ans);
                }
                if (ans <= strength) {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }
}
