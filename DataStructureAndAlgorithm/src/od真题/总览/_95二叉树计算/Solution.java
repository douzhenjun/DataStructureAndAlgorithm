package od真题.总览._95二叉树计算;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-05
 **/
public class Solution {
    static class Node {
        Node left = null;
        Node right = null;
        int val;
    }

    static int[] mid;//中序遍历数组
    static int[] front;//前序遍历数组

    //构建二叉树, 参数l1, r1为当前节点在所表示的树在中序遍历中的位置
    //x表示这个节点的根节点在前序遍历中的位置
    static Node build(int l1, int r1, int x) {
        if (l1 > r1) {
            return null;
        }
        Node res = new Node();
        res.val = front[x];
        if (l1 == r1) {
            return res;
        }
        for (int i = l1; i <= r1; i++) {
            if (mid[i] == front[x]) {
                //递归创建左端点
                res.left = build(l1, i - 1, x + 1);
                //递归创建右端点, 根据左子树在中序遍历中的长度, 计算出右子树的根节点在前序遍历中的位置
                res.right = build(i + 1, r1, x + i - l1 + 1);
                break;
            }
        }
        return res;
    }

    //进行dfs遍历,计算节点值并返回新树
    static Node dfs(Node root) {
        int sum = 0;
        Node res = new Node();
        res.val = 0;
        if (root.left != null) {
            res.left = dfs(root.left);
            res.val += root.left.val;
            root.val += root.left.val;
        }
        if (root.right != null) {
            root.right = dfs(root.right);
            res.val += root.right.val;
            root.val += root.right.val;
        }
        return res;
    }

    //中序遍历输出新树节点值
    static void mdfs(Node ans) {
        if (ans.left != null) {
            mdfs(ans.left);
        }
        System.out.print(ans.val + " ");
        if (ans.right != null) {
            mdfs(ans.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s1 = sc.nextLine().split(" ");
        String[] s2 = sc.nextLine().split(" ");
        int n = s1.length;
        if (n > 20) {
            return;
        }
        mid = new int[n];
        front = new int[n];
        for (int i = 0; i < n; i++) {
            mid[i] = Integer.parseInt(s1[i]);
            front[i] = Integer.parseInt(s2[i]);
        }
        Node root = build(0, n - 1, 0);
        Node ans = dfs(root);
        mdfs(ans);
    }
}
