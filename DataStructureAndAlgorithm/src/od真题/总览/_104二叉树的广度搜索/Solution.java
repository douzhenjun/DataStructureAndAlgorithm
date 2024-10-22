package od真题.总览._104二叉树的广度搜索;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-08
 **/
class TreeNode {
    int val;  // 节点的值
    TreeNode left, right;  // 节点的左右子节点

    TreeNode(int val) {  // 节点的构造函数
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Solution {
    // 通过中序遍历和后序遍历的结果构建二叉树
    public static TreeNode buildTree(List<Integer> inorder, List<Integer> postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {  // 判断中序遍历和后序遍历的起始和结束位置
            return null;  // 如果起始位置大于结束位置，则返回空节点
        }

        int rootVal = postorder.get(postEnd);  // 后序遍历的最后一个节点为当前子树的根节点
        TreeNode root = new TreeNode(rootVal);  // 创建根节点

        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {  // 在中序遍历中找到根节点的位置
            if (inorder.get(i) == rootVal) {
                rootIndex = i;
                break;
            }
        }

        int leftSize = rootIndex - inStart;  // 计算左子树的节点个数

        // 递归构建左右子树
        root.left = buildTree(inorder, postorder, inStart, rootIndex - 1, postStart, postStart + leftSize - 1);
        root.right = buildTree(inorder, postorder, rootIndex + 1, inEnd, postStart + leftSize, postEnd - 1);

        return root;  // 返回根节点
    }

    // 广度优先遍历二叉树
    public static void bfs(TreeNode root) {
        if (root == null) {  // 如果根节点为空，则直接返回
            return;
        }

        List<TreeNode> queue = new ArrayList<>();  // 创建队列
        queue.add(root);  // 将根节点加入队列

        while (!queue.isEmpty()) {  // 遍历队列
            TreeNode node = queue.get(0);  // 获取队列的第一个节点
            queue.remove(0);  // 移除队列的第一个节点
            System.out.print((char) node.val);  // 输出节点的值（转为字符类型）

            if (node.left != null) {  // 如果左子节点不为空，则加入队列
                queue.add(node.left);
            }
            if (node.right != null) {  // 如果右子节点不为空，则加入队列
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String postorderString = scanner.next();  // 输入后序遍历结果
        String inorderString = scanner.next();  // 输入中序遍历结果

        int n = postorderString.length();  // 获取节点个数
        List<Integer> postorder = new ArrayList<>();  // 创建存储后序遍历结果的列表
        List<Integer> inorder = new ArrayList<>();  // 创建存储中序遍历结果的列表

        for (int i = 0; i < n; i++) {  // 遍历节点个数
            postorder.add((int) postorderString.charAt(i));  // 将后序遍历结果转为整数并加入列表
            inorder.add((int) inorderString.charAt(i));  // 将中序遍历结果转为整数并加入列表
        }

        TreeNode root = buildTree(inorder, postorder, 0, n - 1, 0, n - 1);  // 构建二叉树
        bfs(root);  // 广度优先遍历二叉树
    }
}

