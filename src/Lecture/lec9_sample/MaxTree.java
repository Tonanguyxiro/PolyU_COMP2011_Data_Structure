package Lecture.lec9_sample;

import java.util.Arrays;

/**
 * 
 * @author Yixin Cao (November 10, 2020)
 *
 * Use a maximum tree (introduced in Lecture 9) to sort an array.
 * 
 * To make it simple, I don't use generics here.
 * It's easy to revise it to use generics.
 */
public class MaxTree {
    private class Node {
        int element;
        public Node leftChild, rightChild;
        public Node(int element) { this.element = element; }
        public String toString() { return String.valueOf(element); }
    }
    Node root;
    
    // Build a maximum tree out of an array.
    public MaxTree(int[] a) {
        int n = a.length;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(a[i]);
        }
        while (n > 1) {
            for (int i = 0; i < n / 2; i++) {
                int max = Math.max(nodes[i * 2].element, nodes[i * 2 + 1].element);
                Node newNode = new Node(max);
                newNode.leftChild = nodes[i * 2];
                newNode.rightChild = nodes[i * 2 + 1];
                nodes[i] = newNode; // why it's safe to resue the space?
            }
            // n might be odd.
            if (n % 2 != 0)  {
                nodes[n/2] = new Node(nodes[n - 1].element);
                nodes[n/2].leftChild = nodes[n - 1];
            }
            
            n = (n + 1) / 2;
        }
        root = nodes[0];
    }
    public int deleteMax() {
        if (root == null) {
            System.out.print("downflow");
            return -1;
        }
        int res = root.element;
        if (deleteMax(root)) root = null;
        return res;
    }
    public boolean deleteMax(Node curRoot) {
        // if (curRoot == null) return -1;
        if (curRoot.leftChild == null && curRoot.rightChild == null) {
            return true;
        }
        // Note that {} in the following line cannot be omitted!
        if (curRoot.leftChild != null 
                && curRoot.element == curRoot.leftChild.element) {
            if (deleteMax(curRoot.leftChild)) curRoot.leftChild = null;
        }
        else // no need to check, why?
            if (deleteMax(curRoot.rightChild)) curRoot.rightChild = null;

        if (curRoot.leftChild == null && curRoot.rightChild == null) {
            return true;
        }
        // now at least one child left.
        curRoot.element = Integer.MIN_VALUE;
        if (curRoot.leftChild != null)
            curRoot.element = curRoot.leftChild.element;
        if (curRoot.rightChild != null && 
                curRoot.element < curRoot.rightChild.element)
            curRoot.element = curRoot.rightChild.element;
        return false;
    }

    public static void treeSort(int[] a) {
    	if(a.length == 0) return;
        MaxTree tree = new MaxTree(a);
        for (int i = a.length; i > 0 ; i--) {
            a[i - 1] = tree.deleteMax();
        }
    }

    public static void main(String[] args) {
        int testData[][] = { // try different inputs.
                {},
                {1, 1, 1, 1, 1, 1, 1},
                {10, 8, -4, 89, 2, 0, 4, -19, 200},
                {5, 4, 3, 2, 1, 1, 0, 0, -1},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
                {1, 3, 2, 6, 7, 5, 4, 12, 13, 15, 14, 10, 11, 9, 8},
                {3, 2, 6, 13, 8, 4, 10, 7, 14, 11, 12, 5, 9},
                {65, 85, 17, 88, 66, 71, 45, 38, 95, 48, 18, 68, 60, 96, 55},
                {10, 8, 14, 89, 32, 50, 77, 38} 
            };
        for (int[] a:testData) {
            System.out.println("The original array: " + Arrays.toString(a));
            treeSort(a);
            System.out.println("Sorted: " + Arrays.toString(a));
        }
    }
}
