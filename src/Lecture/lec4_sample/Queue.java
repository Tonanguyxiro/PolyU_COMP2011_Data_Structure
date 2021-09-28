package Lecture.lec4_sample;

/** 
 * 
 * @author Yixin Cao (September 19, 2020)
 * 
 * The way of implementing a queue with a circular array.
 * 
 * The <em>front</em> index of the first element of the queue, 
 *      the element that would be read (dequeue and peek).
 * The <em>rear</em> index of the last element of the queue.
 *
 * We use initial values 0 and -1.
 * See http://www.mathcs.emory.edu/~cheung/Courses/171/Syllabus/8-List/array-queue2.html for a different choice.
 *
 * We allow only n - 1 elements. 
 * See the textbook for an implementation with a <em>size</em> variable. 
 *
 * We avoid the use of the remainder operator (%).
 * Read this page https://stackoverflow.com/questions/11720656/modulo-operation-with-negative-numbers, and try this page https://chortle.ccsu.edu/java5/Notes/chap09B/ch09B_17.html.  
 *  Also https://en.wikipedia.org/wiki/Modulo_operation (not an easy read).
 */
public class Queue<T> {
    private static final int CAPACITY = 32;
    private Object[] data;
    private int front, rear;

    // fixed-length. Simple but not a good idea.
    public Queue() {
        this(CAPACITY);
    }

    public Queue(int size){
        data = new Object[size];
        front = 0;
        rear = -1;
    }

    // Running time: O( 1 ).
    public boolean isEmpty() {
    	return size() == 0;
    }

    // Running time: O( 1 ).
    public int size() {
        if (rear == front - 1) return 0;
        return rear - front + 1 + (front <= rear?0:CAPACITY); // or (rear - front + CAPACITY) % CAPACITY + 1;
        // Note that "+ CAPACITY" in the parentheses, and the final "+1";
        // Consider, e.g., the case front = CAPACITY - 3 and rear = 4.
    }

    // Running time: O( 1 ).
    public boolean isFull() {
    	return size() == CAPACITY - 1;
    }

    // Running time: O( 1 ).
    public void enqueue(T e) {
        // Uncomment this to see the change of indices.
        // System.out.println("before enquequing, front = " + front + "; rear = " + rear);
        if (isFull()) {
            System.out.println("Error: queue is full.");
            return;
        }

        if (++rear == CAPACITY) rear = 0;   // or rear = ++rear % CAPACITY
        data[rear] = e;
        // Uncomment this to see the change of indices.
        // System.out.println("after enquequing, front = " + front + "; rear = " + rear);
    }

    // Running time: O( 1 ).
    @SuppressWarnings("unchecked")
    public T dequeue() {
        // Uncomment this to see the change of indices.
        // System.out.println("before dequequing, front = " + front + "; rear = " + rear);

        if (isEmpty()) {
            System.out.println("Error: empty queue.");
            return null;
        }
        
        T a = (T) data[front++];
        if (front == CAPACITY) front = 0;  // or front = front % CAPACITY
        // Uncomment this to see the change of indices.
        // System.out.println("after dequequing, front = " + front + "; rear = " + rear);
        
        return a;
    }
    
    // Running time: O( 1 ).
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            System.out.println("Error: empty queue.");
            return null;
        }
        
    	return (T) data[front];
    }

    public String toString() {
        if (isEmpty()) return "The queue is empty.";
        StringBuilder sb = new StringBuilder();
        if (rear >= front) {
            for (int i = front; i <= rear; i++)
                sb.append(data[i]);
        }
        else {
            for (int i = front; i < CAPACITY; i++)
                sb.append(data[i]);
            for (int i = 0; i <= rear; i++)
                sb.append(data[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();
        queue.enqueue("Eason Chan");
        queue.enqueue("Denise Ho");
        queue.enqueue("Jennifer Chan");
        queue.enqueue("Joey Yung");
        queue.enqueue("Kay Tse");
        queue.enqueue("Cheung Jacky");
        for (int i = 0; i < 4; i++)
            System.out.println(queue.dequeue());
        System.out.println("size = " + queue.size());
        queue.enqueue("Winnie");
        queue.enqueue("Mickey");
        queue.enqueue("Teddy");
        queue.enqueue("Peppa");
        for (int i = 0; i < 7; i++)
            System.out.println(queue.dequeue());
        System.out.println("size = " + queue.size());
    }
}
