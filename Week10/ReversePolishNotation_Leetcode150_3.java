package Week10;

import java.util.Stack;

public class ReversePolishNotation_Leetcode150_3 {
	static int performOperation(int a, int b, String s) {
		if(s == "+") {
			return a + b;
		}else if(s == "-") {
			return a - b;
		}else if(s == "*") {
			return a * b;
		}else if(s == "/") {
			return a/b;
		}else if(s == "^") {
			return a^b;
		}
		return 0;
	}
	
	
	static int evalReversePolishNotation(String tokens[]) {
		Stack<Integer>stack = new Stack<>();
		
		for(int i=0; i<tokens.length; i++) {
			String token = tokens[i];
			if(token == "+" || token == "*" || token == "-" || token == "/") {
				int secondValue = stack.pop();
				int firstValue = stack.pop();
				int result = performOperation(firstValue, secondValue, token);
				stack.push(result);
			}else {
				stack.push(Integer.parseInt(token));
			}
		}
		
		return stack.pop();
	}
	
	
	public static void main(String[] args) {
		String tokens[] = {"2", "3", "+", "3", "*"};
		System.out.println(evalReversePolishNotation(tokens));
	}
}
