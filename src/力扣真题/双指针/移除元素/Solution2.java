package 力扣真题.双指针.移除元素;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-01-01
 **/
/*
  快慢指针法:定义一个快指针一个慢指针
  慢指针初始指向首部元素,快指针向前遍历,当快指针直到有效数组元素位置的时候,
  覆盖慢指针,然后慢指针自增,慢指针所指的位置就是最后有效数组的长度
 */
public class Solution2 {
    public int removeVal(int[] nums, int val){
        int slowIndex = 0;
        for(int fastIndex = slowIndex; fastIndex < nums.length; fastIndex++){
            if(nums[fastIndex] != val){
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }
}
