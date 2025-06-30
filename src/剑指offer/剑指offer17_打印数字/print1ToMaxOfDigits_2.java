package 剑指offer.剑指offer17_打印数字;

public class print1ToMaxOfDigits_2 {
    public static void main(String[] args) {
        print1TOMaxOfNDigits(4);
    }

    public static void print1TOMaxOfNDigits(int n){
        char[] number = new char[n];
        print1ToMaxOfDigitsRecursively(number, n, 0);
    }
    public static void print1ToMaxOfDigitsRecursively(char[] number, int n, int index){
        if(index == n){
            printNumber(number);
            return;
        }
        for(int i = 0; i < 10; i++){
            number[index] = (char)('0'+i);
            print1ToMaxOfDigitsRecursively(number, n, index+1);
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
