package 剑指offer.剑指offer29_顺时针打印矩阵;

/**
 * @Description 优化代码, 简化过程
 * @Author douzhenjun
 * @DATE 2023-10-04
 **/
public class PrintMatrixInCircle2 {
    public static void PrintCycles(int m, int n, int[][] array) {
        if (m <= 0 || n <= 0) {
            return;
        }
//
        //循环变量,可以理解为每一层打印的起始位置(k,k)
        int k = 0;
        // 循环的终止条件是2k+1 > min(m, n)
        while (2 * k + 1 <= Math.min(m, n)) {
            PrintPerCycle(m, n, k, array);
            k++;
        }
        //如果是方针且是奇数,那么需要注意左闭右开的判断条件会遗漏最后中间的元素,所以单独打印
        if(m == n && m % 2 == 1){
            System.out.println(array[k-1][k-1]);
        }
    }

    public static void PrintPerCycle(int m, int n, int k, int[][] array) {
        System.out.println("第" + k + "层:");
        //打印遵循左闭右开的原则,避免重复和遗漏,需要注意当矩阵中只有一个元素的时候无法打印出来,这个情况单独列出
        for (int col = k; col < n - 1 - k; col++) {
            System.out.print(array[k][col] + ",");
        }
        for (int row = k; row < m - 1 - k; row++) {
            System.out.print(array[row][n - 1 - k] + ",");
        }
        for (int col = n - 1 - k; col > k; col--) {
            System.out.print(array[m - 1 - k][col] + ",");
        }
        for (int row = m - k - 1; row > k; row--) {
            System.out.print(array[row][k] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int m, n;
        int[][] array1 = {{1, 2, 3}, {5, 6, 7}, {9, 10, 11}};
        m = array1.length;
        n = array1[0].length;
        PrintCycles(m, n, array1); //成功

        System.out.println("----------------------------------------------");
        int[][] array2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        m = array2.length;
        n = array2[0].length;
        PrintCycles(m, n, array2); //成功

        System.out.println("----------------------------------------------");
        int[][] array3 = {{1, 2, 3, 4}, {5, 6, 7, 8}};
        m = array3.length;
        n = array3[0].length;
        PrintCycles(m, n, array3); //成功

        System.out.println("-----------------------------------------------");
        int[][] array4 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        m = array4.length;
        n = array4[0].length;
        PrintCycles(m, n, array4);//成功

        System.out.println("-----------------------------------------------");
        int[][] array5 = {{1, 2, 3}, {5, 6, 7}, {9, 10, 11}, {13, 14, 15}};
        m = array5.length;
        n = array5[0].length;
        PrintCycles(m, n, array5);//成功

        System.out.println("-----------------------------------------------");
        int[][] array6 = {{1}};
        m = array6.length;
        n = array6[0].length;
        PrintCycles(m, n, array6);//成功

        System.out.println("-----------------------------------------------");
        int[][] array7 = {{}};
        m = array7.length;
        n = array7[0].length;
        PrintCycles(m, n, array7);//成功

        System.out.println("-----------------------------------------------");
        int[][] array8 = {{1,2}};
        m = array8.length;
        n = array8[0].length;
        PrintCycles(m, n, array8);//成功

        System.out.println("-----------------------------------------------");
        int[][] array9 = {{1},{2}};
        m = array9.length;
        n = array9[0].length;
        PrintCycles(m, n, array9);//成功
    }
}
