package od真题.分类.dfs或者bfs._84考古学家;

import java.util.*;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-04
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine()); // 输入的字符串数量
        String[] a = scanner.nextLine().split(" "); // 输入的字符串列表，按字典序排序
        Arrays.sort(a);
        Set<String> res = new HashSet<>(); // 结果集，保存所有的排列结果
        dfs(0, new ArrayList<>(), new boolean[n], a, res); // 从空状态开始进行深度优先搜索，初始状态所有字符串都未选择
        List<String> sortedRes = new ArrayList<>(res);
        Collections.sort(sortedRes); // 将结果集排序
        for (String x : sortedRes) {
            System.out.println(x); // 输出所有的排列结果
        }
    }

    public static void dfs(int cnt, List<String> now, boolean[] bk, String[] a, Set<String> ans) {
        if (cnt == a.length) { // 如果已经选择了n个字符串
            ans.add(String.join("", now)); // 将当前排列结果添加到结果集中
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (bk[i]) { // 如果字符串已经被选择过，则跳过
                continue;
            }
            if (i == 0 || !a[i].equals(a[i - 1]) || !bk[i - 1]) { // 只选择第一次出现的字符，进行剪枝
                now.add(a[i]); // 选择当前字符串
                bk[i] = true; // 标记当前字符串已经选择
                dfs(cnt + 1, now, bk, a, ans); // 继续选择下一个字符串
                bk[i] = false; // 恢复当前字符串的选择状态，进行回溯
                now.remove(now.size() - 1); // 撤销选择
            }
        }
    }
}
