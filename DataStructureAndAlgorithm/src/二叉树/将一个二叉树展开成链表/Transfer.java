package 二叉树.将一个二叉树展开成链表;

import 二叉树.二叉树节点类.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
*   1.先序遍历二叉树,将遍历到的元素保存到一个列表中;
*   2.新建一个二叉树结点, 它的左孩子为null, 右孩子为list[i]
*   3.从二叉树中获得新的list.
* 
* */
public class Transfer {
    
    List<Integer> list_input = new ArrayList<>();
    
    List<Integer> list_output = new ArrayList<>();
    
    /*从二叉树获得值写道输入列表中*/
    public void getListInput(TreeNode root){
        if(root == null){
            return;
        }
        list_input.add(root.getData());
        getListInput(root.getLeft());
        getListInput(root.getRight());
    }
    
    /*将列表中元素写道一颗新二叉树中,或者说展开成了链表*/
    public TreeNode getNewTree(TreeNode root, Object[] list){
        TreeNode node = root;
        for(Integer ele : list_input){
            node.setData(ele);
            TreeNode node2 = new TreeNode();
            node.setRight(node2);
            node = node2;
        }
        
        return root;
    }
    
    /*从二叉树中获得元素写入列表*/
    public void getListOutput(TreeNode root){
        if(root == null){
            return;
        }
        list_output.add(root.getData());
        list_output.add(null);
        getListOutput(root.getRight());
    }

    public static void main(String[] args) {
        Object[] list = new Object[]{1, 2, 3, 4, 5, null, 6};
    }
}
