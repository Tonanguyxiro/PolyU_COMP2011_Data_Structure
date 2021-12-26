package Lecture.lab9_sample;

import java.util.Arrays;

/**
 * 
 * @author Yixin Cao (October 20, 2021)
 *
 * Merging k sorted arrays into a single sorted array.
 * 
 * Two different approaches. 
 * Both need to be stale, and run in O(n log k) time.
 * 
 */
public class StableMerger {
    static class Student {
        String name;
        double grade;
        public Student(String n, double g) {
            name = n; grade = g;
        }
        public String toString() {
            return "(" + name + ", " + grade + ")";
        }
    }

    public static Student[] merge2(Student[][] a) {
        return null;
    }
    
    /*
     * The same as used in mergesort (comp2011.lec6).
     */
    private static Student[] twoWayMerge(Student[] a1, Student[] a2) {
        int i = 0, j = 0, k = 0;
        int n1 = a1.length, n2 = a2.length;
        Student[] res = new Student[n1 + n2]; 
        while (i < n1 && j < n2) 
            res[k++] = (a1[i].grade <= a2[j].grade)?a1[i++]:a2[j++];
        for (; i < n1; ) res[k++] = a1[i++];
        for (; j < n2; ) res[k++] = a2[j++];
        return res;
    }    

    /*
     * The running time is O( ).
     */
    private static Student[] kWayMerge(Student[][] a, int begin, int end) {
        if (begin >= end) return a[begin];
        // split evenly into two parts
        int l = begin, h = end;
        int m = l + (h - l) / 2;
        Student[] h1 = kWayMerge(a, l, m);
        Student[] h2 = kWayMerge(a, m + 1, h);
        return twoWayMerge(h1, h2);
    }
    
    //  kickstarter, real work in merge
    public static Student[] merge1(Student[][] a) {
        return kWayMerge(a, 0, a.length - 1);
    }
    
    public static void main(String[] args) {
        String[][] names = {{"Mickey", "Teddy", "McDull"}, 
                {"Kay Tse", "Denise Ho", "Joey Yung", "Gloria Tang"},
                {"Eason Chan", "Andy Lau", "Cheung Jacky"}};
        double[][] grades = {{90, 90, 100}, {80, 90, 95, 100}, {40, 60, 90}};
        Student[][] a = new Student[names.length][];
        for (int i = 0; i < names.length; i++) {
            a[i] = new Student[names[i].length];
            for (int j = 0; j < names[i].length; j++) 
                a[i][j]= new Student(names[i][j], grades[i][j]);
        }
        System.out.println(Arrays.toString(merge1(a)));
        System.out.println(Arrays.toString(merge2(a)));
    }
}
