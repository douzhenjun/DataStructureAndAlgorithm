package 二叉树.字符串是否在二维数组中;
/*前缀树的增加方法*/

class TrieNode{
     String isWord;
     TrieNode[] children = new TrieNode[26];
}
public class TrieTree {
    //插入字母到树, 传入树的根节点和待插入单词. isWord用于标志到这里一个单词就存好了.
    public void insert(TrieNode root, String word){
        TrieNode parentNode = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i)-'a';
            if(parentNode.children[index] == null){
                parentNode.children[index] = new TrieNode();
                parentNode = parentNode.children[index];
            }else{
                parentNode = parentNode.children[index];
            }
        }
        parentNode.isWord = word;
    }
    
    public boolean search(TrieNode root, String word){
        if(root == null){
            return false;
        }
        TrieNode parentNode = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(parentNode.children[index] == null){
                return false;
            }else{
                parentNode = parentNode.children[index];
                if(parentNode.isWord!=null && parentNode.isWord.equals(word)){
                    return true;
                }
            }
        }
        return true;
    }
}
