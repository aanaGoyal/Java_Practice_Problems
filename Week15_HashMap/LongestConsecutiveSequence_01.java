package Week15_HashMap;
import java.util.HashSet;

public class LongestConsecutiveSequence_01 {
	static int longestConsecutive(int[] nums) {
        HashSet<Integer>set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }

        int longest = 0;
        for(int i:set){
            if(!set.contains(i-1)){
                int current = 0;
                while(set.contains(i)){
                    current ++;
                    i++;
                }
                longest = Math.max(longest, current);
            }
            
        }

        return longest;
    }
	
	
	public static void main(String[] args) {
		int[] nums = new int[]{100, 4, 200, 1, 3, 2};
		System.out.println(longestConsecutive(nums));
	}
}
