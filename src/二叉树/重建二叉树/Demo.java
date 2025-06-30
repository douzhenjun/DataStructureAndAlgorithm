package 二叉树.重建二叉树;

import 二叉树.二叉树节点类.TreeNode;

public class Demo {
//    private static int[] preArray = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
//    private static int[] inArray = new int[]{4, 7, 2, 1, 5, 3, 8, 6};

    private static int[] preArray = new int[]{1, 2, 3, 4, 5, 6};
    private static int[] inArray = new int[]{6, 5, 4, 3, 2, 1};
    public static void main(String[] args) {
        TreeNode root = null;
        root = reconstructBinaryTree(0, preArray.length-1,
                                    0, inArray.length-1);
        traverseInOrder(root);
    }

    /**
     * 中序遍历二叉树
     * @param root
     */
    private static void traverseInOrder(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode left = root.getLeft();
        traverseInOrder(left);
        System.out.println(root.getData());
        TreeNode right = root.getRight();
        traverseInOrder(right);
    }

    /**
     * 递归重组二叉树
     * @param startPreOrder 先序列表的起始下标
     * @param endPreOrder   先序列表的末尾下标
     * @param startInOrder  中序列表的起始下标
     * @param endInOrder    中序列表的末尾下标
     * @return 二叉树
     */
    public static TreeNode reconstructBinaryTree(int startPreOrder, int endPreOrder,
                                             int startInOrder, int endInOrder) {

        int rootValue = preArray[startPreOrder];//每次找到前序数组的第一个元素,就是根元素,赋值给一个根结点
        TreeNode root = new TreeNode(rootValue);
        int rootInOrder = -1;//这个指针是在中序数组中寻找根的位置
        boolean isFind = false;

        //递归边界
        if(startPreOrder == endPreOrder){
            if(startInOrder == endInOrder && preArray[startPreOrder] == inArray[startInOrder]){
                return root;
            }else{
                System.out.println("请检查先序数组和中序数组是否有问题!");
                return null;
            }
        }

        for(int i = startInOrder; i <= endInOrder; i++) {
            if (inArray[i] == rootValue) {
                rootInOrder = i;
                isFind = true;
                break;
            }
        }
        if(!isFind){
            System.out.println("请检查先序数组和中序数组是否有问题!");
            return null;
        }
            int leftLength = rootInOrder - startInOrder;
            int rightLength = endInOrder - rootInOrder;
            if(leftLength > 0){
                root.setLeft(reconstructBinaryTree(startPreOrder+1, startPreOrder+leftLength,
                        startInOrder, rootInOrder-1));
            }
            if(rightLength > 0){
                root.setRight(reconstructBinaryTree(startPreOrder+leftLength+1, endPreOrder,
                        rootInOrder+1, endInOrder));
            }

        return root;
    }
}
