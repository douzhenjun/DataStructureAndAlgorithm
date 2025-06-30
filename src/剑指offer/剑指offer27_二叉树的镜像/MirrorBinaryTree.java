package 剑指offer.剑指offer27_二叉树的镜像;


public class MirrorBinaryTree {
    
    public static void getMirrorBinaryTree(Node node){
        if(node == null){
            return;
        }
        if(node.getLchild() == null && node.getRchild() == null){
            return;
        }
        Node tmp = node.getLchild();
        node.setLchild(node.getRchild());
        node.setRchild(tmp);
        if(node.getLchild() != null){
            getMirrorBinaryTree(node.getLchild());
        }
        if(node.getRchild() != null){
            getMirrorBinaryTree(node.getRchild());
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 6, 10, 5, 7, 9, 11};
        Node root = new Node();
        root.construct(root, 0, arr);
        Node.traverseInPreOrder(root);
        System.out.println("-------------------------");
        getMirrorBinaryTree(root);
        Node.traverseInPreOrder(root);
        /**
             *        1                                     1
             *   2          3           =>          3               2 
         *   null   4    5     null            null    5        4      null   
         *   
         */
        Node root2 = new Node(1, new Node(), new Node());
        root2.getLchild().setData(2);
        root2.getRchild().setData(3);
        root2.getLchild().setLchild(null);
        root2.getLchild().setRchild(new Node(4, null, null));
        root2.getRchild().setLchild(new Node(5, null, null));
        root2.getRchild().setRchild(null);
        Node.traverseInPreOrder(root2);
        getMirrorBinaryTree(root2);
        Node.traverseInPreOrder(root2);
    }
}

    