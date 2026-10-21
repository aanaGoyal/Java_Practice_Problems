package Week10;

import java.util.Arrays;

public class SecondLargest_1 {
	
	static void fibonacciSeries(int n) {
		int a = 0;
		int b = 1;
		if(n == 0) {
			System.out.println(0);
			return;
		}
		
		for(int i=1; i<=n; i++) {
			System.out.print(a + " ");
			int temp = a + b;
			a = b;
			b = temp;
		}
		
	}
	
	static boolean isPrime(int n) {
		if(n<=1) {
			return true;
		}
		
		for(int i=2; i*i<=n; i++) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	static void primeNumbers(int n) {
		for(int i=2; i<=n; i++) {
			if(isPrime(i)) {
				System.out.print(i + " ");
			}
		}
	}
	
	
	static void reverseNumber(int n) {
		int reversed = 0;
		int count = 0;
		while(n > 0) {
			int remainder = n%10;
			reversed = (reversed * 10) + remainder;
			n/=10;
			count++;
		}
		
		System.out.println(reversed);
		System.out.println(count);
	}
	
	static void countVowels(String s) {
		int countVowels = 0;
		int countConsonants = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'o' || s.charAt(i) == 'u' || s.charAt(i) == 'i') {
				countVowels ++;
			}else {
				countConsonants++;
			}
		}
		
		System.out.println("Vowels: "+ countVowels);
		System.out.println("Consonants: "+ countConsonants);
	}
	
	static void toggleCharacters(String str) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<str.length(); i++) {
			if(Character.isUpperCase(str.charAt(i))) {
				sb.append(Character.toLowerCase(str.charAt(i)));
			}else {
				sb.append(Character.toUpperCase(str.charAt(i)));
			}
		}
		
		System.out.println(sb.toString());
	}
	
	static void fun1(int n) {
		for(int i=1; i<=n; i++) {
			if(i<=3) {
				for(int j=1; j<=i; j++) {
					System.out.print(j + " ");
				}
			}else {
				for(int j=i; j>=1; j--) {
					System.out.print(j + " ");
				}
			}
			System.out.println();
		}
	}
	
	static void joinString(String str) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) != ' ') {
				sb.append(str.charAt(i));
			}
		}
		System.out.println(sb.toString());
	}
	
	
	public static void main(String[] args) {
		int arr[] = {-1,0,-11,7,2,-44,6};
		Arrays.sort(arr);
		System.out.println(arr[arr.length - 2]);
		
		int arr1[] = {0,1,2,3,4,5,6};
		for(int i=0; i<arr1.length; i++) {
			if(i%2 == 0) {
				System.out.print(arr1[i] + " ");
			}
		}
		
		System.out.println();
		fibonacciSeries(5);
		System.out.println();
		primeNumbers(10);
		System.out.println();
		reverseNumber(12345);
		System.out.println();
		countVowels("aana");
		System.out.println();
		toggleCharacters("JaVa");
		System.out.println();
		fun1(5);
		System.out.println();
		joinString("My name is Aana");
	}
}
