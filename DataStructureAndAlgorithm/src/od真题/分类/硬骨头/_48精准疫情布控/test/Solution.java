package od真题.分类.硬骨头._48精准疫情布控.test;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-30
 **/
public class Solution {
    static int findRoot(int root, int[] parents){
        if(parents[root] != root){
            parents[root] = findRoot(parents[root], parents);
        }
        return parents[root];
    }
    
    static void merge(int person1, int person2, int[] parents){
        int root1 = findRoot(person1, parents);
        int root2 = findRoot(person2, parents);
        if(root1 != root2){
            parents[root1] = root2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = scanner.nextInt();
        int[] parents = new int[numberOfPeople];
        
        for(int i = 0; i < numberOfPeople; i++){
            parents[i] = i;
        }
        String[] infectedPeople = scanner.nextLine().split(",");
        int[] infectedIDs = new int[infectedPeople.length];
        int m = infectedIDs.length;
        for(int i = 0; i < m; i++){
            infectedIDs[i] = Integer.parseInt(infectedPeople[i]);
            if(i != 0){
                merge(infectedIDs[i], infectedIDs[i-1], parents);
            }
        }
        for(int i = 0; i < numberOfPeople; i++){
            String[] contactHistory = scanner.nextLine().split(",");
            for(int j = 0; j < numberOfPeople; j++){
                if(contactHistory[j].charAt(0) == '1'){
                    merge(i, j, parents);
                }
            }
        }
        int[] peopleForTest = new int[numberOfPeople];
        for(int i = 0; i < numberOfPeople; i++){
            if(findRoot(i, parents) == findRoot(infectedIDs[0], parents)){
                peopleForTest[i] = 1;
            }
        }
        for(int id : infectedIDs){
            peopleForTest[id] = 0;
        }
        
        int ans = 0;
        for(int i = 0; i < numberOfPeople; i++){
            ans += peopleForTest[i];
        }
        System.out.println(ans);
    }
}
