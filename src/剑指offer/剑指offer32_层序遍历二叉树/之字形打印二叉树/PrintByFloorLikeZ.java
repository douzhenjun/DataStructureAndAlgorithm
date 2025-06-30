package 剑指offer.剑指offer32_层序遍历二叉树.之字形打印二叉树;

import 二叉树.二叉树节点类.TreeNode;

import java.util.Stack;

/**
 * 按照之字形层序遍历，并按行打印元素
 * @author dou_zhenjun
 * @date 2023/3/16
 */
public class PrintByFloorLikeZ {
    
    public static void PrintTreeData(TreeNode root){
        if(root == null){
            System.out.println("根节点为空!");
            return;
        }
        //1.初始化数据结构和变量，stack1保存奇数层节点，stack2保存偶数层节点
        //下一层打印节点初始值为0， 第一层待打印节点初始值为1， 第一层为奇数层。
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        int nextLevelNum = 0;
        int toBePrintNum = 1;
        boolean isOdd = true;
        //将根节点入栈
        stack1.push(root);
        //2.进入循环，退出条件是两个栈都为空
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            //3.按层打印的步骤, 如果当前层待打印的节点数>0, 那么说明当前层元素还没有打印完, 循环不跳出
            while(toBePrintNum > 0){
                //根据层数的奇偶性判断先从左边子节点入栈还是右边子节点入栈
                if(isOdd){
                    TreeNode top = stack1.pop();
                    System.out.printf("%-5d", top.getData());
                    toBePrintNum--;
                    if(top.getLeft() != null){
                        stack2.push(top.getLeft());
                        nextLevelNum++;
                    }
                    if(top.getRight() != null){
                        stack2.push(top.getRight());
                        nextLevelNum++;
                    }
                }else{
                    TreeNode top = stack2.pop();
                    System.out.printf("%-5d", top.getData());
                    toBePrintNum--;
                    if(top.getRight() != null){
                        stack1.push(top.getRight());
                        nextLevelNum++;
                    }
                    if(top.getLeft() != null){
                        stack1.push(top.getLeft());
                        nextLevelNum++;
                    }
                }
            }
            //每一层打印完, 更新待打印节点数, 下一层待打印节点数和下一层的奇偶性, 并换行
            toBePrintNum = nextLevelNum;
            nextLevelNum = 0;
            isOdd = !isOdd;
            System.out.println();
        }
    }
}
