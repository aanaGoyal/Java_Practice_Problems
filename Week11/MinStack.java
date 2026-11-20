package Week11;

import java.util.ArrayList;

public class MinStack {
	int stack[];
	int minStack[];
	int top;
	
	MinStack(int size){
		stack = new int[size];
		minStack = new int[size];
		this.top = -1;
	}
	
	void push(int value) {
		if(top == stack.length-1) {
			System.out.println("Stack Overflow");
			return;
		}
		
		stack[++top] = value;
		if(top == 0) {
			minStack[top] = value;
		}else {
			minStack[top] = Math.min(value, minStack[top-1]);
		}
	}
	
	void pop() {
		if(top == -1) {
			System.out.println("Stack is Empty");
			return;
		}
		
		System.out.println(stack[top--]);
	}
	
	void top() {
		if(top == -1) {
			System.out.println("Stack is Empty");
			return;
		}
		
		System.out.println(stack[top]);
	}
	
	void getMin() {
		if(top == -1) {
			System.out.println("Stack is Empty");
			return;
		}
		
		System.out.println(minStack[top]);
	}
	public static void main(String[] args) {
		MinStack stack1 = new MinStack(5);
		stack1.push(1);
		stack1.push(10);
		stack1.push(5);
		stack1.push(3);
		stack1.push(20);
		
		stack1.pop();
		stack1.top();
		stack1.getMin();
		
		// There is no need to handle duplicate values as we just want smaller value I compared the current value with the previous
		// one and if that value is smaller than current we add it to our top index also because that is needed.
	}
}
