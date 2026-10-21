package Week12;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Priority_Based_Lab_Access_12 {
	HashMap<String, Integer>map = new HashMap<>();
	
	PriorityQueue<String> pq = new PriorityQueue<>(
			(a,b) -> map.get(a) - map.get(b));
	
	void REQUEST(String id, int priority) {
		map.put(id, priority);
		
		pq.add(id);
	}
	
	void NEXT() {
		if(pq.isEmpty()) {
			System.out.println("EMPTY");
			return;
		}
		
		System.out.println(pq.poll());
	}
	
	public static void main(String[] args) {
		Priority_Based_Lab_Access_12 pb1 = new Priority_Based_Lab_Access_12();
		pb1.REQUEST("A12", 3);
		pb1.REQUEST("B07", 1);
		pb1.REQUEST("C21", 1);
		pb1.NEXT();
		pb1.REQUEST("D15", 2);
		pb1.NEXT();
		pb1.NEXT();
	}
}	
