package od真题.分类.硬骨头._27模拟路径管理.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-01
 **/
public class Solution {

    static class Node {
        String path;
        Map<String, Node> next;

        public Node(String path, Node father) {
            this.path = path;
            this.next = new HashMap<>();
            this.next.put("..", father);
        }
    }

    static boolean check1(String order) {
        return order.matches("[a-z]+");
    }

    static boolean check2(String order) {
        return order.equals("..") || order.matches("[a-z]+");
    }
    
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node tree = new Node("/", null);
        Node nowNode = tree;
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String[] input = scanner.nextLine().split(" ");
                if (input[0].equals("mkdir")) {
                    if(input.length != 2 || !check1(input[1]) || nowNode.next.containsKey(input[1])){
                        sb.append("\n");
                    } else {
                        nowNode.next.put(input[1], new Node(nowNode.path + input[1] + "/", nowNode));
                    }
                }else if(input[0].equals("cd")){
                    if(input.length != 2 || !check2(input[1]) || input[1].contains("/") 
                            || !nowNode.next.containsKey(input[1])
                            || nowNode.next.get(input[1]) == null){
                        sb.append("\n");
                    }else{
                        nowNode = nowNode.next.get(input[1]);
                        sb.append("\n");
                    }
                }else{
                    if(input.length != 1){
                        sb.append("\n");
                    }else{
                        sb.append(nowNode.path).append("\n");
                    }
                }
            } catch (Exception e) {
                break;
            }
        }
        
        String[] resArray = sb.toString().split("\n");
        for(int i = resArray.length - 1; i >= 0; i--){
            if(!resArray[i].isEmpty()){
                System.out.println(resArray[i]);
                break;
            }
        }
    }
}
