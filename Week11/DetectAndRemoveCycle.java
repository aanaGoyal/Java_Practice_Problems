package Week11;

public class DetectAndRemoveCycle {
	Node head;
	Node tail;
	
	DetectAndRemoveCycle(){
		this.head = null;
		this.tail = null;
	}
	
	void add(int value) {
		Node newNode = new Node(value);
		if(head == null) {
			head = newNode;
		}else {
			tail.next = newNode;
		}
		tail = newNode;
		tail.next = head;
	}
	
	void display() {
		Node current = head;
		while(current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}
	
	
	void containsCycle() {
		Node slow = head;
		Node fast = head;
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				break;
			}
		}
		
		if(fast==null || fast.next ==null) {
			System.out.println("Contains Cycle");
		}
		
		slow = head;
		if(slow == fast){
            while(fast.next != slow){
                fast = fast.next;
            }
        }else{
            while(slow.next != fast.next){
                slow = slow.next;
                fast = fast.next;
            }
            fast = fast;
        }
		
		fast.next = null;
	}
	
	public static void main(String[] args) {
		DetectAndRemoveCycle linkedList1 = new DetectAndRemoveCycle();
		linkedList1.add(1);
		linkedList1.add(2);
		linkedList1.add(3);
		linkedList1.add(4);
		linkedList1.add(5);
//		linkedList1.display();
		linkedList1.containsCycle();
		linkedList1.display();
		
		
		// Time Complexity : O(n)
		// Space Complexity: O(1)
	}
}
