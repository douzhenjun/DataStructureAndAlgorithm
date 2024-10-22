package 力扣真题.二叉树.二叉树的层序遍历.基本问题;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 非递归条件下使用队列
 * @Author douzhenjun
 * @DATE 2024-01-24
 **/
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        deque.addLast(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> nodeList = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = deque.removeFirst();
                nodeList.add(node.getVal());
                if(node.getLeft()!=null){
                    deque.addLast(node.getLeft());
                }
                if(node.getRight()!=null){
                    deque.addLast(node.getRight());
                }
            }
            result.add(nodeList);
        }
        return result;
    }
}
