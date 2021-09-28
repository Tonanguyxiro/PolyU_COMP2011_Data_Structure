package Lecture.lec4_sample;

/*
 * @author Yixin Cao
 *
 * A double-end linked list (with tail).
 *
 * Six modifications are required, of which one is already given.
 */

public class LinkedListWithTail<T> {
    static class Node<T> {
        T element;
        Node<T> next;

        public Node(T a) {
            element = a;
            next = null;
        }
    }

    // modification 1, add tail here
    Node<T> head, tail;

    public LinkedListWithTail() {
        // modification 2, initialize tail 
        head = null;
        tail = null;
    }

    // Running time: O( 1 ).
    public void insertFirst(T a) {
        Node<T> newNode = new Node<T>(a);
        newNode.next = head;
        head = newNode;

        // modification 3
        if (tail == null) tail = head;
    }

    // Running time: O( 1 ).
    public void insertLast(T a) {
        if (head == null) {
            insertFirst(a);
            return;
        }

        // modification 4， with the tail reference, this method can be done in O(1) time.
        Node<T> newNode = new Node<T>(a);
        newNode.next = null;
        tail.next = newNode;
        tail = newNode;
    }

    // try to modify it.
    // Running time: O( 1 ).
    public void insertAfter(Node<T> insertionPoint, T a) {
        Node<T> newNode = new Node<T>(a);
        newNode.next = insertionPoint.next;
        insertionPoint.next = newNode;
    }

    // try to modify it.
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
            System.out.println("downflow");
            return null;
        }
        Node<T> temp = head;
        head = head.next;
        temp.next = null;
        
        // modification 5，add this line for special case
        if (head == null) tail = null;
        return temp.element;
    }

    // Running time: O( n ).
    public T removeLast() {
        if (head == null || head.next == null)
            return removeFirst();


        Node<T> secondToLast = head;
        Node<T> last = secondToLast.next;
        while (last.next != null) {
            secondToLast = secondToLast.next;
            last = last.next;
        }
        
        // modification 6， add this line
        tail = secondToLast; 
        tail.next= null;
        return last.element;
    }

    public boolean isEmpty() {
        return head == null; //or tail == null;
    }
    
    public String toString() {
        if (head == null) return "The list is empty.";
        StringBuilder sb = new StringBuilder();
        Node<T> cur = head;
        while ( cur != null ) {
            sb.append(cur.element + "\n");
            cur = cur.next;
        }
        return sb.toString();
    }
}
