package 力扣真题.二叉树.二叉树的层序遍历.N叉树的层序遍历;

import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-13
 **/
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
