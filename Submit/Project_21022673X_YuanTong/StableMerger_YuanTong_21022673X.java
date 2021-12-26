import java.util.Arrays;

/**
 * @author Yuan Tong (December 26, 2021)
 *
 * Merge multple arrays with different length.
 * We use heap to store the length and index of the array so we can always find the shortest one.
 *
 *
 * First we need O(nlog(n)) time to construct the heap
 *
 * We need to do merge O(n) time,
 * for each operation, we need O(m) time to merge, and O(log(n)) time to update the heap.
 *
 * So the time complexity is O(mnlog(n))
 *
 * I refered the followung material:
 *   1.Smaple code of Lec10
 *   2.Sample code of Lab9
 */

public class StableMerger_YuanTong_21022673X {

    private int[][] arrays;
    Heap heap;

    public StableMerger_YuanTong_21022673X(int[][] arrays){
        //Store input data
        this.arrays = arrays;

        //Generate heap
        heap = new Heap(arrays);

    }


    // Common Heap data structure
    private class Heap {

        private Node[] data;
        private int size;

        private class Node {
            public int[] array;
            public int arraySize;

            public Node(int[] array){
                this.array = array;
                arraySize = array.length;
            }

        }

        public Heap(int capacity) {
            data = new Node[capacity];
            size=0;
        }

        public Heap(int[][] arrays){
            this(arrays.length);

            for (int[] i:
                 arrays) {
                this.insert(new Node(i));
            }

        }

        private void swap(int i, int j) {
            Node temp = data[i];
            data[i] = data[j];
            data[j] = temp;

        }

        private void down(int p) {
            if (p * 2 + 2 > size) return;
            int smaller = p * 2 + 1;
            if (smaller + 1 < size && data[smaller].arraySize > data[smaller+1].arraySize)
                smaller++;
            if (data[p].arraySize <= data[smaller].arraySize) return;
            swap(p, smaller);
            down(smaller);
        }

        private void up(int index) {
            int parent = (index - 1) / 2;
            if (index == 0 || data[parent].arraySize < data[index].arraySize) return;
            swap(index, parent);
            up(parent);
        }

        private void insert(Node e) {
            data[size] = e;
            up(size++); // don't forget to increase size.
        }

        public void insert(int[] array){
            insert(new Node(array));
        }

        private Node removeMin() {
            Node ans = data[0];
            data[0] = data[--size]; //don't forget to decrease size.
            down(0);
            return ans;
        }

        public int[] returnMinArray(){
            return removeMin().array;
        }

        public int[] returnRoot(){
            return data[0].array;
        }


        //test
        public void printSortResult() {
            for (int i = 0; i < data.length; i++) {
                System.out.println(removeMin().arraySize);
            }
        }

    }

    // Merge two arrays
    private int[] mergeTwo(int[] array1, int[] array2) {
        int i = 0, j = 0, k = 0;
        int n1 = array1.length, n2 = array2.length;
        int[] result = new int[n1 + n2];

        while (i < n1 && j < n2)
            result[k++] = (array1[i] <= array2[j])?array1[i++]:array2[j++];
        for (; i < n1; ) result[k++] = array1[i++];
        for (; j < n2; ) result[k++] = array2[j++];

        return result;
    }

    private void merge(){
        int[] array = mergeTwo(heap.returnMinArray(), heap.returnMinArray());
//        System.out.println(Arrays.toString(array));
        heap.insert(array);
    }

    public void mergeAll(){
        int times = arrays.length - 1;
        for (int i = 0; i < times; i++) {
            merge();
        }
    }

    public int[] mergeResult() {
        return heap.returnRoot();
    }
    /*
    * For test
    * */
    private void testSort() {
        heap.printSortResult();
    }

    public static void main(String[] args) {
        int[][] arrays = {
                {1,2,3,4,5},
                {6,7,8,9},
                {10,11,12},
                {13,14},
                {15}
        };

        StableMerger_YuanTong_21022673X test = new StableMerger_YuanTong_21022673X(arrays);

//        test.testSort();

        test.mergeAll();

        System.out.println(Arrays.toString(test.mergeResult()));
    }




}
