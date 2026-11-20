package Week9;

public class PowerOfNumber {

    static double power(double base, int exp) {
        if (exp == 0) {
            return 1;
        }

        if (exp < 0) {
            return 1 / power(base, -exp);
        }

        double half = power(base, exp / 2);

        if (exp % 2 == 0) {
            return half * half;
        } else {
            return half * half * base;
        }
    }

    public static void main(String[] args) {
        double base = 2;
        int exp = 10;
        System.out.println(base + "^" + exp + " = " + power(base, exp));
    }
}
