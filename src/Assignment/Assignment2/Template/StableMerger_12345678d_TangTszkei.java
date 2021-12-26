package Assignment.Assignment2.Template;
import java.util.Arrays;

/**
 * 
 * @author Yixin Cao (October 22, 2021)
 *
 * Merging k sorted arrays into a single sorted array.
 * Your algorithm must be stable.
 * 
 * You are NOT allowed to call the constructor of class Student, except in <em>main</em>.
 */
public class StableMerger_12345678d_TangTszkei {
    /**
     * 
     * No modification to class Node is allowed.
     * If you change anything here, your work will not be graded.
     *
     */
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
    
    /**
     * VERY IMPORTANT.
     * 
     * I've discussed this question with the following students:
     *     1. 
     *     2. 
     *     3. 
     *     ... 
     * 
     * I've sought help from the following Internet resources and books:
     *     1. 
     *     2. 
     *     3. 
     *     ... 
     * 
     * Running time: O(   ). (n is the total number of students.)   
     */ 
    public static Student[] merge(Student[][] a) {
        return null;
    }
    
    public static void main(String[] args) {
        String[][] names = {{"Gloria Tang", "Andy Lau", "McDull"}, 
                {"Eason Chan", "Denise Ho", "Jennifer Chan", "Joey Yung", "Kay Tse", "Jacky Cheung", "Anita Mui"},
                {"Winnie", "Mickey", "Teddy", "Peppa"}};
        double[][] grades = {{60, 60, 60}, {40, 60, 70, 80, 90, 95, 100}, {0, 90, 95, 100}};
        Student[][] a = new Student[names.length][];
        for (int i = 0; i < names.length; i++) {
            a[i] = new Student[names[i].length];
            for (int j = 0; j < names[i].length; j++)  
                a[i][j]= new Student(names[i][j], grades[i][j]);
        }
        System.out.println(Arrays.toString(merge(a)));
    }
}
