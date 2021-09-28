package Lecture.lec4_sample;

/** 
 * 
 * @author Gloria Tang Tszkei (Your class, your way!)
 * 
 * The way of implementing a queue with a circular array.
 * 
 * The <em>front</em> index ... 
 * The <em>rear</em> index ...
 *
 */
public class MyQueue<T> {
    private static final int CAPACITY = 32;
    private Object[] data;
    private int front, rear;

    public MyQueue() {
        this(CAPACITY);
    }

    public MyQueue(int size){
    }

    // Running time: O(  ).
    public boolean isEmpty() {
    	return false;
    }

    // Running time: O(  ).
    public int size() {
        return 0;
    }

    // Running time: O(  ).
    public boolean isFull() {
    	return false;
    }

    // Running time: O(  ).
    public void enqueue(T e) {
    }

    // Running time: O(  ).
    @SuppressWarnings("unchecked")
    public T dequeue() {
        return null;
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
        MyQueue<String> queue = new MyQueue<String>();
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
