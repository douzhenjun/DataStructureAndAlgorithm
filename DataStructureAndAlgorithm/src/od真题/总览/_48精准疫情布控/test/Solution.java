package od真题.总览._48精准疫情布控.test;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-01
 **/
public class Solution {

    static int findRoot(int person, int[] parents) {
        if (person != parents[person]) {
            parents[person] = findRoot(parents[person], parents);
        }
        return parents[person];
    }

    static void merge(int person1, int person2, int[] parents) {
        int root1 = findRoot(person1, parents);
        int root2 = findRoot(person2, parents);
        if (root1 != root2) {
            parents[root1] = root2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] parents = new int[num];
        for (int i = 0; i < num; i++) {
            parents[i] = i;
        }
        String[] infectPeople = scanner.next().split(",");
        int[] infectIDs = new int[infectPeople.length];
        int num2 = infectIDs.length;
        for (int i = 0; i < num2; i++) {
            infectIDs[i] = Integer.parseInt(infectPeople[i]);
            if (i != 0) {
                merge(infectIDs[i], infectIDs[i - 1], parents);
            }
        }
        for (int row = 0; row < num; row++) {
            String[] contactHistory = scanner.next().split(",");
            for (int col = 0; col < num; col++) {
                if (contactHistory[col].equals("1")) {
                    merge(row, col, parents);
                }
            }
        }

        int[] forTest = new int[num];
        for (int i = 0; i < num; i++) {
            if (findRoot(i, parents) == findRoot(infectIDs[0], parents)) {
                forTest[i] = 1;
            }
        }
        for(int j : infectIDs){
            forTest[j] = 0;
        }
        int res = 0;
        for (int i = 0; i < num; i++) {
            if (forTest[i] != 0) {
                res++;
            }
        }
        System.out.println(res);
    }
}
