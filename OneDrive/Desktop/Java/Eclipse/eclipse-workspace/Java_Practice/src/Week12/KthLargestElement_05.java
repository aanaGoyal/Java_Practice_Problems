package Week12;

import java.util.PriorityQueue;

public class KthLargestElement_05 {
	
	static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>pq = new PriorityQueue<>();

//        for(int i=0; i<k; i++){
//            pq.add(nums[i]);
//        }
//
//        for(int i=k; i<nums.length; i++){
//            pq.add(nums[i]);
//            pq.poll();
//        }
//
//        return pq.peek();
        
        
        for(int i=0; i<nums.length; i++) {
        	pq.add(nums[i]);
        	if(pq.size() > k) {
        		pq.poll();
        	}
        }
        
        return pq.peek();
    }
	
	
	
	public static void main(String[] args) {
		int nums[] = {3,2,1,5,6,4};
		int k = 2;
		System.out.println(findKthLargest(nums, k));
	}
}
