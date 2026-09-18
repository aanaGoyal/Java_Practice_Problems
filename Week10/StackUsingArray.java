package Week10;

public class StackUsingArray {
	static class Stack{
		int arr[];
		int top;
		
		Stack(int n){
			arr = new int[n];
			top = -1;
		}
		
		
		void push(int value) {
			if(arr.length-1 == top) {
				System.out.println("Stack Overflow. Element cant be inserted");
				return;
			}
			arr[++top] = value;
		}
		
		
		int pop() {
			if(top == -1) {
				System.out.println("Stack Underflow. Stack is empty");
				return -1;
			}
			return arr[top--];
		}
		
		
		int peek() {
			if(top == -1) {
				System.out.println("Stack Underflow. Stack is empty");
				return -1;
			}
			return arr[top];
		}
		
		
		void display() {
			for(int i=top; i>=0; i--) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		int n = 5;
		Stack stack = new Stack(n);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		stack.display();
	}
}
