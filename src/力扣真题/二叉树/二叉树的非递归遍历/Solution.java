package 力扣真题.二叉树.二叉树的非递归遍历;

import 二叉树.二叉树节点类.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description 使用一个栈结构来缓存二叉树的节点,每次弹出时打印,注意入栈时和二叉树的遍历访问顺序相反
 * @Author douzhenjun
 * @DATE 2024-01-20
 **/
public class Solution {
    private static Stack<TreeNode> stack = new Stack<>();
    /**
     * 先将根节点压栈. 然后执行出栈操作,并且判断该节点是否有左,右子节点
     * 按照先右后左的顺序压栈，这样出栈的时候顺序就是根，左，右
     */
    protected List<Integer> preOrder(TreeNode root){
        if(root == null){
            return null;
        }
        List<Integer> result = new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode top = stack.peek();
            result.add(top.getData());
            stack.pop();
            if(top.getRight() != null){
                stack.push(top.getRight());
            }
            if(top.getLeft() != null){
                stack.push(top.getLeft());
            }
        }
        return result;
    }
    /**
     * 将根节点入栈,每次栈顶元素出栈时,判断是否有左右子节点,
     * 按照先左后右的顺序入栈. 这样出栈的时候就是先右后左，先根后子
     * 添加数组的顺序是根，右节点，左节点
     * 遍历的时候从后向前遍历即可
     */
    protected List<Integer> postOrder(TreeNode root){
        if(root == null){
            return null;
        }
        List<Integer> result = new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()){
           TreeNode top = stack.peek();
           stack.pop();
           result.add(top.getData());
           if(top.getLeft() != null){
               stack.push(top.getLeft());
           }
           if(top.getRight() != null){
               stack.push(top.getRight());
           }
        }
        //reverse
        int i = 0;
        int j = result.size()-1;
        while(i < j){
            int temp = result.get(i);
            result.set(i, result.get(j));
            result.set(j, temp);
            i++;
            j--;
        }
        return result;
    }
    
    /**
     * 首先将根节点入栈,然后定义一个指针每次指向入栈节点的左孩子,依次入栈.直到指针为空,则此时栈顶元素即为
     * 最深的左孩子节点.然后再执行出栈操作,每出栈一次,向数组中添加元素,并且指针指向出栈元素的右孩子.
     * 如果右孩子存在,则右孩子接着压入,出栈顺序就变成了左孩子,左孩子的父亲,左孩子父亲的右孩子.
     */
    protected List<Integer> middleOrder(TreeNode root){
        if(root == null){
            return null;
        }
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            if(cur != null){
                stack.push(cur);
                cur = cur.getLeft();
            }else{
                cur = stack.peek();
                stack.pop();
                result.add(cur.getData());
                cur = cur.getRight();
            }
        }
        return result;
    }
}
