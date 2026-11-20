package Week15_HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopK_FrequentWords_03 {
	/** LEETCODE 692 */
	
	static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer>map = new HashMap<>();
        for(String s:words){
            map.put(s, map.getOrDefault(s,0)+1);
        }

        PriorityQueue<String>pq = new PriorityQueue<>(
            (a,b) -> {if(map.get(a).equals(map.get(b))){
                return a.compareTo(b);
            }
            return map.get(b) - map.get(a);}
        );

        pq.addAll(map.keySet());
        List<String>ans = new ArrayList<>();
        for(int i=0; i<k; i++){
            String s = pq.poll();
            ans.add(s);
        }

        return ans;
    }
	
	
	public static void main(String[] args) {
		String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
		int k = 2;
		System.out.println(topKFrequent(words, k));
	}
}
