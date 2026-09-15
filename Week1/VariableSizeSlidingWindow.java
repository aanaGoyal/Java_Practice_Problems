package Week1;

/*
 * Week 3 - General Question 3
 * Variable-Sized Sliding Window: Complex Continuous Subarray Constraints
 *
 * This file demonstrates the variable-size (expand/shrink) sliding window
 * pattern with TWO classic constraint-based problems:
 *
 *   (A) Longest subarray with sum <= target
 *       -> window EXPANDS with right pointer, SHRINKS from left while
 *          the sum constraint is violated.
 *
 *   (B) Longest subarray containing at most K zeros
 *       (equivalent to "Max Consecutive Ones III": you may flip at most K
 *        zeros to 1; find the longest run of 1s achievable)
 *       -> window EXPANDS with right pointer, SHRINKS from left while
 *          the "too many zeros" constraint is violated.
 *
 * General Template:
 *   left = 0
 *   for right in [0, n):
 *       include arr[right] in the window
 *       while (window violates constraint):
 *           remove arr[left] from window
 *           left++
 *       update answer using current window [left, right]
 *
 * Time Complexity : O(n)  -> each pointer moves forward at most n times
 * Space Complexity: O(1)
 */
public class VariableSizeSlidingWindow {

    // (A) Longest subarray with sum <= target
    public static int longestSubarraySumAtMost(int[] arr, int target) {
        int left = 0, sum = 0, maxLen = 0;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            // Shrink window from the left while sum exceeds target
            while (sum > target && left <= right) {
                sum -= arr[left];
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    // (B) Longest subarray with at most K zeros (Max Consecutive Ones III)
    public static int longestSubarrayAtMostKZeros(int[] arr, int k) {
        int left = 0, zeroCount = 0, maxLen = 0;

        for (int right = 0; right < arr.length; right++) {
            if (arr[right] == 0) {
                zeroCount++;
            }

            // Shrink window from the left while zero count exceeds k
            while (zeroCount > k) {
                if (arr[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        // Test (A)
        int[] arrA = {2, 1, 4, 3, 5};
        int target = 8;
        System.out.println("(A) Array: [2, 1, 4, 3, 5], target sum <= " + target);
        System.out.println("Longest subarray length = " + longestSubarraySumAtMost(arrA, target));
        // Expected: 3 -> [1,4,3] or similar sums to <=8

        // Test (B)
        int[] arrB = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println("\n(B) Array: [1,1,1,0,0,0,1,1,1,1,0], at most k = " + k + " zeros");
        System.out.println("Longest subarray length = " + longestSubarrayAtMostKZeros(arrB, k));
        // Expected: 6 -> [1,1,1,0,0,1,1,1,1] window handling gives 6

        int[] arrB2 = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k2 = 3;
        System.out.println("\n(B) Longer test array, at most k = " + k2 + " zeros");
        System.out.println("Longest subarray length = " + longestSubarrayAtMostKZeros(arrB2, k2));
        // Expected: 10
    }
}
