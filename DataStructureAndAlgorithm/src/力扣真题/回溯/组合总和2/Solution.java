package 力扣真题.回溯.组合总和2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 使用标记数组used
 * @Author douzhenjun
 * @DATE 2024-02-29
 **/
public class Solution {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] used;
    int sum = 0;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        used = new boolean[candidates.length];
        Arrays.fill(used, false);
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return ans;
    }
    
    private void backtracking(int[] candidates, int target, int startIndex){
        if(sum == target){
            ans.add(new ArrayList<>(path));
        }
        for(int i = startIndex; i < candidates.length; i++){
            if(sum + candidates[i] > target){
                break;
            }
            if(i > 0 && candidates[i] == candidates[i-1] && !used[i-1]){
                continue;
            }
            used[i] = true;
            sum += candidates[i];
            path.add(candidates[i]);
            backtracking(candidates, target, i+1);
            used[i] = false;
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
