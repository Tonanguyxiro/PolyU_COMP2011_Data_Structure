package Assignment.Assignment2.Template;

/*
 * @author Yixin Cao (October 22, 2021)
 * 
 * A good tree is a binary tree satisfying the heap-order property
 * It may or may not be complete.
 * 
 * You are NOT allowed to call the constructor of class Node, except in <em>main</em>.
 */
public class GoodTree_12345678d_TangTszkei {
	/**
	 * 
	 * No modification to class Node is allowed.
	 * If you change anything here, your work will not be graded.
	 *
	 */
    private class Node {
        int element;
        public Node lc, rc;

        public Node(int key) {
            this.element = key;
        }

        public String toString() {
            return String.valueOf(element);
        }
    }

    Node root;
    public GoodTree_12345678d_TangTszkei() {root = null;}
    public GoodTree_12345678d_TangTszkei(int e) {root = new Node(e);}

    /**
     * Part (1)
     * Finding the size, the minimum key, the number of leaves, 
     * and the number of full nodes (those with two children) of a good tree.
     * 
     * For each task, you only need to finish one version,
     * recursive or iterative. 
     */
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
     * Running time: O(   ).   
     */ 
    public int size() { return -1; }
    public int recSize() { return -1; }
    
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
     * Running time: O(   ).   
     */ 
    public int min() { return -1; }
    public int recMin() { return -1; }
    
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
     * Running time: O(   ).   
     */ 
    public int leaves() { return -1; }
    public int recLeaves() { return -1; }

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
     * Running time: O(   ).   
     */ 
    public int fullNodes() { return -1; }
    public int recFullNodes() { return -1; }

    /**
     * Part (2)
     * Merge two good trees into a single good tree.
     * After <code>merge(t2)</code>, t2 is merged into this tree.
     * 
     * It must be in-place.
    */
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
     * Running time: O(   ).   
     */ 
    public void merge(GoodTree_12345678d_TangTszkei t2) {}
    
    /**
     * Part (3)
     * 
     * Check whether the tree is a complete binary tree.
     * 
     * The main difficulty is how to test this method. 
     */
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
     * Running time: O(   ).   
     */ 
    public boolean isComplete() { return false; }
    
    public static void main(String[] args) {
        int[] a1 = {214, 562, 83, 115, 97, 722, 398, 798, 408, 199, 37, 336};
        int[] a2 = {100, 79, 67, 2, 7, 73, 42, 24, 63, 36, 13, 25, 1};
        GoodTree_12345678d_TangTszkei t1 = new GoodTree_12345678d_TangTszkei(); // an empty one
        for (int i:a1) 
            t1.merge(new GoodTree_12345678d_TangTszkei(i));
        GoodTree_12345678d_TangTszkei t2 = new GoodTree_12345678d_TangTszkei(); // an empty one
        for (int i:a2) 
            t2.merge(new GoodTree_12345678d_TangTszkei(i));
        t1.merge(t2);
        // you may add something here test your codes.
    }
}
