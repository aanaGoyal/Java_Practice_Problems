package Week12;

public class CicularQueue_03 {
	int arr[];
    int front;
    int rear;
    int size;
    int capacity;
    
    
    public CicularQueue_03(int k) {
        this.capacity = k;
        arr = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }
    
    
    
    public boolean insertFront(int value) {
        if(size == capacity){
            return false;
        }

        if(size == 0){
            rear = 0;
            front = 0;
        }else{
            front = (capacity+front-1)%capacity;
        }
        
        arr[front] = value;
        size++;
        return true;
    }

    
    
    public boolean insertLast(int value) {
        if(size == capacity){
            return false;
        }

        if(size == 0){
            front = 0;
            rear = 0;
        }else{
            rear = (rear+1)%capacity;
        }      
        arr[rear] = value;
        size++;
        return true;
    }
    
    
    
    public boolean deleteFront() {
        if(size == 0){
            return false;
        }

        if(size == 1){
            rear = -1;
            front = 0;
            size = 0;
            return true;
        }

        front = (front+1)%capacity;
        size--;
        return true;
    }
    
    

    public boolean deleteLast() {
        if(size == 0){
            return false;
        }

        if(size == 1){
            front = 0;
            size = 0;
            rear = -1;
            return true;
        }


        rear = (rear + capacity - 1)%capacity;
        size--;
        return true;
    }
    
    
    

    public int getFront() {
        if(size == 0){
            return -1;
        }

        return arr[front];
    }
    
    public int getRear() {
        if(size == 0){
            return -1;
        }

        return arr[rear];
    }
    
    
    
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    
    
    public boolean isFull() {
        return size == capacity;
    }
    
    
    
    public static void main(String[] args) {
    	CicularQueue_03 cq = new CicularQueue_03(5);
    	cq.insertFront(10);
    	cq.insertLast(20);
    	cq.insertFront(30);
    	
    	cq.deleteFront();
    	
    	cq.isEmpty();
    	
    	cq.deleteLast();
	}
}
