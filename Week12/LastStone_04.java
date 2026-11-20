package Week12;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStone_04 {
	
	/** Problem : 
		You are given an array of integers stones where stones[i] is the weight of the ith stone.
		
		We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest 
		two stones have weights x and y with x <= y. The result of this smash is:
		
		If x == y, both stones are destroyed, and
		If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
		At the end of the game, there is at most one stone left.
		
		Return the weight of the last remaining stone. If there are no stones left, return 0.
*/
	
	static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<stones.length; i++){
            pq.add(stones[i]);
        }

        while(!pq.isEmpty() && pq.size() != 1){
            int num1 = pq.poll();
            int num2 = pq.poll();
            if(num1 != num2){
                pq.add(num1 - num2);
            }
        }

        if(pq.isEmpty()){
            return 0;
        }
        
        return pq.peek();
    }
	
	
	public static void main(String[] args) {
		int stones[] = {2,7,4,1,8,1};
		System.out.println(lastStoneWeight(stones));
	}
}
