package 剑指offer.剑指offer17_打印数字;

public class Print1ToMaxOfNDigits {
    public static void main(String[] args) {
        print1ToMaxOfNDigits(4);
    }
    public static void print1ToMaxOfNDigits(int n){
        if(n <= 0){
            return;
        }
        char[] number = new char[n];
        for(int i=0; i < 10; i++){
            number[0] = (char) (i + '0');
            print1ToMaxOfNDigitsRecursiverly(number, n, 0);
        }
    }

    private static void print1ToMaxOfNDigitsRecursiverly(char[] number, int length, int index) {
        if(index == length - 1){
            printNumber(number);
            return;
        }
        for(int i = 0; i < 10; i++){
            number[index+1] = (char)(i + '0');
            print1ToMaxOfNDigitsRecursiverly(number, length, index+1);
        }
    }

    private static void printNumber(char[] number) {
        boolean isBeginning0 = true;
        int nLength = number.length;
        for(int i = 0; i < nLength; i++){
            if(isBeginning0 && number[i] != '0'){
                isBeginning0 = false;
            }
            if(!isBeginning0){
                System.out.format("%c", number[i]);
            }
        }
        System.out.println("\t");
    }
}
