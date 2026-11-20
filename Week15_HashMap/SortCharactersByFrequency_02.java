package Week15_HashMap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class SortCharactersByFrequency_02 {
	/** LEETCODE 451 */
	
	static String frequencySort(String s) {
        HashMap<Character,Integer>map = new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Character>pq = new PriorityQueue<>(
            (a,b) -> map.get(b) - map.get(a)
        );

        pq.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            char ch = pq.poll();
            int count = map.get(ch);
            while(count-- != 0){
                sb.append(ch);
            }
        }

        return sb.toString();

    }
	
	
	public static void main(String[] args) {
		String s = "tree";
		System.out.println(frequencySort(s));
	}
}
