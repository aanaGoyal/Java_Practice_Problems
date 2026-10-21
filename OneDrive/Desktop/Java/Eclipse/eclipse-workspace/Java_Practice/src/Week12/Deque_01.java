package Week12;

import java.util.ArrayDeque;
import java.util.Deque;

public class Deque_01 {
	
	public static void main(String[] args) {
		  /** DEQUE OPERATIONS : */
	      Deque<Integer>dq = new ArrayDeque<>();
	      dq.addFirst(10);
	      System.out.println(dq);
	      dq.addFirst(20);
	      System.out.println(dq);
	      dq.addFirst(30);
	      System.out.println(dq);
	      
	      
	      /** REVERSE STRING : */
	      String s = "Hello";
	      Deque<Character> string = new ArrayDeque<>();
	      for(int i=0; i<s.length(); i++) {
	    	  string.addFirst(s.charAt(i));
	      }
	      
	      StringBuilder reverseString = new StringBuilder();
	      while(!string.isEmpty()) {
	    	  reverseString.append(string.removeFirst());
	      }
	      
	      System.out.println(reverseString);
	      
	      
	      
	      /** CHECK PALINDROME : */
	      boolean isPalindrome = s.equals(reverseString.toString());
	      System.out.println("Is palindrome: " + isPalindrome);
	}
}
