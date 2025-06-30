package 剑指offer.剑指offer32_层序遍历二叉树.从上到下打印二叉树2;

import 二叉树.二叉树节点类.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author dou_zhenjun
 * @date 2023/3/12
 */
public class PrintByFloor2 {
    
    public static void printTreeNode(TreeNode root){
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root == null){
            System.out.println("二叉树节点为空!");
            return;
        }
        queue.offer(root);
        //定义两个变量, 分别记录下层应该打印的节点数目以及该层剩余打印节点数目,方便程序换行
        int nextLevelPrintNum = 0;//下一层打印数,默认为0
        int toBePrintNum = 1;//当前层剩余打印数,当他为0时换行
        while(!queue.isEmpty()){
            while(toBePrintNum > 0){
                TreeNode top =  queue.poll();
                if(top.getLeft() != null){
                    queue.offer(top.getLeft());
                    nextLevelPrintNum++;
                }
                if(top.getRight() != null){
                    queue.offer(top.getRight());
                    nextLevelPrintNum++;
                }
                
                System.out.printf("%-5d", top.getData());
                toBePrintNum--;
            }
            toBePrintNum = nextLevelPrintNum;
            System.out.println();//换行
            nextLevelPrintNum = 0;
        }
    }
}
