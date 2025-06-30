package 力扣真题.二叉树.验证二叉搜索树;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

import java.util.Stack;

/**
 * @Description 利用中序遍历结果一定是升序数组来判断，该代码还可以被优化，stack2可以不必构造
 * @Author douzhenjun
 * @DATE 2024-02-20
 **/
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack1 = new Stack<>();//辅助栈用来中序遍历二叉树
        Stack<Integer> stack2 = new Stack<>();//用来缓存遍历到的二叉树节点的值
        TreeNode cur = root;//定义一个指针

        //两个while循环是必要的,首先要保证栈非空的时候不能够退出循环,但一开始栈1一定是空的,为了避免无法进入循环
        //加一个条件cur != null,并且这个条件还可以用来新增栈顶元素的右孩子
        while (cur != null || !stack1.isEmpty()) {
            //这里如果cur==null那么就不用新增元素,cur始终指向栈顶元素的右孩子,但是对栈1的出栈操作不受到影响
            while (cur != null) {
                stack1.push(cur);
                cur = cur.left;
            }
            //这里不能用while循环,因为需要定义指针cur指向栈顶元素的右孩子,而此时栈未必空
            if (!stack1.isEmpty()) {
                TreeNode topNode = stack1.pop();
                if (stack2.isEmpty()) {
                    stack2.push(topNode.val);//如果栈2为空,那么直接将数据压入
                } else {
                    if (topNode.val <= stack2.peek()) {
                        return false;//如果栈1顶部的元素大小小于等于栈2的顶部元素,这违背了二叉搜索树的原则,直接返回false
                    }
                    stack2.push(topNode.val);
                }
                cur = topNode.right;
            }
        }
        return true;
    }
}
