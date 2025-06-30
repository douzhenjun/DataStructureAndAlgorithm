package 力扣真题.二叉树.根据先序数组和中序数组构建二叉树.从中序与后序遍历序列构造二叉树;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-21
 **/
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = traverse(inorder, 0, inorder.length, postorder, 0, postorder.length);
        return root;
    }

    private TreeNode traverse(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd){
        //递归边界条件
        if(inBegin >= inEnd || postBegin >= postEnd){
            return null;
        }
        int lastOfPost = postorder[postEnd-1];//获得后序遍历数组中的最后一个元素
        int delimeter = 0;//获得上面这个元素在中序数组中的位置
        for(int i = 0; i < inEnd; i++){
            if(inorder[i] == lastOfPost){
                delimeter = i;
            }
        }
        TreeNode root = new TreeNode(lastOfPost);//以该元素创建一个TreeNode二叉树节点
        //左闭右开,以delimeter为分界点将中序数组分成左右两个部分,后序数组按照中序数组的分法模仿,因为可以证明
        //后序数组中的左(或右)半部分和中序数组的左(或右)半部分的元素个数是相同的
        root.left = traverse(inorder, inBegin, delimeter, postorder, postBegin, postBegin+delimeter-inBegin);
        root.right = traverse(inorder, delimeter+1, inEnd, postorder, postBegin+delimeter-inBegin, postEnd-1);
        return root;
    }
}
