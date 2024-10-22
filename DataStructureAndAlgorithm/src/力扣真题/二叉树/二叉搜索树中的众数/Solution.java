package 力扣真题.二叉树.二叉搜索树中的众数;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

import java.util.*;

/**
 * @Description 一般方法,采用任意一种遍历方式,并且使用Map保存遍历到的数据,并且做一个倒序排序即可
 * @Author douzhenjun
 * @DATE 2024-02-21
 **/
public class Solution {
    public int[] findMode(TreeNode root){
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();
        traverse(root, map);
        //将键值对信息封装到一个EntrySet对象中
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        //对对象的value值倒序排序
        Collections.sort(entryList, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        Integer maxValue = entryList.get(0).getValue();
        for (Map.Entry<Integer, Integer> entry : entryList) {
            if(entry.getValue() < maxValue){
                break;
            }
            resultList.add(entry.getKey());
        }
        return resultList.stream().mapToInt(i -> i).toArray();
    }
    
    private void traverse(TreeNode root, Map<Integer, Integer> map){
        if(root == null){
            return;
        }
        traverse(root.left, map);
        map.put(root.val, map.getOrDefault(root.val, 0)+1);
        traverse(root.right, map);
    }
}
