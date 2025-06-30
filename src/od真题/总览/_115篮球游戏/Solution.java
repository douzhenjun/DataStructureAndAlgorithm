package od真题.总览._115篮球游戏;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-11
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[205];
        int[] b = new int[205];
        int cnta = 0, cntb = 0;
        int[] q = new int[2 * 205];
        int qbot = 0, qtop = -1;//队首和队尾

        // 读取输入字符串
        String stra = scanner.next();
        String strb = scanner.next();
        stra += ",";
        strb += ",";

        // 将逗号分隔的数字提取到数组中
        int na = 0, nb = 0;
        for (int i = 0; i < stra.length(); i++) {
            if (stra.charAt(i) == ',') {
                a[++cnta] = na;
                na = 0;
            } else {
                na = na * 10 + stra.charAt(i) - '0';
            }
        }

        for (int i = 0; i < strb.length(); i++) {
            if (strb.charAt(i) == ',') {
                b[++cntb] = nb;
                nb = 0;
            } else {
                nb = nb * 10 + strb.charAt(i) - '0';
            }
        }

        int j = 1;
        StringBuilder ans = new StringBuilder();
        boolean f = true;

        // 遍历数组 b 中的元素
        for (int i = 1; i <= cntb; i++) {
            // 判断队列是否为空或者队尾和队头的元素均不等于当前 b[i]
            if (qtop < qbot || (qtop >= qbot && q[qtop] != b[i] && q[qbot] != b[i])) {
                // 在数组 a 中查找 b[i] 的位置，并将查找过程中的元素依次入队
                while (j <= cnta && a[j] != b[i]) {
                    q[++qtop] = a[j++];
                }

                // 如果找到 b[i] 的位置，将其入队
                if (j <= cnta) {
                    q[++qtop] = a[j++];
                } else {
                    // 如果数组 a 已遍历完，但仍未找到 b[i]，则无法按照 b 的顺序构造队列
                    f = false;
                    break;
                }
            }

            // 判断队列中的情况并更新结果字符串 ans
            if (qtop >= qbot && q[qtop] == b[i]) {
                if (qtop == qbot) {
                    ans.append("L");
                    qbot++;
                } else {
                    ans.append("R");
                    qtop--;
                }
            } else if (qtop >= qbot && q[qbot] == b[i]) {
                ans.append("L");
                qbot++;
            } else {
                // 如果队列中不存在 b[i]，则无法按照 b 的顺序构造队列
                f = false;
                break;
            }
        }

        // 输出结果
        if (!f) {
            System.out.println("No");
        } else {
            System.out.println(ans);
        }
    }
}
