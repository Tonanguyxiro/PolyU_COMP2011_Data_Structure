package Lecture.lab2_sample;

import java.security.SecureRandom;
import java.util.Arrays;

public class Task {

	private static final int SIZE = 131072;
	
    public static void main(String[] args) {

        longTest(SIZE, SortingType.SELECTION);
        longTest(SIZE, SortingType.MINMAXSELECTION);
        longTest(SIZE, SortingType.INSERTION);
        longTest(SIZE, SortingType.INSERTION_IMPROVE);
        longTest(SIZE, SortingType.BUBBLEWITHOUTFLAG);
        longTest(SIZE, SortingType.BUBBLESORT);

    }

    public static void bubbleWithoutFlag(int[] a) {
        int n = a.length;
        int i, j, temp;
        for (i = 1; i < n; i++) { // We do n-1 iterations.
            for (j = 0; j < n - i; j++) // In each iteration, we go through the unsorted part.
                if (a[j+1] < a[j]) { // If two consecutive elements in wrong order, swap them.
                    temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
        }
    }
    
    public static void bubbleSort(int[] a) {
        int n = a.length;
        int i, j, temp;
        boolean flag = true; // assume the array is unsorted.
        
        // If flag is false, then no swap occurs in the previous iteration.
        // We can stop.
        for (i = 1; flag && (i < n); i++) { 
            flag = false;
            for (j = 0; j < n - i; j++)
                if (a[j+1] < a[j]) {
                    temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                    flag = true;
                }
        }
    }

    private static void selection(int[] a) {
        int length = a.length;
        int min;
        for (int i = 0; i < length - 1; i++) { // We do n-1 iterations.
            min = i;
            for (int j = i + 1; j < length; j++) { 
                if (a[j] < a[min]) {
                    min = j; // Find the smallest element in the unsorted part.
                }
            }
            swap(a, i, min); // swap it with the first element in the unsorted part.
        }
    }

    private static void minMaxSelection(int[] a) {
        int n = a.length;
        // In each iteration, put two elements into correct position.
        for (int i = 0, j = n - 1; i < j; i++, j--) { // Unsorted array is between i and j.
            int min = i, max = i;
            int maxValue = a[max];
            for (int k = i; k <= j; k++) { // find the smallest and largest elements in the unsorted part.
                if (a[k] > a[max]) {
                    maxValue = a[k];
                    max = k;
                }
                else if (a[k] < a[min])
                    min = k;
            }
            swap(a, i, min); // swap the smallest element with the first element in the unsorted part.
            if (a[min] == maxValue) // swap the largest element with the last element in the unsorted part.
                swap(a, j, min);
            else
                swap(a, j, max);
        }
    }
    
    private static void insertion(int[] a) {
        int length = a.length;
        // At beginning, the sorted part contains the first element.
        // The unsorted part begins at index 1.
        for (int i = 1; i < length; i++) {
            int j = i;
            // Put the first element in the unsorted part into correct position in the sorted part.
            // By doing swaps
            while (j > 0 && a[j-1] > a[j]) {
            	swap(a, j-1, j);
            	j--;
            }
        }
    }

    private static void insertionImprove(int[] a) {
        int length = a.length;
        // At beginning, the sorted part contains the first element.
        // The unsorted part begins at index 1.
        for (int i = 1; i < length; i++) {
            int key = a[i]; // take the first element in the unsorted part out.
            int j = i - 1;
            for (; j >= 0; j--) { // move elements in the sorted part and larger than key forwards.
                if (a[j] <= key) break;
                a[j + 1] = a[j];
            }
            a[j + 1] = key; // put the value of key into the correct position.
        }
    }

    public static void longTest(int size, SortingType sortingType) {
        System.out.println("input size is: " + size);

        int[] a = randomOrder(size);
//        printArray(a);
        duration(a, sortingType, InputType.RANDOM);
//        printArray(a);

        int[] b = increasingOrder(size);
//        printArray(b);
        duration(b, sortingType, InputType.INCREASING);
//        printArray(b);

        int[] c = decreasingOrder(size);
//        printArray(c);
        duration(c, sortingType, InputType.DECREASING);
//        printArray(c);

    }
    
    private static void duration(int[] a, SortingType sortingType, InputType inputType) {
        long startTime = 0;
        long endTime = 0;
        switch (sortingType) {
            case BUBBLESORT:
                startTime = System.currentTimeMillis();
                bubbleSort(a);
                endTime = System.currentTimeMillis();
                break;
            case BUBBLEWITHOUTFLAG:
                startTime = System.currentTimeMillis();
                bubbleWithoutFlag(a);
                endTime = System.currentTimeMillis();
                break;
            case SELECTION:
                startTime = System.currentTimeMillis();
                selection(a);
                endTime = System.currentTimeMillis();
                break;
            case MINMAXSELECTION:
                startTime = System.currentTimeMillis();
                minMaxSelection(a);
                endTime = System.currentTimeMillis();
                break;
            case INSERTION:
                startTime = System.currentTimeMillis();
                insertion(a);
                endTime = System.currentTimeMillis();
                break;
            case INSERTION_IMPROVE:
                startTime = System.currentTimeMillis();
                insertionImprove(a);
                endTime = System.currentTimeMillis();
                break;
        }
        long duration = (endTime - startTime);
        System.out.println("runs " + sortingType + " with " + inputType + " input takes " + (duration / 1000.) + " seconds.");
    }

    public static int[] randomOrder(int size) {
        int[] a = new int[size];
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < size; i++)
            a[i] = random.nextInt(size);
        return a;
    }

    public static int[] increasingOrder(int size) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = i;
        }
        return a;
    }

    public static int[] decreasingOrder(int size) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = size - 1 - i;
        }
        return a;
    }
    
    private static void swap(int[] a, int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void printArray(int[] a) {
        System.out.println(Arrays.toString(a));
    }


}
