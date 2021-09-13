package Lecture.lec3_sample;

/**
 * 
 * @author yixin cao (September 4, 2021)
 *
 * A simple class to demonstrate the == operator and the {@code equals()} method.
 *
 */
public class JavaTips {

    // the dummy constructor can be omitted.
    public JavaTips(){} 
    
    public static void main(String[] args) {
        // The Integer class wraps a value of the primitive type int in an object.
        // https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/lang/Integer.html
        Integer a = Integer.valueOf(2011);
        Integer b = Integer.valueOf(2011);
        System.out.println(a == b); // false
        System.out.println(a.equals(b)); // true
        
        // Advanced testing. 
        // If we do not implement the {@code toString()} method, Java prints out the address of an object.
        JavaTips jt1 = new JavaTips();
        JavaTips jt2 = new JavaTips();
        System.out.println("jt1 = " + jt1 + ", jt2 = " + jt2);
    }
}
