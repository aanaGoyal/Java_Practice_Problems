package Week12;

import java.util.ArrayDeque;
import java.util.Deque;

public class Deque_Based_Palindrome_Check_13 {
	Deque<Character>dq = new ArrayDeque<>();
	
	boolean checkPalindrome(String s) {
		
		for(int i=0; i<s.length(); i++) {
			if(Character.isLetter(s.charAt(i))) {
				dq.add(Character.toLowerCase(s.charAt(i)));
			}else if(Character.isDigit(s.charAt(i))){
				dq.add(s.charAt(i));
			}
		}
		
		while(!dq.isEmpty()) {
			char first = dq.pollFirst();
			char second = dq.pollLast();
			if(first != second) {
				return false;
			}
		}
		
		return true;
	}
	public static void main(String[] args) {
		String s1 = "Never odd, or even!";
		Deque_Based_Palindrome_Check_13 d1 = new Deque_Based_Palindrome_Check_13();
		boolean isPalindrome = d1.checkPalindrome(s1);
		if(isPalindrome) {
			System.out.println("PALINDROME");
		}else {
			System.out.println("NOT PALINDROME");
		}
		
		
		String s2 = "Queue at 5:15";
		Deque_Based_Palindrome_Check_13 d2 = new Deque_Based_Palindrome_Check_13();
		boolean isPalindrome1 = d2.checkPalindrome(s2);
		if(isPalindrome1) {
			System.out.println("PALINDROME");
		}else {
			System.out.println("NOT PALINDROME");
		}
	}
}
