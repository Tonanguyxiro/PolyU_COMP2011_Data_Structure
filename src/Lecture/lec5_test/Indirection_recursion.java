package Lecture.lec5_test;

public class Indirection_recursion {
    public static int odd(int n) {
        if (n <= 1) { System.out.print("1\n"); return 1;}
        System.out.print(n + " -> ");
        return even(n * 3 + 1);
    }

    public static int even(int n) {
        System.out.print(n + " -> ");
        while (n % 2 == 0) n /= 2;
        return odd(n);
    }

    public static void main(String[] args) {
        odd(7);
    }

}
