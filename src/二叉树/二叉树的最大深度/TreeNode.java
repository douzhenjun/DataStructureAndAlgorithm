package 二叉树.二叉树的最大深度;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x){
        this.val = x;
    }

    //利用递归,通过比较一个节点的左右字数的最大递归深度得到这个节点的最大递归深度(+1)
    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public void preOrder(TreeNode root){
        if(root != null){
            System.out.print(root.val + ",");
            preOrder(root.left);
            preOrder(root.right);
        }

    }
}
