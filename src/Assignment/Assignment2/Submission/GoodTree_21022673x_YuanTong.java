package Assignment.Assignment2.Submission;


/**
 * @author Yuan Tong (November 12, 2021)
 * 
 * A good tree is a binary tree satisfying the heap-order property
 * It may or may not be complete.
 * 
 * You are NOT allowed to call the constructor of class Node, except in <em>main</em>.
 */
public class GoodTree_21022673x_YuanTong {
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

    public GoodTree_21022673x_YuanTong() {root = null;}
    public GoodTree_21022673x_YuanTong(int e) {root = new Node(e);}

    /**
     *
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
     *     1. https://www.geeksforgeeks.org/iterative-preorder-traversal/
     *     2. Lecture 4 sample code: LinkedList.java
     *     3. 
     *     ... 
     * 
     * Running time: O(N).
     */

    // Use this one
    public int size() { return Size(root); }

    public int recSize() { return -1; }

    private int Size(Node e) {

        int counter = 0; //counter

        //Travel
        MyStack<Node> myStack = new MyStack<>();
        myStack.push(e);
        while (myStack.isEmpty() == false) {
            Node current = myStack.pop();

            // Work
            counter ++;

            if (current.rc != null) {
                myStack.push(current.rc);
            }
            if (current.lc != null) {
                myStack.push(current.lc);
            }
        }
        return counter;
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
     *     1. https://www.geeksforgeeks.org/iterative-preorder-traversal/
     *     2. Lecture 4 sample code: LinkedList.java
     *     3. 
     *     ... 
     * 
     * Running time: O(N).
     */

    // Use this one
    public int min() { return min(root); }

    public int recMin() { return -1; }

    private int min(Node e) {
        int min = 0; //min

        //Travel
        MyStack<Node> myStack = new MyStack<>();
        myStack.push(e);
        min = e.element;

        while (myStack.isEmpty() == false) {
            Node current = myStack.pop();

            // Work
            if (current.element < min) min = current.element;

            if (current.rc != null) {
                myStack.push(current.rc);
            }
            if (current.lc != null) {
                myStack.push(current.lc);
            }
        }
        return min;
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
     *     1. https://www.geeksforgeeks.org/iterative-preorder-traversal/
     *     2. Lecture 4 sample code: LinkedList.java
     *     3. 
     *     ... 
     * 
     * Running time: O(N).
     */


    public int leaves() { return -1; }

    // Use this one
    public int recLeaves() { return recLeaves(root); }

    /**
     *
     * Case:
     * 1.Leave
     * 2.Half node
     * 3.Full node
     */

    private int recLeaves(Node e) {
        if (e.lc==null&&e.rc==null) { // leave
            return 1;
        }
        else if (e.lc!=null&&e.rc==null) { // only left
            return recLeaves(e.lc);
        }
        else if (e.rc!=null&&e.lc==null) { // only right
            return recLeaves(e.rc);
        }
        else { // Full node
            return recLeaves(e.rc) + recLeaves(e.lc);
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
     *     1. https://www.geeksforgeeks.org/iterative-preorder-traversal/
     *     2. Lecture 4 sample code: LinkedList.java
     *     3. 
     *     ... 
     * 
     * Running time: O(N).
     */


    public int fullNodes() { return -1; }

    // Use this one
    public int recFullNodes() { return recFullNodes(root); }

    /**
     * Case:
     * 1.Full node：1 + Number of Full node in Subtree
     * 2.Not Full: Number of Full node in Subtree
     * 3.Leaf: 0
     */
    private int recFullNodes(Node e) {
        if (e.lc==null&&e.rc==null) {
            return 0;
        }
        else if (e.lc!=null&&e.rc==null) {
            return recFullNodes(e.lc);
        }
        else if (e.rc!=null&&e.lc==null) {
            return recFullNodes(e.rc);
        }
        else {
            return 1 + recFullNodes(e.rc) + recFullNodes(e.lc);
        }
    }

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
     * Running time: O(1+d1+d2).
     */

    public void merge(GoodTree_21022673x_YuanTong t2) {
        if (root == null) root = t2.root;
        else if (t2.root==null) root = root;
//        else root = merge(root, t2.root);
        else root = merge(root, t2.root);
    }

    private Node merge(Node root_1, Node root_2) {
        if (root_1.element > root_2.element) {
            if (root_1.rc != null) {
                Node subtree = root_1.rc;
                root_1.rc = merge(subtree, root_2);
            }
            else {
                root_1.rc = root_2;
            }
            return root_1;
        }
        else {
            if (root_2.rc != null) {
                Node subtree = root_2.rc;
                root_2.rc = merge(subtree, root_1);
            }
            else {
                root_2.rc = root_1;
            }
            return root_2;
        }
    }

    /**
     * Part (3)
     * 
     * Check whether the tree is a complete binary tree.
     *
     * A complete binary tree is a binary tree in which all the levels are completely filled except
     * possibly the lowest one, which is filled from the left.
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
     * Running time: O(N).
     */

    public boolean isComplete() { return isComplete(root); }

    /**
     * This method will scan each layer
     * If the layer has empty node
     * It will check whether the nodes are filled from left
     * If not return false, else return ture
     *
     * @param e
     * @return result
     */

    private boolean isComplete(Node e) {
        int layer = 0;
        Node[] node_this_layer = new Node[(int) Math.pow(2,layer)];

        if (e!=null) node_this_layer[0] = e;
        else System.out.println("Error");

        Node[] node_next_layer = new Node[(int) Math.pow(2,layer+1)];

        while (true) {
            boolean isEmpty = true;
            boolean hasEmply = false;
            printNodes(node_this_layer);
            for (int i = 0; i < node_this_layer.length; i++) {
                if (node_this_layer[i]!=null){
                    if (node_this_layer[i].lc!=null) {
                        node_next_layer[2*i] = node_this_layer[i].lc;
                        isEmpty = false;
                    }
                    if (node_this_layer[i].rc!=null) {
                        node_next_layer[2*i+1] = node_this_layer[i].rc;
                        isEmpty = false;
                    }
                }
                else {
                    hasEmply = true;
                }
            }

            if (hasEmply) {
//                System.out.println("Has empty");
                boolean EmptyNode = false;
                for (int i = 0; i < node_this_layer.length; i++) {
                    if (node_this_layer[i] == null){
                        EmptyNode = true;
                    }
                    if (EmptyNode && node_this_layer[i] != null) {
//                        System.out.println("Not full");
                        return false;
                    }
                }
            }

            node_this_layer = node_next_layer;
            layer++;
            node_next_layer = new Node[(int) Math.pow(2,layer+1)];
            if (isEmpty) break;
        }

        return true;
    }

    private void printNodes(Node[] e){
        for (int i = 0; i < e.length; i++) {
            if (e[i]!=null) System.out.print("(" + i + ") " + e[i].element + " ");
        }
        System.out.println();
    }


    /**
     *
     * Data structure form
     * Lecture 4
     */

    private class MyStack<T> {
        class Node<T> {
            T element;
            Node<T> next;

            public Node(T a) {
                element = a;
                next = null;
            }
        }

        private Node<T> head; // no tail by default

        public MyStack() {
            head = null;
        }

        // Running time: O( 1 ).
        public void insertFirst(T a) {
            Node<T> newNode = new Node<T>(a);
            newNode.next = head;
            head = newNode;
            // if (tail == null) tail = newNode;
        }

        // Running time: O( 1 ).
        public T removeFirst() {
            if (head == null) {
                System.out.println("underflow");
                return null;
            }
            Node<T> temp = head;
            head = head.next;
            temp.next = null;      // optional but suggested.
            return temp.element;
        }

        // Running time: O( 1 ).
        public boolean isEmpty() {
            return head == null;
        }

        // Running time: O( n ).
        public Node<T> search(T a) {
            Node<T> cur = head;
            while(cur != null && cur.element != a)
                cur = cur.next;
            return cur;
        }

        public void push(T a) { insertFirst(a); }

        public T pop() { return removeFirst(); }

        public T peek() { return head.element; }

        public String toString() {
            if (head == null) return "The list is empty.";
            StringBuilder sb = new StringBuilder();
            sb.append(head.element);
            Node<T> cur = head.next;
            while ( cur != null ) {
                sb.append(" -> " + cur.element);
                cur = cur.next;
            }
            return sb.toString();
        }

    }


    public static void main(String[] args) {

        int[] a1 = {214, 562, 83, 115, 97, 722, 398, 798, 408, 199, 37, 336};
        int[] a2 = {100, 79, 67, 2, 7, 73, 42, 24, 63, 36, 13, 25, 1};

        GoodTree_21022673x_YuanTong t1 = new GoodTree_21022673x_YuanTong(); // an empty one
        for (int i:a1)
            t1.merge(new GoodTree_21022673x_YuanTong(i));

        GoodTree_21022673x_YuanTong t2 = new GoodTree_21022673x_YuanTong(); // an empty one
        for (int i:a2)
            t2.merge(new GoodTree_21022673x_YuanTong(i));
        t1.merge(t2);

        // you may add something here test your codes.

        System.out.println("Size: ");
        System.out.println("By iteration: " + t1.size());


        System.out.println("Min: ");
        System.out.println("By iteration: " + t1.min());


        System.out.println("Leaves: ");
        System.out.println("By recursion: " + t1.recLeaves());

        System.out.println("Full nodes");
        System.out.println("By recursion: " + t1.recFullNodes());



    }
}
