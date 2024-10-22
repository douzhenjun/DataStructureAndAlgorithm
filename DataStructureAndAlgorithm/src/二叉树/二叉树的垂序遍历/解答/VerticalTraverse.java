package 二叉树.二叉树的垂序遍历.解答;



import 二叉树.二叉树节点类.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VerticalTraverse {
    
    public void traverseInPreOrder(TreeNode root){
        System.out.println(root.getData());
        if(root.getLeft()!=null){
            traverseInPreOrder(root.getLeft());
        }
        if(root.getRight()!=null){
            traverseInPreOrder(root.getRight());
        }
    }
    
    //将输入数组赋值给二叉树.
    public void transfer(Object[] list, TreeNode root, int index){
        if(index >= list.length){
            return;
        }
        if(list[index] != null){
            root = new TreeNode();
            root.setData((int)list[index]);
        }else{
            return;
        }
        transfer(list, root.getLeft(), 2 * index + 1);
        transfer(list, root.getRight(), 2 * index + 2);
    }
    
    //根据二叉树节点的位置,生成一个包含二叉树节点的横坐标,纵坐标和节点值的数组的数组, 采用dfs
    public void getSeatList(TreeNode root, int i, int j, List<int[]> sList){
        if(root == null){
            return;
        }
        int[] element = {i, j, root.getData()};
        sList.add(element);
        getSeatList(root.getLeft(), i+1, j-1, sList);
        getSeatList(root.getRight(), i+1, j+1, sList);
    }
    
    //将二叉树按照先纵后横再值的自然顺序排列, 并输出列表, 每一个纵列是一个列表元素
    public List<List<Integer>> getTraversalList(Object[] list){
        //1.将数组转换成二叉树, 并且利用dfs得到每个二叉树节点对应的一个位置数组
        TreeNode root = new TreeNode();
        transfer(list, root, 0);
        traverseInPreOrder(root);
        List<int[]> sList = new ArrayList<>();
        getSeatList(root, 0, 0, sList);
        
        //2.将这个数组按照从左到右,从上到下,值大小的顺序排序
        Collections.sort(sList, (arr1, arr2) -> {
            if(arr1[1] != arr2[1]){
                return arr1[1]-arr2[1];
            }
            if(arr1[0] != arr2[0]){
                return arr1[0]-arr2[0];
            }
            return arr1[2]-arr2[2];
        });
        
        //3.定义返回的数组对象,初始化
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        results.add(res);
        if(sList.size() <= 0){
            return null;
        }
        res.add(sList.get(0)[2]);
        //4.遍历sList中的元素,比较相邻元素的第二个元素是否相等, 如果相等, 那么就在已有的数组中添加元素. 否则新建一个空数组, 将元素添加到新数组中.
        for(int i = 1; i < sList.size(); i++){
            if(sList.get(i)[1] == sList.get(i-1)[1]){
                res.add(sList.get(i)[2]);
            }else{
                res = new ArrayList<>();
                res.add(sList.get(i)[2]);
                results.add(res);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        VerticalTraverse vt = new VerticalTraverse();
        Object[] root1 = {3, 9, 20, null, null, 15, 7};
        List<List<Integer>> results = vt.getTraversalList(root1);
//        System.out.println(Arrays.toString(results.toArray()));
//        System.out.println("------------------------------------");
//        
//        Object[] root2 = {1, 2, 3, 4, 5, 6, 7};
//        List<List<Integer>> results2 = vt.getTraversalList(root2);
//        System.out.println(Arrays.toString(results2.toArray()));
//        System.out.println("------------------------------------");
//
//        Object[] root3 = {1, 2, 3, 4, 6, 5, 7};
//        List<List<Integer>> results3 = vt.getTraversalList(root3);
//        System.out.println(Arrays.toString(results3.toArray()));
//        System.out.println("------------------------------------");
    }
}
