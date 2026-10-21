package Week12;

public class CircularQueue_02 {
	int arr[];
	int front;
	int rear;
	int size;
	int capacity;
	
	CircularQueue_02(int capacity){
		this.front = 0;
		this.rear = -1;
		arr = new int[capacity];
		this.size = 0;
		this.capacity = capacity;
	}
	
	void enqueue(int value) {
		if(size == capacity) {
			System.out.println("Queue is full...");
			return;
		}
		
		rear = (rear+1)%capacity;
		arr[rear] = value;
		size++;
		System.out.println("Value Inserted...");
	}
	
	
	void dequeue() {
		if(size == 0) {
			System.out.println("Queue is empty...");
			return;
		}
		
		System.out.println("Removed: " + arr[front]);
		front = (front+1) % capacity;
		size--;	
	}
	
	
	void display() {
		if(size == 0) {
			System.out.println("Queue is empty...");
			return;
		}
		
		for(int i=0; i<size; i++) {
			int index = (front + i)%capacity;
			System.out.print(arr[index] + " ");
		}
	}
	
	
	public static void main(String[] args) {
		CircularQueue_02 cq = new CircularQueue_02(4);
		cq.enqueue(1);
		cq.enqueue(2);
		cq.enqueue(3);
		cq.enqueue(4);
		
		cq.display();
		
		cq.dequeue();
		cq.dequeue();
		
		cq.enqueue(5);
		cq.enqueue(6);
		
		cq.display();
		
		cq.dequeue();
		cq.dequeue();
		cq.dequeue();
		
		cq.enqueue(7);
		cq.enqueue(8);
		cq.enqueue(9);
		
		cq.display();
	}
}
