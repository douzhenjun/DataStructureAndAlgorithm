package 力扣真题.二叉树.二叉树的非递归遍历统一写法;

import 二叉树.二叉树节点类.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description 在使用栈结构遍历二叉树节点的过程中,一个很大的问题是节点的
 *              访问顺序往往和处理顺序不一致,这就使得当初我们必须在栈顶拿到元素后立刻就将
 *              数据写入到数组中.对于先序遍历(根-左-右)和后序遍历(左-右-根)这些容易实现.
 *              但对于中序遍历(左-根-右)就难以保证.因为前两个都是只需要存入root根节点,然后
 *              在每次弹栈操作的时候判断有没有左,右子节点,再按照顺序压入即可.而后者则是需要先访问
 *              左子树,所以栈顶元素是最小的左子树节点,访问到栈顶元素必然经过该节点的级联父类结点.这就是访问
 *              顺序和处理顺序不一致.所以中序遍历的方法和前两者不同,采用了一个指针始终指向栈顶元素,以
 *              指针是否为空来确定是否执行出栈操作(这和先序遍历只要栈不为空就出栈有区别,请注意)
 *              指针为空分两种情况,栈顶元素的左子节点为空或右子节点为空.无论是哪一种情况,都可以说明当前栈顶元素
 *              可以出栈了.
 *              当然我们可以统一这三个遍历方法的写法,只要让我们能够在适当的时机将栈中的元素写入到数组中,
 *              即使该元素被提前访问到只要没有信号,就不会做处理.这里考虑将这个信号定义为:只有访问到栈中null元素
 *              以后的非空元素才有资格被写入到数组中.
 * @Author douzhenjun
 * @DATE 2024-01-22
 **/
public class Solution {
    
    private static Stack<TreeNode> stack = new Stack<>();
    
    protected List<Integer> midOrder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root != null){
            stack.push(root);
        }
        while(!stack.isEmpty()){
            TreeNode top = stack.peek();
            if(top != null){
                stack.pop();
                if(top.getRight() != null){
                    stack.push(top.getRight());
                }
                stack.push(top);
                stack.push(null);
                if(top.getLeft() != null){
                    stack.push(top.getLeft());
                }
            }else{
                stack.pop();
                result.add(stack.peek().getData());
                stack.pop();
            }
        }
        return result;
    }

    protected List<Integer> preOrder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root != null){
            stack.push(root);
        }
        while(!stack.isEmpty()){
            TreeNode top = stack.peek();
            if(top != null){
                stack.pop();
                if(top.getRight() != null){
                    stack.push(top.getRight());
                }
                if(top.getLeft() != null){
                    stack.push(top.getLeft());
                }
                stack.push(top);
                stack.push(null);
            }else{
                stack.pop();
                result.add(stack.peek().getData());
                stack.pop();
            }
        }
        return result;
    }

    protected List<Integer> postOrder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root != null){
            stack.push(root);
        }
        while(!stack.isEmpty()){
            TreeNode top = stack.peek();
            if(top != null){
                stack.push(null);
                if(top.getRight() != null){
                    stack.push(top.getRight());
                }
                if(top.getLeft() != null){
                    stack.push(top.getLeft());
                }
            }else{
                stack.pop();
                result.add(stack.peek().getData());
                stack.pop();
            }
        }
        return result;
    }
}
