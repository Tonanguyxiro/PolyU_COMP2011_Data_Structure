package Assignment.Assignment2.Submission;
import java.util.Arrays;

/**
 * 
 * @author Yuan Tong (November 12, 2021)
 *
 * Merging k sorted arrays into a single sorted array.
 * Your algorithm must be stable.
 * 
 * You are NOT allowed to call the constructor of class Student, except in <em>main</em>.
 */
public class StableMerger_21022673x_YuanTong {
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
     * Running time: O(N*M). (n is the total number of students, M is the total number of lists.)
     */ 
    public static Student[] merge(Student[][] a) {
        int[] pointers = new int[a.length];
        for (int i = 0; i < pointers.length; i++) pointers[i] = 0;

        int numberOfStudents = numberOfStudents(a);
        Student[] result = new Student[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            double min = 0; int index = 0;
            for (int j = 0; j < pointers.length; j++) {
                if (pointers[j] < a[j].length) {
                    min = a[j][pointers[j]].grade;
                    index = j;
                    break;
                }
            }

            for (int j = 0; j < pointers.length; j++) {
                if (pointers[j] < a[j].length) {
                    if (a[j][pointers[j]].grade < min) {
                        min = a[j][pointers[j]].grade;
                        index = j;
                    }
                }
            }
            result[i] = a[index][pointers[index]];
            pointers[index]++;
        }

        return result;
    }

    private static int numberOfStudents(Student[][] a) {
        int total = 0;
        for (int i = 0; i < a.length; i++) {
            total += a[i].length;
        }
        return total;
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
        System.out.println("Expected:  (Winnie, 0), (Eason Chan, 40), (Gloria Tang, 60), (Andy Lau, 60), (McDull, 60), (Denise Ho, 60), (Jennifer Chan, 70), (Joey Yung, 80), (Kay Tse, 90), (Mickey, 90), (Jacky Cheung, 95), (Teddy, 95), (Anita Mui, 100), (Peppa, 100)");
        System.out.println("Actually: "+Arrays.toString(merge(a)));
    }
}
