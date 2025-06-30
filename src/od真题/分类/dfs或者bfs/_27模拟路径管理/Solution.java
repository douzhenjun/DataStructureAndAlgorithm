package od真题.分类.dfs或者bfs._27模拟路径管理;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-24
 **/
public class Solution {

    static class Node {
        String path;
        Map<String, Node> next;

        Node(String path, Node fa) {
            this.path = path;
            this.next = new HashMap<>();
            this.next.put("..", fa);
        }
    }

    static Node newNode(String path, Node fa) {
        return new Node(path, fa);
    }

    static boolean check1(String s) {
        return s.matches("[a-z]+");
    }

    static boolean check2(String s) {
        return s.equals("..") || s.matches("[a-z]+");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node tree = newNode("/", null);     //创建根节点
        Node nowNode = tree;                        //当前所在节点
        StringBuilder result = new StringBuilder(); //存储结果的字节符

        while (true) {
            try {
                String input = scanner.nextLine();
                String[] s = input.split(" ");
                if (s[0].equals("mkdir")) {
                    if (s.length != 2 || !check1(s[1]) || nowNode.next.containsKey(s[1])) {
                        result.append("\n");
                    } else {
                        nowNode.next.put(s[1], newNode(nowNode.path + s[1] + "/", nowNode));
                        result.append("\n");
                    }
                } else if (s[0].equals("cd")) {
                    if (s.length != 2 || !check2(s[1])
                            || s[1].contains("/")
                            || !nowNode.next.containsKey(s[1])
                            || nowNode.next.get(s[1]) == null) {
                        result.append("\n");
                    } else {
                        nowNode = nowNode.next.get(s[1]);
                        result.append("\n");
                    }
                } else {
                    if (s.length != 1) {
                        result.append("\n");
                    } else {
                        result.append(nowNode.path).append("\n");
                    }
                }
            } catch (Exception e) {
                break;
            }
        }
        String[] resArray = result.toString().split("\n");
        for (int i = resArray.length - 1; i >= 0; i--) {
            if (!resArray[i].isEmpty()) {
                System.out.println(resArray[i]);//输出最终结果
                break;
            }
        }
    }
}
