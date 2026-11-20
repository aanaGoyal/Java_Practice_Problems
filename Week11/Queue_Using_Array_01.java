package Week11;

public class Queue_Using_Array_01 {
	int [] arr;
	int front;
	int rear;
	int size;
	Queue_Using_Array_01(int size){
		arr = new int[size];
		this.size = size;
		this.front = -1;
		this.rear = -1;
	}
	
	
	
	
	void enque(int value) {
		if(rear == size-1) {
			System.out.println("Queue Overflow");
			return;
		}
		
		if(front == -1) {
			front++;
		}
		
		arr[++rear] = value;
		System.out.println(value + "added...");
	}
	
	
	
	
	int dequeue() {
		if(rear == -1 || front > rear) {
			System.out.println("Queue Underflow");
			return -1;
		}
		
		int toRemove = arr[front];
		front++;
		return toRemove;
	}
	
	
	
	void peek() {
		if(front == -1) {
			System.out.println("Queue is Empty");
			return;
		}
		
		System.out.println(arr[front]);
	}
	
	
	
	void display() {
		if(front == -1) {
			System.out.println("Queue is Empty");
			return;
		}
		
		for(int i=front; i<=rear; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	
	public static void main(String[] args) {
		Queue_Using_Array_01 queue = new Queue_Using_Array_01(5);
		queue.enque(1);
		queue.enque(2);
		queue.enque(3);
		queue.enque(4);
		queue.enque(5);
		queue.enque(6);
		System.out.println(queue.dequeue());
		queue.peek();
		queue.display();
		
		
	}
}
