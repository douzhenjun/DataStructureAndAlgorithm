package od真题.分类.二分法._97矩阵匹配;

import java.util.Scanner;
import java.util.Vector;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-06
 **/
public class Solution {

    static int n, m, k;
    static Vector<Vector<Integer>> myMap;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        myMap = new Vector<>(n + 1);
        //初始化myMap并添加m+1个子向量
        for (int i = 0; i <= n; i++) {
            myMap.add(new Vector<>(m + 1));
            for (int j = 0; j <= m; j++) {
                myMap.get(j).add(0);
            }
        }
        int mx = 0;
        //读取用户输入的数字并存储在myMap中
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int num = scanner.nextInt();
                myMap.get(i).set(j, num);
                mx = Math.max(mx, myMap.get(i).get(j));
            }
        }

        int result = solve(mx);
        System.out.println(result);
    }

    //找到一个点的Muniu匹配的方法
    static boolean findMuniu(int x, Vector<Vector<Boolean>> mp, Vector<Boolean> chw, Vector<Integer> match) {
        //遍历myMap的列向量的每个元素
        for (int j = 1; j <= m; j++) {
            if (mp.get(x).get(j) && chw.get(j)) {
                chw.set(j, false);
                if (match.get(j) == 0 || findMuniu(match.get(j), mp, chw, match)) {
                    match.set(j, x);
                    return true;
                }
            }
        }
        return false;
    }

    //检查给定正数p是否满足条件
    static boolean check(int p) {
        //创建一个新的Vector<Vector<Boolean>>对象mp
        Vector<Vector<Boolean>> mp = new Vector<>(n + 1);
        //为mp的每个字向量添加m+1个子向量
        for (int i = 0; i <= n; i++) {
            mp.add(new Vector<>(m + 1));
            for (int j = 0; j <= m; j++) {
                mp.get(i).add(false);
            }
        }

        //遍历myMap的行向量中的每个元素
        for (int i = 1; i <= n; i++) {
            //遍历myMap的列向量中的每个元素
            for (int j = 1; j <= m; j++) {
                //如果myMap的行向量中的元素小于等于p
                mp.get(i).set(j, myMap.get(i).get(j) <= p);
            }
        }

        //创建一个新的Vector<Integer>对象match
        Vector<Integer> match = new Vector<>(m + 1);
        for (int i = 0; i <= m; i++) {
            match.add(0);
        }

        //计算满足条件的匹配数
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            Vector<Boolean> chw = new Vector<>(m + 1);
            for (int j = 0; j <= m; j++) {
                chw.add(true);
            }
            if (findMuniu(i, mp, chw, match)) {
                ans++;
            }
        }
        return ans >= n - k + 1;
    }

    //根据给定的最大值mx找到满足条件的正数p的值 
    static int solve(int mx) {
        int l = 1, r = mx;
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
