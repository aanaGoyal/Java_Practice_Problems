package Week1;

/*
 * Week 3 - General Question 2
 * Fixed-Size Sliding Window: Maximum Vowels in a Substring of length K
 * (Same pattern as LeetCode 1456: Maximum Number of Vowels in a Substring of Given Length)
 *
 * Approach:
 * 1. Count vowels in the first window of size k.
 * 2. Slide the window: when a character enters, add 1 if it's a vowel;
 *    when a character leaves, subtract 1 if it was a vowel.
 * 3. Track the maximum vowel count across all windows.
 *
 * Time Complexity : O(n)
 * Space Complexity: O(1)
 */
public class MaxVowelsFixedWindow {

    private static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static int maxVowels(String s, int k) {
        if (s == null || s.length() < k || k <= 0) {
            throw new IllegalArgumentException("Invalid string or window size");
        }

        int windowVowelCount = 0;

        // Count vowels in the first window
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                windowVowelCount++;
            }
        }

        int maxVowelCount = windowVowelCount;

        // Slide the window across the rest of the string
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                windowVowelCount++;                 // new char entering
            }
            if (isVowel(s.charAt(i - k))) {
                windowVowelCount--;                 // old char leaving
            }
            maxVowelCount = Math.max(maxVowelCount, windowVowelCount);
        }

        return maxVowelCount;
    }

    public static void main(String[] args) {
        String s1 = "abciiidef";
        int k1 = 3;
        System.out.println("String: \"" + s1 + "\", k = " + k1);
        System.out.println("Max vowels = " + maxVowels(s1, k1)); // Expected: 3 ("iii")

        String s2 = "aeiou";
        int k2 = 2;
        System.out.println("\nString: \"" + s2 + "\", k = " + k2);
        System.out.println("Max vowels = " + maxVowels(s2, k2)); // Expected: 2

        String s3 = "leetcode";
        int k3 = 3;
        System.out.println("\nString: \"" + s3 + "\", k = " + k3);
        System.out.println("Max vowels = " + maxVowels(s3, k3)); // Expected: 2
    }
}
