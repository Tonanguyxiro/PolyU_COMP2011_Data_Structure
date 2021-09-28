package Lecture.lec5_sample;
import java.util.Arrays;

/**
 * 
 * @author Yixin Cao (October 6, 2020)
 *
 * Examples for divide and conquer.
 * All of them are related to the task of finding the maximum element of an array. 
 * 
 * Please try to implement all the methods.
 */
public class DivideAndConquer {
    // the iterative version of finding *a* peak.
    public static int peak(int[] a) {
        return -1;
    }

    // wrapper for the recursivePeak.
    public static int recursivePeak(int[] a) {
        return recursivePeak(a, 0, a.length - 1);
    }
    public static int recursivePeak(int[] a, int l, int h) {
        if(l > h) return -1;
        if(l == h) return l; // L, not 1.

        int m = l + (h - l + 1) / 2; // the same as m = (l + h + 1) / 2, but safer.
        if (a[m] < a[m-1]) return recursivePeak(a, l, m - 1);
        else return recursivePeak(a, m, h);
        /*        
         * The following use two comparisons to eliminate a[m] as well.
        int m = l + (h - l) / 2; // l + (h - l + 1) / 2 also works.
        if (m > 0 && a[m] < a[m-1]) return recursivePeak(a, l, m - 1);
        else if (m < a.length-1 && a[m] < a[m+1]) return recursivePeak(a, m + 1, h);
        else return m;
        */
    }
    
    /*
     * Finding the index of a maximum element by divide and conquer.
     * The recursive version. 
     */
    public static int recursiveMax(int[] a) {
        return max(a, 0, a.length-1);
    }
    public static int max(int[] a, int low, int high) {
        if (low >= high) return a[low];
        int mid = low + (high - low) / 2;
        int m1 = max(a, low, mid); // ceiling of n/2
        int m2 = max(a, mid+1, high); // floor of n/2
        return (m1 > m2)? m1:m2; 
    }
    
    /**
     * Finding the index of a maximum element by divide and conquer.
     * The iterative version. 
     * 
     * The key point is the reuse of memory.
     * Once we have find the larger of the first pair, b[1] is useless.
     * 
     * Running time: O( n ). n/2 + n/4 + n/8 + ... + 1 = O(n).
     */
    public static int max(int[] a) {
        int n = a.length;
        int[] b = new int[n];
        for (int i = 0; i < n; i++) b[i] = a[i];
        while (n > 1) {
            for (int j = 0; j < n/2; j ++) 
                b[j] = (b[j*2] > b[j*2+1])? b[j*2]:b[j*2+1]; 
            // Note: n might be odd; e.g., 11/2*2 = 10.
            if (n != n/2*2) b[n/2] = b[n-1];
            n = (n+1)/2; // this is the ceiling of n / 2.  Alternatively, you can write n = (n == n/2*2)?(n/2):((n+1)/2);
            // System.out.println(Arrays.toString(b));
        }
        return b[0];
    }
    
    /**
     * Finding the index of a maximum element in the naive way.
     * Return an array ans of length two, where 
     * ans[0] and ans[1] are indices of a max and min elements, respectively.
     * 
     * The key point is the reuse of memory.
     * Once we have find the larger of the first pair, b[1] is useless.
     * 
     */
    public static int[] naiveMaxmin(int[] a) {
        if (a.length == 0) return null;
        int[] ans = new int[2];
        if (a.length == 1) {ans[0] = ans[1] = 0; return ans;}
        if (a[0] > a[1]) {ans[0] = 0; ans[1]= 1;}
        else {ans[0]= 1; ans[1] = 0;}
        /*
         * the last two lines can be replaced by
         *     ans[0] = (a[0] > a[1])? 0:1; 
         *     ans[1] = 1 - ans[0]; 
         */
        for (int i = 2; i < a.length; i++) {
            if (a[i] > a[ans[0]]) ans[0] = i; 
            else if (a[i] < a[ans[1]]) ans[1] = i;            
        }
        return ans;
    }
    
    /**
     * Finding the index of a maximum element by divide and conquer.
     * The recursive version. 
     * 
     * The key point is the reuse of memory.
     * Once we have find the larger of the first pair, b[1] is useless.
     * 
     * Running time: O( n ). 
     */
    public static int[] maxmin(int[] a, int low, int high) {
        if (low > high) return null;  // wrong input
        int ans[] = new int[2];
        if (high == low) {  // base case one
        	ans[0] = ans[1] = high; 
        	return ans;
        }
        // Now an range of two is a base case.
        if (high == low + 1) { // base case two
            ans[0] = (a[low] > a[high])? low:high; 
            ans[1] = low - ans[0] + high;
            return ans;
        }
        
        // in the rest high - low >= 2. Easy.
        int mid = low + (high - low) / 2;
        int[] a1 = maxmin(a, low, mid);
        int[] a2 = maxmin(a, mid + 1, high);
        ans[0] = (a[a1[0]] > a[a2[0]])?a1[0]:a2[0]; // larger with the larger
        ans[1] = (a[a1[1]] < a[a2[1]])?a1[1]:a2[1]; // smaller with the smaller
        return ans;
    }
    
    // Try to write the iterative version, if you want. Should take a lot of time.   
    public static int[] maxmin(int[] a) {
    	return null;
    }
    
    public static int second(int[] a) {
        
        return -1;
    }
    
    public static int recSecond(int[] a) {
        
        return -1;
    }
    
    public static void main(String args[]) {
        int[] a = {12, 35, 1, 10, 1, 19, 49, 34, 49, 2};
        System.out.println(Arrays.toString(a));
        System.out.println(peak(a));
        System.out.println("a peak: " + recursivePeak(a));
        System.out.println("The maximum is (recursive): " + recursiveMax(a));
        System.out.println("The maximum is (iterative): " + max(a));
//        System.out.println("second largest: a[" + second(a) + "] = " + a[second(a)]);
//        System.out.println("second largest: a[" + recSecond(a) + "] = " + a[recSecond(a)]);
        int[] ans = maxmin(a, 0, a.length - 1);
        System.out.println("max = " + ans[0] + ", min = " + ans[1]);
    }
}
