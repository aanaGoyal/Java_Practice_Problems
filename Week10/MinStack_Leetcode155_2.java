package Week10;

import java.util.Stack;

public class MinStack_Leetcode155_2 {
	static class MinStack {
	    Stack<Integer>stack;
	    Stack<Integer>minStack;

	    public MinStack() {
	        stack = new Stack<>();
	        minStack = new Stack<>();
	    }
	    
	    public void push(int value) {
	        stack.push(value);
	        if(minStack.isEmpty() || minStack.peek()>=value){
	            minStack.push(value);
	        }
	    }
	    
	    public void pop() {
	        if(stack.peek().equals(minStack.peek())){
	            minStack.pop();
	        }
	        stack.pop();
	    }
	    
	    public int top() {
	        if(!stack.isEmpty()){
	            return stack.peek();
	        }
	        return -1;
	    }
	    
	    public int getMin() {
	        if(!minStack.isEmpty()){
	            return minStack.peek();
	        }
	        return -1;
	    }
	}
	
	
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(40);
		minStack.push(20);
		minStack.push(30);
		minStack.push(15);
		minStack.push(50);
		System.out.println("Stack Top: " + minStack.top());
		System.out.println("MinStack Top: " + minStack.getMin());
	}

	
}
