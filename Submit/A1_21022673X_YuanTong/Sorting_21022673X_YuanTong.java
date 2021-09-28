package Assignment.Assignment1;
// Remember to move to finally

import java.util.Arrays;

/**
 *
 * @author Tong Yuan (September 27, 2021)
 *
 * A better implementation of insertion sort.
 *
 * The ith major iteration of insertion sort puts element a[i] to its correct position.
 * Your algorithm should use **binary search** to find the position of the first element
 * that is greater than (> not >=) a[i], or i if there does exist such an element.
 *
 * Read the {@code Element} class carefully before you start.
 * It uses an extra field *originalPos* to store the index of this element in the input.
 * When an element is output, originalPos is printed in parentheses.
 *
 * If your implementation is correct, elements of the same value should respect their original order,
 * e.g., for input {1.25, 0, 1.25, 2.5, 10, 2.5, 1.25, 5, 2.5}, the output should be
 * [0.0 (1), 1.25 (0), 1.25 (2), 1.25 (6), 2.5 (3), 2.5 (5), 2.5 (8), 5.0 (7), 10.0 (4)].
 */

public class Sorting_21022673X_YuanTong {
    /*
     * Each element has a double value and the original position in the input array.
     */
    static class Element {
        private int originalPos;
        double value;
        public Element(int i, double v) {
            originalPos = i;
            value = v;
        }
        public String toString() {
            return (String.valueOf(value)) + " (" + String.valueOf(originalPos) + ")";
        }
    }

    /**
     * VERY IMPORTANT.
     *
     * [I have not discussed with anyone about this question]
     *
     * I've sought help from the following Internet resources and books:
     *     1. JAVA Official Documentation
     *
     * Running time: O(nlog(n)) in total.
     */
    public static void insertionSort(Element[] a) {
        if(a.length == 0){
            System.out.println("Oops! No element in a!");
        }
        else {
            int start, end, mid = 0;
            int n = a.length;
            Element key;
            for (int i = 1; i < n; i++){
                start = 0; end = i - 1; // Search region
                mid = (int) Math.ceil(0.5*(start+end));
                key = a[i];
                if (key.value >= a[end].value){
//                    System.out.println("Interaction " + i + Arrays.toString(a));
                    continue;
                }
                else if(key.value < a[start].value){
                    for (int j = i; j > 0; j--) {
                        a[j] = a[j-1];
                    }
                    a[0] = key;
//                    System.out.println("Interaction " + i + Arrays.toString(a));
                    continue;
                }
                else {
                    while (!(mid == end)){ // insert
                        if (key.value < a[mid].value){
                            end = mid;
                        }
                        else {
                            start = mid;
                        }
                        mid = (int) Math.ceil(0.5*(start+end));
                    }

                    for (int j = i; j > mid; j--) {
                        a[j] = a[j-1];
                    }
                    a[mid] = key;
                }
//                System.out.println("Interaction " + i + Arrays.toString(a));
            }
        }

    }

    // The original insertion sort is copied for your reference.
    public static void insertionSort(int[] a) {
        int i, j, key, n = a.length;
        for (i = 1; i < n; i++) {
            key = a[i];
            for (j = i - 1; j >= 0; j--) {
                if (a[j] <= key) break;
                a[j + 1] = a[j];
            }
            a[j + 1] = key;
        }
    }

    // The binary search algorithm is copied for your reference.
    public static int binarySearch(int[] a, int key) {
        int n = a.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == key) return mid;
            else if (a[mid] > key) high = mid - 1;
            else if (a[mid] < key) low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        double input[] = {1, 0, 1.25, 0, 1.25, 2.5, 10, 0, 2.5, 1.25, 0, 5, 2.5}; // try different inputs.
        int n = input.length;
        Sorting_21022673X_YuanTong.Element[] a = new Sorting_21022673X_YuanTong.Element[n];
        for (int i = 0; i < input.length; i++)
            a[i] = new Sorting_21022673X_YuanTong.Element(i, input[i]);

        System.out.println("Original: " + Arrays.toString(a));
        insertionSort(a);
        System.out.println("After sorted: " + Arrays.toString(a));
//        System.out.println("Expected    : [0.0 (1), 1.25 (0), 1.25 (2), 1.25 (6), 2.5 (3), 2.5 (5), 2.5 (8), 5.0 (7), 10.0 (4)]");
        // Expected
        // [0.0 (1), 1.25 (0), 1.25 (2), 1.25 (6), 2.5 (3), 2.5 (5), 2.5 (8), 5.0 (7), 10.0 (4)]
    }
}

