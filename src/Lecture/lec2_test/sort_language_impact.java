package Lecture.lec2_test;

import java.security.SecureRandom;

public class sort_language_impact {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        long startTime = 0;
        double duration = 0;
        int N = 1<<14; // 32768
        System.out.println("N = " + N);

        SecureRandom random = new SecureRandom();
        int a[][] = new int[N][N];
        int max = 0;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                a[i][j] = random.nextInt();

        startTime = System.currentTimeMillis();
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                max = max>a[i][j]?max:a[i][j];
        System.out.println("max = " + max);
        duration = (System.currentTimeMillis() - startTime) / 1000.;
        System.out.println("it takes " + duration + " seconds to scan the matrix by rows.");

        startTime = System.currentTimeMillis();
        max = 0;
        for (int j = 0; j < N; j++)
            for (int i = 0; i < N; i++)
                max = max>a[i][j]?max:a[i][j];
        System.out.println("max = " + max);
        duration = (System.currentTimeMillis() - startTime) / 1000.;
        System.out.println("it takes " + duration + " seconds to scan the matrix by columns.");
    }
}


