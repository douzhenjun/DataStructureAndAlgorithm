package 二叉树.字符串是否在二维数组中;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//基于前缀树的写法
public class FindString2 {
    
    //查找方法
    public static List<String> findWord(char[][] boards, String[] words){
        TrieTree tt = new TrieTree();
        TrieNode root = new TrieNode();
        List<String> list = new ArrayList<>();
        for(String word : words){
            tt.insert(root, word);
//            System.out.println(tt.search(root, word));
            //声明指针指向根节点位置.如果没有这个声明,那么下面的dfs方法会让root指向它的某个子节点,但每次搜索肯定要回到根部位置的.
            TrieNode trieNode = root;
            /*dfs(boards, word, 0, 0, trieNode, list); 写错了,做个标记,后面是改正的. 这个错误主要在于它限制了二维数组起始查找位置的自由性*/
            for(int i = 0; i < boards.length; i++){
                for(int j = 0; j < boards[0].length; j++){
//                    dfs(boards, word, i, j, trieNode, list);
                }
            }
            System.out.println(tt.search(root, word));
        }
        
        return list;
    }
    
    public static void dfs(char[][] boards, String word, int i, int j, TrieNode root, List<String> list){
        //1.越界情况排除 
        if(i<0||i>=boards.length||j<0||j>=boards[0].length){
            return;
        }
        //2.被走过的地方标记为'#',再走到就返回
        if(boards[i][j] == '#'){
            return;
        }
        //3.如果root为空或者root的对应字母序号的子节点为空,则返回,否则,root指向它的子节点children[index].
        int index = boards[i][j] - 'a';
        if(root == null || root.children[index] == null){
            return;
        }else{
            //4.如果此时root.isWord=true,说明word在boards中,将word添加到list中,返回
            if(root.isWord != null/* && root.isWord.equals(word) && !list.contains(word)*/){
                list.add(word);
                return;
            }
            root = root.children[index];
        }
        //5.查询以后,将路径做个标记,这里就是直接修改了boards[i][j]的值,继续向四个方向寻找
        char tmp = boards[i][j];
        boards[i][j] = '#';
        dfs(boards, word, i-1, j, root, list);
        dfs(boards, word, i+1, j, root, list);
        dfs(boards, word, i, j-1, root, list);
        dfs(boards, word, i, j+1, root, list);
        boards[i][j] = tmp;
    }

    public static void main(String[] args) {
        char [][] boards = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i','h','k','r'}, {'i','f','l','v'}};
//        char [][] boards = {{'o', 'a', 't', 'h'}, {'e', 't', 'a', 'e'}, {'i','h','k','r'}, {'i','f','l','v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.print("boards=[");
        for(char[] bb : boards){
            System.out.print(Arrays.toString(bb));
        }
        System.out.println("]");

        System.out.println("words="+Arrays.toString(words));
        
        List<String> list = findWord(boards, words);

        System.out.println("results="+Arrays.toString(list.toArray()));//标准输出:eat oath
    }
}
