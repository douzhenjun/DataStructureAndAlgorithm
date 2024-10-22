package 链表中的下一个更大结点;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextLargestNodes {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode node1 = new ListNode(2);
        head.setNext(node1);
        ListNode node2 = new ListNode(1);
        node1.setNext(node2);
        ListNode node3 = new ListNode(5);
        node2.setNext(node3);

    }
   //使用暴力求解
    public int[] nextLargerNodes(ListNode node){
        List<Integer> list = new ArrayList<>();
        while (node != null){
            list.add(node.getData());
            node = node.getNext();
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size() - 1; i++){
            for(int j = i + 1; j < list.size(); j++){
                if(list.get(j) > list.get(i)){
                    res[i] = list.get(j);
                    break;
                }
            }
        }
        return res;
    }

    //使用栈求解
    public int[] nextLargerNodes2(ListNode node){
        List<Integer> list = new ArrayList<>();
        while (node != null){
            list.add(node.getData());
            node = node.getNext();
        }
        //栈中存储的是元素的下标,并且从栈底到栈顶元素在集合中的对应的值是从大到小的
        Stack<Integer> stack = new Stack<>();
        int [] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            while(!stack.empty() && list.get(stack.peek()) < list.get(i)){
                int index = stack.pop();
                res[index] = list.get(i);
            }
            stack.push(i);
        }
        return res;
    }
}
