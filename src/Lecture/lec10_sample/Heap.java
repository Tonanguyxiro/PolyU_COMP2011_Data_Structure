package Lecture.lec10_sample;

import java.util.Arrays;

/**
 * 
 * @author Yixin Cao (October 10, 2020)
 *
 * The heap data structure storing objects (using generics).
 * 
 * Again, we use an explicit variable key and use it for comparisons  
 * This a bad idea. See more at the comments of  {@code comp2011.lec8.BinarySearchTree}.
 */
public class Heap<T> {
    private static class Node<T> {
        int key;
        T obj;

        public Node(int key, T element) {
            this.key = key;
            this.obj = element;
        }

        public String toString() {
            return key + ": " + obj;
        }
    }

    private Node<T>[] data; // a fixed-length array.
    int size; // we need the size.
    
    @SuppressWarnings("unchecked")
    public Heap(int capacity) {
        data = new Node[capacity];
        size = 0;
    }
    
    private void swap(int i, int j) {
        Node<T> temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    /*
     * an newly inserted element or an element whose key is increased bubbles up.
     * Running time: O( log n ). 
     */
    public void up(int c) {
        if (c == 0) return; //root.
        int p = (c - 1) / 2;
        if (data[c].key <= data[p].key) return;
        swap(c, p);
        up(p);
    }

    /*
     * Insert an new element with key <em>key</em>.
     * 
     * Running time: O( log n ). 
     */
    public void insert(int key, T x) {
        // a more friendly way is to double the size of arr
        if (size == data.length) {err("overflow"); return;}
        data[size] = new Node<T>(key, x);
        up(size++); // don't forget to increase size.
    }


    /*
     * The removed element or an element whose key is decreased bubbles down.
     * Running time: O( log n ). 
     */
    // the intuitive but slightly boring version.
    public void down(int p) {
        if (size < 2 * p + 2) return; // a leaf.
        int leftChild = p * 2 + 1; // always exist because size >= 2p+2.
        int rightChild = leftChild + 1; //may or may not exist
        int largerChild = leftChild;
        // don't forget to check rightChild < size 
        if (rightChild < size && data[leftChild].key < data[rightChild].key)
            largerChild = rightChild;
        if (data[p].key >= data[largerChild].key) return;
        swap(p, largerChild);
        down(largerChild);
    }
    // the crisp version.
    public void downV2(int p) { 
        if (p * 2 + 2 > size) return;
        int larger = p * 2 + 1;
        if (larger + 1 < size && data[larger].key < data[larger+1].key) 
            larger++;
        if (data[p].key >= data[larger].key) return;
        swap(p, larger);
        downV2 (larger);
    }
    
    private void err(String message) {
        System.out.println("oops..." + message);
    }

    /*
     * remove an element with the maximum key.
     * Since the root always has the maximum key, we remove it, and update the heap.
     * 
     * Running time: O( log n ). 
     */
    public T removeMax() {
        if (size == 0) {err("downflow"); return null;}
        
        T ans = data[0].obj;
        data[0] = data[--size]; //don't forget to decrease size.
        down(0);
        return ans; 
    }

    /*
     * Try to write the traversal algorithms on a heap represented as an array. 
     */
    public void inorder() {
        inorder(0);
    }
    public void inorder(int r) {
        if (r >= size) return;
        inorder(r*2 + 1);
        System.out.println(data[r]);
        inorder(r*2 + 2);
    }
    public void preorder() { }
    public void postorder() { }
    
    private int maxChild(int i) {
        // what if no child?
        // one child?
        // both?
        return -1;
    }    
    
    // try to finish this.
    private int minChild(int i) {
        return -1;
    }    
    
    /*
     * This is a naive version of heapsort, and it needs extra space. 
     */
    public void heapSort(int[] keys, T[] data) {
        Heap<T> heap = new Heap<T>(keys.length);
        for (int i = 0; i < keys.length; i++)
            heap.insert(keys[i], data[i]);
        for (int i = keys.length - 1; i >= 0; i--) 
            data[i] = heap.removeMax();
    }
    
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(data, 0, size));
    }
    
    static class Student {
        int id;
        String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {
        Heap<Student> heap = new Heap<Student>(20);
        heap.insert(214, new Student(214, "Chan Eason"));
        heap.insert(562, new Student(562, "Cheung Jacky"));
        heap.insert( 83, new Student( 83, "Ho Denise"));
        heap.insert(115, new Student(115, "Joey Yung"));
        heap.insert( 97, new Student( 97, "Andy Lau"));
        heap.insert(722, new Student(722, "Leung Gigi"));
        heap.insert(398, new Student(398, "Tang Gloria"));
        heap.insert(798, new Student(798, "Mickey"));
        heap.insert(408, new Student(408, "Teddy"));
        heap.insert(199, new Student(199, "Tse Kay"));
        heap.insert(337, new Student(337, "McDull"));
        System.out.println(heap);
        heap.removeMax();
        System.out.println("=====================");
        System.out.println(heap);
        
        int testData[][] = { // try different inputs.
                {},
                {1, 1, 1, 1, 1, 1, 1},
                {79, 73, 63, 67, 42, 36, 1, 2, 7, 25, 24, 13},
                {5, 4, 3, 2, 1, 1, 0, 0, -1},
                {10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
                {96, 95, 85, 85, 65, 17, 66, 71, 45, 38, 48, 18, 68, 60, 55} 
            };
        for (int[] a:testData) {
            System.out.println("The array " + Arrays.toString(a) + " is a heap: " + isHeap(a, 0));
            System.out.println("The array " + Arrays.toString(a) + " is a heap: " + isHeap(a));
        }        
    }


	/*
	* Check whether a given array is a heap.
	* The first is recursive, and the second iterative.
	* Running time O( n ).
	*/
    static boolean isHeap(int a[], int i) {
        int n = a.length;
        if (i >= (n - 2) / 2) return true;

        if (!(a[i] >= a[2 * i + 1] && isHeap(a, 2 * i + 1))) return false;
        return (2 * i + 2 == n) || (a[i] >= a[2 * i + 2] && isHeap(a, 2 * i + 2) );
    }

    static boolean isHeap(int a[]) {
        int n = a.length;
        for (int i = 0; i <= (n - 2) / 2; i++) {
            if (a[2 * i + 1] > a[i]) return false;
            if (2 * i + 2 < n && a[2 * i + 2] > a[i]) 
                return false;
        }
        return true;
    }

    // Tasks: iterative versions of bubble down and bobble up.

    // The running time of iDown is O(  ).
    public void iDown(int p) { 
    }

    // The running time of iUp is O(  ).
    public void iUp(int c) { 
    }
}

