package 力扣真题.回溯.组合总和3;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-13
 **/
public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1, 0);
        return result;
    }

    public void backtracking(int k, int n, int startIndex, int sum){
        if(path.size() == k){
            if(sum == n){
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for(int i = startIndex; i <= 9; i++){
            path.add(i);
            sum += i;
            backtracking(k, n, i+1, sum);
            path.remove(path.size()-1);
            sum -= i;
        }
    }
}
