package Week14_Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingNumberSlidingWindow {
	
	static void firstNonRepeatingSlidingWindow(int arr[], int k) {
		HashMap<Integer,Integer>map = new HashMap<>();
		Queue<Integer>queue = new LinkedList<>();
		
		for(int i=0; i<k; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
			queue.add(arr[i]);
		}
		
		
		for(int i=0; i<=arr.length-k; i++) {
			while (!queue.isEmpty() && (queue.peek() < i || map.get(arr[queue.peek()]) > 1)) {
	                queue.poll();
	        }

			if (queue.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(arr[queue.peek()] + " ");
            }

			
            if (i + k < arr.length) {
                int removed = arr[i];
                map.put(removed, map.get(removed) - 1);

                int added = arr[i + k];
                map.put(added, map.getOrDefault(added, 0) + 1);
                queue.add(i + k);
            }    
		}
	}
	
	
	public static void main(String[] args) {
		int arr[] = {1,2,1,3,2,4,4,5};
		int k = 4;
		firstNonRepeatingSlidingWindow(arr, k);
		
		// Explanation:
		// We use a HashMap to store the frequency of each element in the current window and a Queue to track elements in order.
		// For every window, we remove repeating or out-of-window elements from the Queue and print the first non-repeating element, or -1 if none exists.
	}
}
