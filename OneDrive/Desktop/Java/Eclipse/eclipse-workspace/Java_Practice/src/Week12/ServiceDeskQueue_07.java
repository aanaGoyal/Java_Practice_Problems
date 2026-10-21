package Week12;

import java.util.LinkedList;
import java.util.Queue;

public class ServiceDeskQueue_07 {
	
	Queue<Integer>queue = new LinkedList<>();
	
	void JOIN(int x) {
		queue.add(x);
	}
	
	
	void SERVE() {
		if(queue.isEmpty()) {
			System.out.println("EMPTY");
			return;
		}
		System.out.println(queue.poll());
	}
	
	
	void CANCEL(int x) {
		if(queue.contains(x)) {
			queue.remove(x);
		}
	}
	
	public static void main(String[] args) {
		ServiceDeskQueue_07 sq1 = new ServiceDeskQueue_07();
		sq1.JOIN(41);
		sq1.JOIN(17);
		sq1.JOIN(29);
		sq1.CANCEL(17);
		sq1.SERVE();
		sq1.JOIN(53);
		sq1.SERVE();
		sq1.SERVE();
		System.out.println();
		
		ServiceDeskQueue_07 sq2 = new ServiceDeskQueue_07();
		sq2.SERVE();
		sq2.JOIN(8);
		sq2.CANCEL(8);
		sq2.SERVE();
		sq2.JOIN(3);
	}
}
