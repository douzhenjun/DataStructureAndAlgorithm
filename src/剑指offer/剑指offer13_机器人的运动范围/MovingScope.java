package 剑指offer.剑指offer13_机器人的运动范围;

public class MovingScope {
    public int movingCount(int threshold, int rows, int cols){

        if(threshold < 0 || rows <= 0 || cols <= 0)
            return 0;
        boolean [][] visited = new boolean[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                visited[i][j] = false;
            }
        }

        int count = movingCountCore(threshold, rows, cols, 0, 0, visited);

        return count;
    }

    private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
        int count = 0;
        if(check(threshold, rows, cols, row, col, visited)){
            visited[row][col] = true;

            count = 1 + movingCountCore(threshold, rows, cols, row-1, col, visited)
                        + movingCountCore(threshold, rows, cols, row, col-1, visited)
                        + movingCountCore(threshold, rows, cols, row+1, col, visited)
                        + movingCountCore(threshold, rows, cols, row, col+1, visited);
        }
        return count;
    }

    public boolean check(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
        if(row >= 0 && row < rows && col >= 0 && col < cols
            && getDigitSum(row) + getDigitSum(col) <= threshold
            && !visited[row][col]){
            return true;
        }
        return false;
    }

    public int getDigitSum(int number){
        int sum = 0;
        while(number > 0){
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }


    public static void main(String[] args) {

        MovingScope ms = new MovingScope();
        int movingCount = ms.movingCount(18, 20, 30);

        System.out.println(movingCount);

        int movingCount2 = ms.movingCount(-1, 20, 30);
        System.out.println(movingCount2);

        int movingCount3 = ms.movingCount(20, 3, 5);
        System.out.println(movingCount3);
    }
}
