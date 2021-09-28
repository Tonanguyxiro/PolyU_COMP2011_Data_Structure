package Lecture.lec5_sample;

/**
 * 
 * @author Yixin Cao (October 1, 2020)
 *
 * A simple solver of the towers of Hanoi, by recursion.
 * It's a very challenging task to solve the problem without recursion. 
 * 
 */
public class HanoiTowers {
    static String[] rods = {"Left", "Center", "Right"}; // You can change the labels to first, second, third, or 1, 2, 3, or red, yellow, blue.

    /*
    * The running time is exponential.
    */
    public static void move(int n, int from, int to) {
        if(n <= 1) {
            System.out.println("disk 1: " + rods[from] + " -> " + rods[to]);
            return;
        }
        int via = 3 - from - to;  // a small trick to avoid the use of several if statements. 
        move(n - 1, from, via);
        System.out.println("disk " + n + ": " + rods[from] + " -> " + rods[to]);
        move(n - 1, via, to);
    }

    // To use a recursive method, we frequently need a kickstarter.
    public static void move(int n) {
        move(n, 0, 2);
    }
    
    public static void main(String[] args) {
        move(4); // Can you calculate the number of steps for different n?
    }
}
