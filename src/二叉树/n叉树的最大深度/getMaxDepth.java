package 二叉树.n叉树的最大深度;

import java.util.ArrayList;
import java.util.List;

public class getMaxDepth {
    
    
    public int getMaxDepth(Node root){
        if(root == null){
            return 0;
        }
        //当前结点子节点的个数
        int size = root.chidren.size();
        int max = 0;
        
        for(int i = 0; i < size; i++){
            max = Math.max(max, getMaxDepth(root.chidren.get(i)));
        }
        return max+1;
    }
    
    
    public static void main(String[] args) {
        Node root = new Node();
        root.data = 1;
        root.chidren = new ArrayList<>(4);
        List<Node> children1 = root.chidren;
        }
    
}


class Node{
     int data;
     List<Node> chidren;
}
