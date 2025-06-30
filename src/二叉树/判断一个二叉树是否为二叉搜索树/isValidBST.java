package 二叉树.判断一个二叉树是否为二叉搜索树;

import java.util.LinkedList;

public class isValidBST {
    private static LinkedList<Integer> linkedList = new LinkedList<>();


    public static void main(String[] args) {
        //1.构造一个二叉树
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(16);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(13);
        node2.left = node3;
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(3);
        node1.left = node4;
        node4.left = node5;
        node4.right = node5;

        //2.将二叉树的结点的数据按照中序遍历的顺序依次存入一个链表中
        storeTreeNodeData(root);

        //3.通过检查是否存在违反升序的情况存在,若有,则返回false,否则返回true
        System.out.println("判断这个二叉树是否是二叉搜索树:" + isValidBST(linkedList));
    }

    public static void storeTreeNodeData(TreeNode root){
        if(root != null){
            storeTreeNodeData(root.left);
            linkedList.add(root.val);
            storeTreeNodeData(root.right);
        }
    }

    public static boolean isValidBST(LinkedList<Integer> list){
        boolean flag = true;

        for(int i = 0; i < list.size()-1; i++){
            if(list.get(i) >= list.get(i+1)){
                flag = false;
                return flag;
            }
        }
        return flag;
    }
}

class TreeNode{
    int val = -1;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}

