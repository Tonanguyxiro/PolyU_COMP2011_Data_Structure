package Lecture.lec3_sample;

/**
 * 
 * @author yixin cao (September 6, 2017)
 *
 * A stack that can only holds chars.
 * Warning: it uses a fixed-length array for internal storage.
 * 
 * See {@code Stack} in the same package and {@code java.util.Stack}.
 */
public class CharStack {
    private static final int CAPACITY = 128;
    private char[] data;
    private int top;
    
    public CharStack() {
        this(CAPACITY);
    }
    
    public CharStack(int size){
        top = -1; // try to change to 0.
        data = new char[size];
    }
    
    // Running time: O( 1 ).
    public void push(char c){
        if (top + 1 == CAPACITY) { System.out.println("Oops..."); return;}  // better to throw an exception.
        data[++top] = c;
    }

    // Running time: O( 1 ).
    public char pop(){
        if(isEmpty()) { System.out.println("Oops..."); return ' ';}
        return data[top--];
        /*
         * or the following three ungly lines.
        char c = data[top];
        top--;
        return c;
        */
    }

    // Running time: O( 1 ).
    public boolean isEmpty(){
        return top < 0;
    }

    // Running time: O( 1 ).
    public char peek(){
        if(isEmpty()) { System.out.println("Oops..."); return ' ';}
        return data[top];
    }

    public String toString(){
        String s = new String(data).substring(0,top+1);
        return s;
    }
}
