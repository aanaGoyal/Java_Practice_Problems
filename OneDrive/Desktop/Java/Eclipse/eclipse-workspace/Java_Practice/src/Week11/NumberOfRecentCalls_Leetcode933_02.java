package Week11;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls_Leetcode933_02 {
	
	static class RecentCounter{
		Queue<Integer> queue;
		
		RecentCounter(){
			queue = new LinkedList();
		}
		
		int ping(int t) {
			queue.add(t);
			
			int lower_bound = t - 3000;
			while(queue.peek() > lower_bound) {
				queue.poll();
			}
			
			return queue.size();
		}
	}
	
	
	public static void main(String[] args) {
		
	}
}
