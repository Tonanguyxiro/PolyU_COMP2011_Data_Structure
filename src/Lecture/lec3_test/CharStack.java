package Lecture.lec3_test;

class CharStack {
    private static final int CAPACITY = 128;
    private char[] data;
    private int top;

    public CharStack() {
        this(CAPACITY);
    }

    public CharStack(int size){
        top = 0;
        data = new char[size];
    }

    public void push(char c){
        top ++;
        data[top] = c;
    }

    char pop(){
        top --;
        return data[top+1];
    }

    public static void main(String[] args) {
        CharStack charStack = new CharStack();

        charStack.push('p');
        charStack.push('o');
        charStack.push('l');
        charStack.push('y');

        System.out.println(charStack.pop());
        System.out.println(charStack.pop());
        System.out.println(charStack.pop());
        System.out.println(charStack.pop());



    }
}
