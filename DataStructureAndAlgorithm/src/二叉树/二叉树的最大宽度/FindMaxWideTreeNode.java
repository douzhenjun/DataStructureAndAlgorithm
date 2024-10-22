package 二叉树.二叉树的最大宽度;

import 二叉树.二叉树节点类.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class FindMaxWideTreeNode {
    
    public static int getMaxWideTreeNode(TreeNode root){
        if(root == null){
            return 0;
        }
        
        Deque<TreeNode> queue = new LinkedList<>();
        int maxWide = 0;
        queue.offer(root);
        //将二叉树节点重新赋值,新的值为它作为满二叉树层序遍历的顺序.
        root.setData(1);
        
        while(!queue.isEmpty()){
            //获得当前序列的长度
            int levelCount = queue.size();
            int left = queue.peekFirst().getData();
            int right = queue.peekLast().getData();
            maxWide = Math.max(maxWide, right - left + 1);
//            System.out.println("levelCount="+levelCount);
            //按照当前长度将节点一个一个移出队列,在移出的同时,如果该节点有子节点,将子节点加入到队列中
            for(int i = 0; i < levelCount; i++){
                TreeNode node = queue.poll();
                if(node.getLeft() != null){
                    queue.offer(node.getLeft());
                    node.getLeft().setData(node.getData()*2);
//                    System.out.println(node.getLeft().getData());
                }
                if(node.getRight() != null){
                    queue.offer(node.getRight());
                    node.getRight().setData(node.getData()*2+1);
//                    System.out.println(node.getRight().getData());
                }
            }
        }
        return maxWide;
    }

    public static void main(String[] args) {
        //示例1
        TreeNode root = new TreeNode(1);
        TreeNode lchild1 = new TreeNode(3);
        TreeNode rchild1 = new TreeNode(2);
        TreeNode lchild2 = new TreeNode(5);
        TreeNode rchild2 = new TreeNode(3);
        TreeNode rchild3 = new TreeNode(9);
        root.setLeft(lchild1);
        root.setRight(rchild1);
        lchild1.setLeft(lchild2);
        lchild1.setRight(rchild2);
        rchild1.setRight(rchild3);

        int maxWide = FindMaxWideTreeNode.getMaxWideTreeNode(root);
        System.out.println(maxWide);

//        //示例2
//        TreeNode root2 = new TreeNode(1);
//        TreeNode lchild21 = new TreeNode(3);
//        TreeNode lchild22 = new TreeNode(5);
//        TreeNode rchild21 = new TreeNode(3);
//        root2.setLeft(lchild21);
//        lchild21.setLeft(lchild22);
//        lchild21.setRight(rchild21);
//        maxWide = FindMaxWideTreeNode.getMaxWideTreeNode(root2);
//        System.out.println(maxWide);
//        
//        //示例4
//        TreeNode root4 = new TreeNode(1);
//        TreeNode lchild41 = new TreeNode(3);
//        TreeNode lchild42 = new TreeNode(5);
//        TreeNode lchild43 = new TreeNode(6);
//        TreeNode rchild41 = new TreeNode(2);
//        TreeNode rchild42 = new TreeNode(9);
//        TreeNode rchild43 = new TreeNode(7);
//        root4.setLeft(lchild41);
//        root4.setRight(rchild41);
//        lchild41.setLeft(lchild42);
//        rchild41.setRight(rchild42);
//        lchild42.setLeft(lchild43);
//        rchild42.setRight(rchild43);
//        
//        maxWide = FindMaxWideTreeNode.getMaxWideTreeNode(root4);
//        System.out.println(maxWide);
    }
}
