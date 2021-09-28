package Lecture.lec5_sample;

/**
 * 
 * @author Yixin Cao (September 19, 2020)
 *
 * Linked list version 2.  This one contains the <em>reverse</em> methods.
 * 
 */
public class LinkedList<T> {
    static class Node<T> {
        T element;
        Node<T> next;

        public Node(T a) {
            element = a;
            next = null;
        }
    }

    Node<T> head;

    public LinkedList() {
        head = null;
    }

    // Running time: O( 1 ).
    public void insertFirst(T a) {
        Node<T> newNode = new Node<T>(a);
        newNode.next = head;
        head = newNode;
        // if (tail == null) tail = newNode;
    }

    // Running time: O( n ).
    public void insertLast(T a) {
        if (head == null) {
            insertFirst(a); // lazy and smart
            return;
        }

        Node<T> newNode = new Node<T>(a);
        Node<T> cur = head;
        while (cur.next != null)
            cur = cur.next;
        cur.next = newNode;
        newNode.next = null; // very important.
    }

    // Running time: O( 1 ).
    public void insertAfter(Node<T> insertionPoint, T a) {
        Node<T> newNode = new Node<T>(a);
        newNode.next = insertionPoint.next;
        insertionPoint.next = newNode;
    }

    // Running time: O(  ).
    public void insertAfter(T insertionPoint, T a) {
    	// try to implement this.
    }
    
    // Running time: O( n ).
    public void insertBefore(Node<T> insertionPoint, T a) {
        if (head == insertionPoint) {
            insertFirst(a);
            return;
        }
        
        Node<T> cur = head;
        // at the end of this while loop,
        // cur will be the node that points to insertionPoint
        while (cur.next != insertionPoint && cur.next != null)
            cur = cur.next;
        Node<T> newNode = new Node<T>(a);
        newNode.next = cur.next;
        cur.next = newNode;
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

    // Running time: O( n ).
    public T removeLast() {
        if (head == null || head.next == null) // empty list, or a single-element list.
            return removeFirst();

        Node<T> secondToLast = head;
        Node<T> last = secondToLast.next;
        while (last.next != null) {
            secondToLast = last;
            last = last.next;
        }
        
        secondToLast.next = null;   // very important: many bugs are from omission of this step.
        return last.element;
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
    
    /*
     * The iterative version.
     * I use three temporary references.
     * Try to revise it to use only two.
     *
     * Running time: O( n ).
     */
    public void reverse() {
        if (head == null || head.next == null) return;
        Node<T> ind1 = head, ind2 = head.next, ind3;
        ind1.next = null;  // don't forget this!
        while (ind2.next != null) {
            ind3 = ind2.next;
            ind2.next = ind1;
            ind1 = ind2; 
            ind2 = ind3;
        }
        ind2.next = ind1;
        head = ind2;
    }

    /*
     * A good recursive version by NG, Shing Chi.
     *
     * Running time: O( n ).
     */
    public Node<T> reverse(Node<T> temp){
        if(temp == null) return null;
        if(temp.next != null) 
            reverse(temp.next).next = temp;
        else head = temp;
        temp.next = null;
        return temp;
    }
  
    /*
     * The stupid version of recursive reverse I wrote.
     * 
     * It's not easy to write this because the lack of tail.
     * I'm (kind of) cheating by using the return value of 
     * this method as the tail.
     *
     * Running time: O( n ).
     */
    public Node<T> recursiveReverse() {
        if (head == null || head.next == null) return head;
        LinkedList<T> newList = new LinkedList<T>();
        newList.head = head.next;
        Node<T> tail = newList.recursiveReverse();
        tail.next = head;
        head.next = null;
        tail = head;
        head = newList.head;
        return tail;
    }
        
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        System.out.println(list.isEmpty());
        list.insertFirst(37);
        System.out.println(list.isEmpty());
        list.insertFirst(99);
        list.insertFirst(12);
        list.insertLast(38);
        System.out.println("After inserting 37, 99, 12 in the front and then 38 at the end, we get");
        System.out.println(list);
        
        Node<Integer> n99 = list.head;
        while(n99.next != null) n99 = n99.next;
        list.insertAfter(n99, 75);
        System.out.println(list);
        list.insertBefore(n99, 55);
        System.out.println(list);

        System.out.println("delete the last, which is " + list.removeLast());       
        System.out.println(list);

        // testing reverse
        list.reverse();
        System.out.println("reversed: " + list + "\n");
        list.reverse(list.head);
        System.out.println("reversed again: " + list + "\n");
        list.recursiveReverse();
        System.out.println("reversed a third time: " + list + "\n");
        System.out.println("delete the first, which is " + list.removeFirst());     
        System.out.println(list);
        System.out.println("delete the last, which is " + list.removeLast());       
        System.out.println(list);
        
    }
}

