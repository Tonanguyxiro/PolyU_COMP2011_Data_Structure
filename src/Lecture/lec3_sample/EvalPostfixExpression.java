package Lecture.lec3_sample;
import java.util.StringTokenizer;

/**
 * 
 * @author yixin cao (September 9, 2021)
 *
 * Using a stack to evaluate postfix expressions.
 * There are two slightly different implementations {@code eval} and {@code evalV2}.
 * 
 * For parsing an expression into tokens, see {@code StringTokenizer}.
 */
public class EvalPostfixExpression {
	/*
	 * This method is not related to our course.
	 * Its purpose here is to demostrate the use of StringTokenizer.
	 * More imformation can be found in Java API. 
	 */
	public static void demo(String postfix) {
		StringTokenizer parser = new StringTokenizer(postfix, " \n\t\r+-*/", true);
		int i = 0;
		while (parser.hasMoreTokens()) {
			String token = parser.nextToken();
			System.out.println("token " + (++i) + " is: " + token);
		}
	}
	
    // Running time: O( n ).
    public static int eval(String postfix){
		StringTokenizer parser = new StringTokenizer(postfix, " \n\t\r+-*/", true);
		// 3 2 1 - - has five tokens,
		IntStack stack = new IntStack();
		while (parser.hasMoreTokens()) {
			String token = parser.nextToken();
			char c = token.charAt(0);
			if (c >= '0' && c <= '9') stack.push(c - '0');
			if (c == '+') {int x = stack.pop(); int y = stack.pop(); stack.push(y + x);}
			if (c == '-') {int x = stack.pop(); int y = stack.pop(); stack.push(y - x);}
			if (c == '*') {int x = stack.pop(); int y = stack.pop(); stack.push(y * x);}
			if (c == '/') {int x = stack.pop(); int y = stack.pop(); stack.push(y / x);}
		}
        return stack.pop();
    }

    public static void main(String[] args) {
		//demo("3 2 - 1 -");
		System.out.println("3 2 - 1 - = " + eval("3 2 - 1 -"));
		System.out.println("3 2 1 - - = " + eval("3 2 1 - -"));
        System.out.println("5 1 - 2 - 6 5 / + = " + eval("5 1 - 2 - 6 5 / +"));
    }
    

    // Below is an alternative implementation.
    public static boolean isOperator(char c) {
        return ((c == '+') || (c == '-') || (c == '*') || (c == '/'));
    }

    public static boolean isWhiteSpace(char c) {
        return ((c == ' ') || (c == '\n') || (c == '\t') || (c == '\r'));
    }

    // Running time: O( n ).
    public static int evalV2(String postfix){
        IntStack s = new IntStack();
        StringTokenizer parser = new StringTokenizer(postfix, " \n\t\r+-*/", true);
        // 13 2 1 - - has five tokens,
        while (parser.hasMoreTokens()) {
            String token = parser.nextToken();
            char c = token.charAt(0);
            if (isOperator(c)) {
                int y = s.pop();
                int x = s.pop();
                switch (c) {
                case '+': s.push(x + y); break;
                case '-': s.push(x - y); break;
                case '*': s.push(x * y); break;
                case '/': s.push(x / y); break;
                } // end switch
            } // end if
            else if (!isWhiteSpace(c)) s.push(Integer.valueOf(token));
        } // end while
        return s.pop();
    }    
}
