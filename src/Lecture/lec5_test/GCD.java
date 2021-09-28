package Lecture.lec5_test;

public class GCD {
    public static int GCD(int a, int b) {
        if (a*b == 0) return a+b;
        for (int i = 2; i < Math.min(a, b); i++) {
            if ((a%i == 0)&&(b%i == 0)){
                return i * GCD(a/i, b/i);
            }
        }
        return 1;
    }

    public static int recursiveGCD(int a, int b) {
        if (a * b == 0) return a + b;
        int c = Math.min(a, b);
        if ((a + b) % c == 0) return c;
        return recursiveGCD((a + b) % c, c);
    }

    public static void main(String[] args) {
        System.out.println(GCD(2021, 2537));
        System.out.println(recursiveGCD(2021, 2537));
    }
}
