package 力扣真题.二叉树._1609奇偶树;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description dfs方法解决
 * dfs传递root,层数level以及长度和层数有关的mList,该mList永远存储最新的level层的节点值
 * dfs的内容就是向节点root的左,右子树递归遍历,在level层遍历到的节点需要满足
 * 1.节点数字和level的奇偶性相反
 * 2.level如果是奇数,那么后一个节点数字大于前一个节点数字,否则小于前一个节点数字
 * @Author douzhenjun
 * @DATE 2024-11-10
 **/
public class Solution2 {
    public boolean isEvenOddTree(TreeNode root) {
        List<Integer> mList = new ArrayList<>();
        return dfs(root, mList, 0);
    }

    private boolean dfs(TreeNode root, List<Integer> mList, int level) {
        if (root == null) {
            return true;
        }
        if (root.val % 2 == level % 2) {
            return false;
        }
        if (mList.size() > level) {
            if ((level % 2 == 1 && mList.get(level) <= root.val) ||
                    ((level % 2 == 0) && mList.get(level) >= root.val)) {
                return false;
            }
            mList.set(level, root.val);
        } else {
            mList.add(root.val);
        }
        return dfs(root.left, mList, level + 1) && dfs(root.right, mList, level + 1);
    }
}
