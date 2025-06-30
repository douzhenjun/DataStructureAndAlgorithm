package 剑指offer.剑指offer16_数值的整数次方;

public class Method2 {
    public static double PowerWithUnsignedExponent(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        double result = PowerWithUnsignedExponent(base, exponent >> 1);
        result *= result;
        if (exponent % 2 == 1) {
            result *= base;
        }

        return result;
    }

    public static double Power(double base, int exponent) {
        if (base == 0 && exponent < 0) {
            System.out.println("InvalidInput!");
            return -1;
        }
        if (exponent >= 0) {
            return PowerWithUnsignedExponent(base, exponent);
        } else {
            exponent = Math.abs(exponent);
            double result = PowerWithUnsignedExponent(base, exponent);
            return (1.0 / result);
        }
    }
}