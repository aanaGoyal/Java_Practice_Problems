package Week11;

public class CircularQueueUsingArray {

    int arr[];
    int front = 0;
    int rear = -1;
    int size = 0;
    int capacity;

    
    CircularQueueUsingArray(int capacity){
        this.capacity = capacity;
        arr = new int[capacity];
    }
    
    

    boolean isEmpty(){
        return size == 0;
    }

    
    
    boolean isFull(){
        return size == capacity;
    }

    void offer(int value){
        if(isFull()){
            System.out.println("Queue is Full");
            return;
        }

        rear = (rear + 1) % capacity;
        arr[rear] = value;
        size++;
    }

    
    
    int poll(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }

        int value = arr[front];
        front = (front + 1) % capacity;
        size--;

        return value;
    }

    
    int front(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }

        return arr[front];
    }
    
    

    int rear(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }

        return arr[rear];
    }

    
    
    public static void main(String[] args) {
    	CircularQueueUsingArray q = new CircularQueueUsingArray(3);
        q.offer(10);
        q.offer(20);
        q.offer(30);

        System.out.println(q.poll());  
        q.offer(40);                    
        System.out.println(q.rear());   
        System.out.println(q.front());  
        System.out.println(q.isFull());
    }
}
