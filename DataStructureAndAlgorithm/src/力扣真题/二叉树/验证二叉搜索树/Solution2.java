package 力扣真题.二叉树.验证二叉搜索树;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

import java.util.Stack;

/**
 * @Description 优化后的版本,迭代法
 * @Author douzhenjun
 * @DATE 2024-02-26
 **/
public class Solution2 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();//辅助栈用来中序遍历二叉树
        TreeNode cur = root;//定义一个指针
        Integer preValue = null;//记录上一次出栈的栈顶元素val

        //这里定义一个循环，一开始栈为空，为了进入这个循环，定义cur ！= null
        //后面cur始终指向出栈元素的右孩子
        while (cur != null || !stack.isEmpty()) {
            //cur始终指向尚未被遍历过的节点，所以非空的话需要压入栈中
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }else{
                TreeNode topNode = stack.pop();
                //如果是第一次处理出栈元素,那么preValue初始化，否则preValue和栈顶元素进行大小比较
                if(preValue != null && topNode.val <= preValue){
                    return false;
                }
                //preValue值更新
                preValue = topNode.val;
                //cur值更新
                cur = topNode.right;
            }
        }
        return true;
    }
}
