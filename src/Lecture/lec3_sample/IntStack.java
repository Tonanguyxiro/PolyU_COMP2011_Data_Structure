package Lecture.lec3_sample;

/**
 * 
 * @author yixin cao (September 26, 2020)
 *
 * A stack for ints. Note that initial index of top is 0.
 */
public class IntStack {
    private static final int CAPACITY=128;
    private int[] data;
    private int top;

    public IntStack() {
        this(CAPACITY);
    }
    
    public IntStack(int size){
        top = 0;
        data = new int[size];
    }
    
    // Running time: O( 1 ).
	public boolean isEmpty()  {
		return top == 0;
	}
	
    // Running time: O( 1 ).
	public void push(int e) {
		if (top == CAPACITY) {
		    // throw an exception.
		    System.out.println("overflow");
		    return;
		}
		data[top++] = e;	
	}

    // Running time: O( 1 ).
	public int pop() {
        if (top == 0) {
            // throw an exception.
            System.out.println("downflow");
            return -1;
        }
		return data[--top];
	}

    // Running time: O( 1 ).
    public int peek(){
        if(isEmpty()) { System.out.println("downflow"); return -1;}
        return data[top-1];
    }
}
