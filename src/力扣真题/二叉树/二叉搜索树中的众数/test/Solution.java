package 力扣真题.二叉树.二叉搜索树中的众数.test;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

import java.util.*;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-22
 **/
public class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> result = new ArrayList<>();
    public int[] findMode(TreeNode root){
        traverse(root);
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());
        int maxCount = 0;
        for(Map.Entry<Integer, Integer> entry : entryList){
            if(entry.getValue() >= maxCount){
                maxCount = entry.getValue();
                result.add(entry.getKey());
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public void traverse(TreeNode root){
        if(root == null){
            return;
        }
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        traverse(root.left);
        traverse(root.right);
    }
}
