package Week11;


class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next = null;
	}
}


public class ReverseNodesInKGroups {
	Node head;
	Node tail;
	
	ReverseNodesInKGroups(){
		this.head = null;
		this.tail = null;
	}
	
	void add(int value) {
		Node newNode = new Node(value);
		if(head == null) {
			head = newNode;
			tail = newNode;
		}else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	void display() {
		Node current = head;
		while(current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}
	
	void reverse(Node head) {
		Node current = head;
		Node prev = null;
		while(current!=null) {
			Node nextNode = current.next;
			current.next = prev;
			prev = current;
			current = nextNode;
		}
		
	}
	
	void reverseNodesInGroups(int k) {
		if (head == null || k <= 1) {
            return;
        }

        Node current = head;
        Node prevGroupTail = null;

        while(current != null){
            Node kthNode = current;

            for(int i = 1; i < k; i++){
                if (kthNode.next == null) {
                    return;
                }
                kthNode = kthNode.next;
            }
            
            
            Node nextGroup = kthNode.next;
            Node groupHead = current;
            Node prev = nextGroup;

            while(current != nextGroup){
                Node nextNode = current.next;
                current.next = prev;
                prev = current;
                current = nextNode;
            }

            
            
            if(prevGroupTail == null){
                head = kthNode;
            } else {
                prevGroupTail.next = kthNode;
            }

            prevGroupTail = groupHead;
            current = nextGroup;
        }

        tail = prevGroupTail;
	}
	
	
	
	public static void main(String[] args) {
		ReverseNodesInKGroups linkedList1 = new ReverseNodesInKGroups();
		linkedList1.add(1);
		linkedList1.add(2);
		linkedList1.add(3);
		linkedList1.add(4);
		linkedList1.add(5);
		linkedList1.add(6);
		linkedList1.add(7);
		linkedList1.add(8);
		linkedList1.display();
		
		int k = 3;
		linkedList1.reverseNodesInGroups(k);
        System.out.println("After reversing:");
        linkedList1.display();
	}
}
