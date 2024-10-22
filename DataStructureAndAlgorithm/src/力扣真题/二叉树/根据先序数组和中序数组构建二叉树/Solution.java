package 力扣真题.二叉树.根据先序数组和中序数组构建二叉树;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-02-20
 **/
public class Solution {
    public TreeNode constructNode(int[] preOrder, int[] inOrder){
        return findNode(preOrder, 0, preOrder.length, inOrder, 0, inOrder.length);
    }
    
    public TreeNode findNode(int[] preOrder, int preBegin, int preEnd, int[] inOrder, int inBegin, int inEnd){
        if(preBegin >= preEnd || inBegin >= inEnd){
            return null;
        }
        int delimeter = 0;
        int firstEle = preOrder[preBegin];
        for(int i = inBegin; i < inEnd; i++){
            if(inOrder[i] == firstEle){
                delimeter = i;
            }
        }
        TreeNode node = new TreeNode(firstEle);
        int leftOfIn = delimeter - inBegin;
        int rightOfIn = inEnd - delimeter;
        node.left = findNode(preOrder, preBegin+1, preBegin+1+leftOfIn, inOrder, inBegin, delimeter);
        node.right = findNode(preOrder, preBegin+leftOfIn+1, preBegin+leftOfIn+rightOfIn, inOrder, delimeter+1, inEnd);
        return node;
    }
}
