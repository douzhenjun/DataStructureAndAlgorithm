package GetNextTreeNode;

/**
 *  问题描述:按照中序遍历的方式寻找任意一个结点的下一个结点,并通过返回这个结点的数据值以验证.
 */
public class GetNextTreeNode {
    public static void main(String[] args) {
        TreeNode root = constructTree();
        TreeNode node = root.left.left;
        node = root.left;
        node = root.right.left;
        TreeNode next_node = getNextTreeNode(node);
        try {
            System.out.println("这个结点的下一个结点的数据为"+ next_node.val);
        } catch (Exception e) {
            System.out.println("对不起,这个结点下一个结点为空!");
        }

    }

    public static TreeNode getNextTreeNode(TreeNode node){
        if(node == null){
            return null;
        }
        if(node.right != null){
            node = node.right;
            while(node.left != null){
                node = node.left;
            }
            return node;
        }else{
            while(node.parent != null){
                TreeNode node1 = node.parent;
                if(node1.left == node){
                    return node1;
                }
                node = node1;
            }
            return null;
        }
    }

    public static TreeNode constructTree(){
        TreeNode node1 = new TreeNode('a');
        TreeNode node2 = new TreeNode('b');
        TreeNode node3 = new TreeNode('c');
        node1.left = node2;
        node1.right = node3;
        node2.parent = node1;
        node3.parent = node1;
        TreeNode node4 = new TreeNode('d');
        TreeNode node5 = new TreeNode('e');
        TreeNode node6 = new TreeNode('f');
        TreeNode node7 = new TreeNode('g');
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.parent = node2;
        node5.parent = node2;
        node6.parent = node3;
        node7.parent = node3;
        TreeNode node8 = new TreeNode('h');
        TreeNode node9 = new TreeNode('i');
        node5.left = node8;
        node5.right = node9;
        node8.parent = node5;
        node9.parent = node5;
        return node1;
    }
}
class TreeNode{
    char val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;

    //TreeNode left, TreeNode right, TreeNode parent,
    public TreeNode(char val){
        this(null, null, null);
        this.val = val;
    }


    public TreeNode(TreeNode left, TreeNode right, TreeNode parent){
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

//    public TreeNode(char val){
//        this.val = val;
//    }

}