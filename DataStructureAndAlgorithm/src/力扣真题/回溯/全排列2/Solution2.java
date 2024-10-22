package 力扣真题.回溯.全排列2;

import java.util.*;

/**
 * @Description 使用used数组枝去重,使用hashset层去重
 * @Author douzhenjun
 * @DATE 2024-03-02
 **/
public class Solution2 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new LinkedList<>();
    boolean[] used;
    
    public List<List<Integer>> permuteUnique(int[] nums){
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(nums);
        return result;
    }
    
    public void backtracking(int[] nums){
        if(path.size() == nums.length){
            result.add(new LinkedList<>(path));
            return;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            //hashSet在每个递归函数中声明用来记录nums[i]的使用情况,避免重复元素被使用,造成重复的排列
            //因为对下一层递归函数不可见,因此如果集合中存在重复的元素,是不影响下一层函数使用的
            if(hashSet.contains(nums[i])){
                continue;
            }
            if(used[i]){//因为是排列,需要从0开始遍历,但遍历过的元素不应该被再次遍历到,因此用used[i]来记录一下
                continue;
            }
            hashSet.add(nums[i]);
            used[i] = true;
            path.add(nums[i]);
            backtracking(nums);
            path.remove(path.size()-1);
            used[i] = false;//这里需要回溯是因为对于当前的for循环来说,第一次的枝去重会影响到第二次的排列结果,因此需要消除
        }
    }
}
