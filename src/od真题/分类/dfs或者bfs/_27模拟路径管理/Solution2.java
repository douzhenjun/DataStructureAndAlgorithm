package od真题.分类.dfs或者bfs._27模拟路径管理;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description
 * 定义一个Node节点,该节点包含两个变量,第一个变量path用来表明路径信息,第二个变量是一个Map对象,用来
 * 保存 路径-节点 键值对.
 * 主方法初始化一个根节点, 路径为"/", 父节点(上一层信息)为null
 * 定义一个StringBuilder对象用来保存用户回车之后的输出信息
 * 使用input[]数组用来获取用户的输入,根据用户的输入第一个字符串是否是1.mkdir2.cd3.pwd分别执行对应的操作
 * 如果是1,说明需要创建一个新的路径,输出"\n"即可,然后我们需要的是新建一个节点,以用户输入的第二个字符串为路径,父节点为当前路径.
 * 如果是2,说明需要进入一个路径,需要判断当前路径下的next中是否有input[1]这个路径,如果没有
 * @Author douzhenjun
 * @DATE 2024-04-01
 **/
public class Solution2 {

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
