package 剑指offer.剑指offer16_数值的整数次方;


public class Method01 {
    public static double Power(double base, int exponent){
        double result = 1.0;
        if(base == 0 && exponent < 0){
            System.out.println("InvalidInput!");
            return -1;
        }
        if(exponent > 0){
            for(int i = 1; i <= exponent; i++){
                result *= base;
            }
            return result;
        }
        else if(exponent == 0){
            return result;
        }
        else{
            exponent = Math.abs(exponent);
            for(int i = 1; i <= exponent; i++){
                result *= base;
            }
            return (1.0/result);
        }
    }
}
