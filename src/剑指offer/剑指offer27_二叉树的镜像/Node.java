package 剑指offer.剑指offer27_二叉树的镜像;

public class Node {
    private int data;
    private Node lchild;
    private Node rchild;

    public Node(int data, Node lchild, Node rchild) {
        this.data = data;
        this.lchild = lchild;
        this.rchild = rchild;
    }

    public Node() {
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLchild() {
        return lchild;
    }

    public void setLchild(Node lchild) {
        this.lchild = lchild;
    }

    public Node getRchild() {
        return rchild;
    }

    public void setRchild(Node rchild) {
        this.rchild = rchild;
    }

    //根据列表构造一个完全二叉树
    public void construct(Node root, int index, int[] arr) {
        if (index >= arr.length || index < 0) {
            root = null;
            return;
        }
        root.setData(arr[index]);
        if (2 * index + 1 < arr.length) {
            root.setLchild(new Node());
            construct(root.getLchild(), 2 * index + 1, arr);
        }
        if (2 * index + 2 < arr.length) {
            root.setRchild(new Node());
            construct(root.getRchild(), 2 * index + 2, arr);
        }
    }

    public void construct2(Node root, int index, int[] arr) {
        if (index >= arr.length || index < 0) {
            root = null;
            return;
        }
        root.setData(arr[index]);
        root.setLchild(new Node());
        construct2(root.getLchild(), 2 * index + 1, arr);
        root.setRchild(new Node());
        construct2(root.getRchild(), 2 * index + 2, arr);
    }

    //先序遍历二叉树
    public static void traverseInPreOrder(Node root) {
        if (root != null) {
            System.out.println(root.getData());
            traverseInPreOrder(root.getLchild());
            traverseInPreOrder(root.getRchild());
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 6, 10, 5, 7, 9, 11};
        Node root = new Node();
        root.construct(root, 0, arr);
        traverseInPreOrder(root);

        System.out.println("-------------------------------");

        root.construct2(root, 0, arr);
        traverseInPreOrder(root);

    }
}