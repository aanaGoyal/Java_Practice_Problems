package Week11;

public class QueueUsingStacks{
	int s1[];
    int s2[];
    int top1 = -1;
    int top2 = -1;
    int capacity;

    QueueUsingStacks(int size){
        capacity = size;
        s1 = new int[size];
        s2 = new int[size];
    }
    
    

    void enqueue(int value){
        if (top1 == capacity - 1) {
            System.out.println("Queue is Full");
            return;
        }
        s1[++top1] = value;
    }
    
    

    int dequeue(){
        if(top1 == -1 && top2 == -1){
            System.out.println("Queue is Empty");
            return -1;
        }

        if(top2 == -1){
            while (top1 != -1){
                s2[++top2] = s1[top1--];
            }
        }
        return s2[top2--];
    }

    
    
    int peek() {
        if(top1 == -1 && top2 == -1){
            System.out.println("Queue is Empty");
            return -1;
        }

        if(top2 == -1){
            while (top1 != -1) {
                s2[++top2] = s1[top1--];
            }
        }
        return s2[top2];
    }

    
    
    boolean isEmpty(){
        return top1 == -1 && top2 == -1;
    }

    public static void main(String[] args) {
    	QueueUsingStacks q = new QueueUsingStacks(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println(q.dequeue()); 
        System.out.println(q.peek());    
        System.out.println(q.dequeue()); 
        System.out.println(q.isEmpty()); 
    }
}
