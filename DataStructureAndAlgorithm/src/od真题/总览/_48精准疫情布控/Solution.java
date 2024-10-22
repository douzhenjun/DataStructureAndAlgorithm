package od真题.总览._48精准疫情布控;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-26
 **/
public class Solution {
    
    // 查找人的根节点
    static int findRoot(int person, int[] parents) {
        if (parents[person] != person) { // 如果人的父节点不是自己，递归查找根节点
            parents[person] = findRoot(parents[person], parents);
        }
        return parents[person];
    }

    // 合并两个人所在的组
    static void merge(int person1, int person2, int[] parents) {
        int root1 = findRoot(person1, parents); // 查找person1的根节点
        int root2 = findRoot(person2, parents); // 查找person2的根节点
        if (root1 != root2) { // 如果两个人所在的组不同，合并它们
            parents[root1] = root2; // 将person1所在组的根节点设为person2所在组的根节点
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = scanner.nextInt(); // 输入人员数量
        scanner.nextLine();
        int[] parents = new int[numberOfPeople]; // 每个人的父节点
        int[] testResults = new int[numberOfPeople]; // 测试结果

        for (int i = 0; i < numberOfPeople; i++) {
            parents[i] = i; // 初始化每个人的父节点为自己
        }

        String[] infectedPeople = scanner.next().split(","); // 输入感染者的编号
        int[] infectedIDs = new int[infectedPeople.length]; // 存储感染者的编号

        if (infectedPeople.length == 0) {
            System.out.println(0); // 如果没有感染者，直接输出0
            return;
        }

        for (int i = 0; i < infectedPeople.length; i++) {
            infectedIDs[i] = Integer.parseInt(infectedPeople[i]); // 解析感染者的编号
            if (i != 0) {
                merge(infectedIDs[i], infectedIDs[i - 1], parents); // 将感染者的编号合并到同一个组中
            }
        }

        for (int i = 0; i < numberOfPeople; i++) {
            String[] contactHistory = scanner.next().split(","); // 输入每个人的接触情况
            for (int j = 0; j < numberOfPeople; j++) {
                if (contactHistory[j].charAt(0) == '1') { // 如果第j个人和第i个人接触过，将它们合并到同一个组中
                    merge(i, j, parents);
                }
            }
        }

        for (int i = 0; i < numberOfPeople; i++) {
            if (findRoot(i, parents) == findRoot(infectedIDs[0], parents)) { // 如果第i个人和感染者在同一个组中，标记为需要做核酸检测
                testResults[i] = 1;
            }
        }

        for (int id : infectedIDs) {
            testResults[id] = 0; // 感染者不需要进行核酸检测，标记为0
        }

        int peopleForTesting = 0; // 统计需要做核酸检测的人数
        for (int i = 0; i < numberOfPeople; i++) {
            peopleForTesting += testResults[i];
        }

        System.out.println(peopleForTesting); // 输出结果
    }
}
