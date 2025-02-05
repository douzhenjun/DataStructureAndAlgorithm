package 力扣真题.二叉树._1609奇偶树;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

import java.util.LinkedList;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-11-10
 **/
public class Solution {
    
    public boolean isEvenOddTree(TreeNode root) {
        LinkedList<TreeNode> nodes = new LinkedList<>();
        if ((root.val & 1) == 0) {
            return false;
        }
        nodes.add(root);
        int level = 0;
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode top = nodes.poll();
                if (top.left != null) {
                    nodes.add(top.left);
                }
                if (top.right != null) {
                    nodes.add(top.right);
                }
            }
            level++;
            for (int j = 0; j < nodes.size(); j++) {
                if ((level & 1) == 1) {
                    if ((nodes.get(j).val & 1) == 1 || (j > 0 && nodes.get(j).val >= nodes.get(j - 1).val)) {
                        return false;
                    }
                } else {
                    if ((nodes.get(j).val & 1) == 0 || (j > 0 && nodes.get(j).val < nodes.get(j - 1).val)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
