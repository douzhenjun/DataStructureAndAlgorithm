package 力扣真题.二叉树.二叉树的层序遍历.二叉树的层平均值;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-13
 **/
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return result;
        }
        queue.offerLast(root);
        while(!queue.isEmpty()){
            Double average = 0.0;
            Double sum = 0.0;
            Double count = 0.0;
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++){
                TreeNode node = queue.pollFirst();
                sum += node.val;
                count += 1;
                if(node.left != null){
                    queue.offerLast(node.left);
                }
                if(node.right != null){
                    queue.offerLast(node.right);
                }
                if(i == queueSize-1){
                    average = sum / count;
                    result.add(average);
                }
            }
        }
        return result;
    }
}
