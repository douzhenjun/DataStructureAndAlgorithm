package 力扣真题.回溯.组合总和2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-02-29
 **/
public class Solution2 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return res;
    }
    
    private void backtracking(int[] candidates, int target, int start){
        if(sum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i < candidates.length && sum + candidates[i] <= target; i++){
            if(i > start && candidates[i] == candidates[i-1]){
                continue;
            }
            sum += candidates[i];
            path.add(candidates[i]);
            backtracking(candidates, target, i+1);
            
            int temp = path.getLast();
            sum -= temp;
            path.removeLast();
        }
    }
}
