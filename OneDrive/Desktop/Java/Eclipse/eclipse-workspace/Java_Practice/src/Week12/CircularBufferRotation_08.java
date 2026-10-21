package Week12;

public class CircularBufferRotation_08 {
	int buffer[];
	int front;
	int rear;
	int size;
	int capacity;
	CircularBufferRotation_08(int capacity){
		this.capacity = capacity;
		buffer = new int[capacity];
		this.front = 0;
		this.rear = -1;
		this.size = 0;
	}
	
	
	void ADD(int x) {
		if(size == capacity) {
			System.out.println("FULL");
			return;
		}
		
		rear = (rear + 1)%capacity;
		buffer[rear] = x;
		size++;
	}
	
	int REMOVE() {
		if(size == 0) {
			System.out.println("EMPTY");
			return -1;
		}
		
		int toRemove = buffer[front];
//		System.out.println(toRemove);
		size--;
		front = (front+1)%capacity;
		return toRemove;
	}
	
	
	void ROTATE(int k) {
		while(k-- != 0) {
			int toRemove = REMOVE();
			ADD(toRemove);
		}
	}
	
	public static void main(String[] args) {
		int C1 = 3;
		CircularBufferRotation_08 cb1 = new CircularBufferRotation_08(C1);
		cb1.ADD(4);
		cb1.ADD(6);
		cb1.ADD(9);
		cb1.ROTATE(1);
		System.out.println(cb1.REMOVE());
		cb1.ADD(2);
		System.out.println(cb1.REMOVE());
		
		
		int C2 = 2;
		CircularBufferRotation_08 cb2 = new CircularBufferRotation_08(C2);
		cb2.ADD(10);
		cb2.ADD(20);
		cb2.ADD(30);
		cb2.ROTATE(3);
		System.out.println(cb2.REMOVE());
		
	}
}
