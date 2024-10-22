package 力扣真题.二叉树.二叉树的层序遍历.N叉树的层序遍历;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-13
 **/
public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Node> queue = new LinkedList<>();
        if(root == null){
            return result;
        }
        queue.offerLast(root);
        int level = 0;
        while(!queue.isEmpty()){
            level++;//定义层数用来初始化list数组
            int size = queue.size();//每次遍历前获得队列的长度
            for(int i = 0; i < size; i++){
                Node node = queue.pollFirst();
                //判断节点是否有子节点，如果有，那么将子节点加入队列中
                if(node.children != null && node.children.size() > 0){
                    for(int j = 0; j < node.children.size(); j++){
                        queue.offerLast(node.children.get(j));
                    }
                }
                if(result.size() < level){
                    result.add(new ArrayList<Integer>());
                }
                result.get(level-1).add(node.val);

            }
        }
        return result;
    }
}
