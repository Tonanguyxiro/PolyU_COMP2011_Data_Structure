package Lecture.lec3_sample;

/**
 * 
 * @author yixin cao (September 26, 2020)
 *
 * A naive implementation of adjustable arrays.
 * When the space is used up and the operation {@code add} is called, 
 * it increases the capacity by a certain factor.
 * 
 * See {@code java.util.ArrayList}.
 */
public class AdjustableArray {
    private static final int INITIAL = 32;
    private int[] data;
    private int size;
    
    public AdjustableArray() {
        data = new int[INITIAL];
        size = 0;
    }

    // Running time: O( n ).  Better to amortized analysis.
    public void add(int  a) {
        if (size == data.length) {
            int [] old = data;

            int newSize = size * 3 / 2; // try different factor.

            data = new int[newSize];
            for (int i = 0; i < size; i++)
                data[i] = old[i];
        }
        data[size++] = a; 
    }
    public String toString() {
        return new String(data, 0, size);
    }
    
    public static void main(String[] args) {
        AdjustableArray aa = new AdjustableArray();
        int n = 32768;  // n in general.
        for(int i = 0; i < n; i++)
            aa.add(i);
        System.out.print(aa);
    }
}
