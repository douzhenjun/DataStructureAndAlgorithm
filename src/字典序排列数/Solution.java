package 字典序排列数;

import java.util.ArrayList;
import java.util.List;

/*
给定一个整数,返回从1到n的字典序
*/
public class Solution {

    public void dfs(int cur, int n, List<Integer> res){
        if(cur < n){
            return;
        }
        res.add(cur);
        for(int i = 0; i < 10; i++){
            dfs(10 * cur + i, n, res);
        }
    }

    public List<Integer> lexicalOrder(int n){
        List<Integer> ans = new ArrayList<>(n);
        int curr = 1;
        for(int i = 1; i <= n; i++){
            ans.add(curr);
            if(curr * 10 <= n){
                curr *= 10;
            }else{
                while(curr % 10 == 9 || curr == n){
                    curr /= 10;
                }
                curr++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 20;
        Solution solution = new Solution();
        List<Integer> lst = solution.lexicalOrder(n);
        System.out.println("从1到"+n+"的字典序排序结果为:"+lst);
    }
}
