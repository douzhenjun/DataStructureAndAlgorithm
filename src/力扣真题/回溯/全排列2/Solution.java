package 力扣真题.回溯.全排列2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-02
 **/
public class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    
    public List<List<Integer>> permuteUnique(int[] nums){
        used = new boolean[nums.length];
        Arrays.sort(nums);
        permuteHelper(nums);
        return result;
    }
    
    public void permuteHelper(int[] nums){
        if(path.size() == nums.length){
            result.add(new LinkedList<>(path));
        }
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1] && !used[i-1] || used[i]){
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            permuteHelper(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}
