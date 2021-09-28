package Lecture.lec5_sample;

/*
 * @author Yixin Cao (October 6, 2020)
 *
 * An example of indirect recursion.  
 * Two methods <em>odd</em> and <em>even</em> call each other.
 *   
 * can you guess what they do?
 */
public class Collatz {
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
         for (int i = 10; i < 40; i++) {
             even (i * 2);
             System.out.println();
         }
         
         even (10000000);
         odd (11111111);
     }   
}
