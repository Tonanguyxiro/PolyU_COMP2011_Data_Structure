package Lecture.lec10_sample;

import java.util.Arrays;

/*
 * @author Yixin Cao (October 20, 2021)
 *
 * A maximum heap data structure storing ints.
 * It has some non-standard operations. Pay attention.
 */
public class Heap_2 {
	private int[] data;
	private int size;  // not really needed for these applications.

	public Heap_2(int capacity) {
		data = new int[capacity];
	}
	
    private void swap(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
    
    public void down(int p) {
        if (p * 2 + 2 > size) return;
        int smaller = p * 2 + 1;
        if (smaller + 1 < size && data[smaller] > data[smaller+1])
            smaller++;
        if (data[p] <= data[smaller]) return;
        swap(p, smaller);
        down(smaller);
    }
    
    public void up(int index) {
        int parent = (index - 1) / 2;
        if (index == 0 || data[parent] < data[index]) return;
        swap(index, parent);
        up(parent);
    }    

    private void err(String message) {
        System.out.println("oops..." + message);
    }
    
    public void insert(int e) {
        // a more friendly way is to double the size of data
        if (size == data.length) {err("overflow"); return;}
        data[size] = e;
        up(size++); // don't forget to increase size.
    }
    
    void setRoot(int e) {
    	data[0] = e;
    }

    public int removeMax() {
        if (size == 0) {err("downflow"); return -1;}
        int ans = data[0];
        data[0] = data[--size]; //don't forget to decrease size.
        down(0);
        return ans; 
    }

    public int peek() {
        if (size == 0) {err("downflow"); return -1;}
        return data[0];
    }
    
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(data, 0, size));
    }
    
    public static void main(String[] args) {
        int[] a = {9, 7, 6, 5, 4, 3, 2, 1, 8};
        Heap_2 heap = new Heap_2(a.length);
        for (int i:
             a) {
            heap.insert(i);
        }
//        System.out.println(heap);
        for (int i = 0; i < a.length; i++) {
            System.out.println(heap.removeMax());
        }
        // you may do some test here.
    }
}

