package od真题.分类.根堆._22生成哈夫曼树;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-23
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //优先级队列,优先级可以通过Comparable/Comparator来实现
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            Node node = new Node();
            node.weight = scanner.nextLong();
            minHeap.offer(node);
        }
        while(minHeap.size() > 1){
            Node left = minHeap.poll();
            Node right = minHeap.poll();
            Node pnode = new Node();
            pnode.weight = left.weight + right.weight;
            pnode.height = Math.max(left.height, right.height) + 1;
            pnode.left = left;
            pnode.right = right;
            minHeap.offer(pnode);
        }
        Node root = minHeap.poll();
        inorder(root);
    }
    
    static void inorder(Node node){
        if(node == null){
            return;
        }
        inorder(node.left);
        System.out.print(node.weight + " ");
        inorder(node.right);
    }
    
}

class Node implements Comparable<Node>{
    long weight;//权值
    int height;//高度
    Node left;
    Node right;
    
    public Node(){
        this.height = 1;
        this.left = null;
        this.right = null;
    }

    @Override
    public int compareTo(Node o) {
        if(this.weight != o.weight){
            return Long.compare(this.weight, o.weight);//小顶堆,按照权值升序排列
        }else{
            return Integer.compare(this.height, o.height);//权值相同,则树高度升序排序
        }
    }
}
