package Week1;

/*
 * Week 3 - General Question 1
 * Fixed-Size Sliding Window: Maximum Sum of a Subarray of size K
 *
 * Approach:
 * 1. Compute the sum of the first window of size k.
 * 2. Slide the window one element at a time: add the new element entering
 *    the window and subtract the element leaving the window.
 * 3. Track the maximum sum seen across all windows.
 *
 * Time Complexity : O(n)
 * Space Complexity: O(1)
 */
public class MaxSubarraySumFixedWindow {

    public static int maxSumFixedWindow(int[] arr, int k) {
        if (arr == null || arr.length < k || k <= 0) {
            throw new IllegalArgumentException("Invalid array or window size");
        }

        int windowSum = 0;

        // Sum of the first window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        // Slide the window across the rest of the array
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];   // add new element, remove old element
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 1, 5, 1, 3, 2};
        int k1 = 3;
        System.out.println("Array: [2, 1, 5, 1, 3, 2], k = 3");
        System.out.println("Maximum sum of window size " + k1 + " = " + maxSumFixedWindow(arr1, k1));
        // Expected: 5+1+3 = 9

        int[] arr2 = {100, 200, 300, 400};
        int k2 = 2;
        System.out.println("\nArray: [100, 200, 300, 400], k = 2");
        System.out.println("Maximum sum of window size " + k2 + " = " + maxSumFixedWindow(arr2, k2));
        // Expected: 300+400 = 700

        int[] arr3 = {1, -2, 3, -4, 5, -6, 7};
        int k3 = 4;
        System.out.println("\nArray: [1, -2, 3, -4, 5, -6, 7], k = 4");
        System.out.println("Maximum sum of window size " + k3 + " = " + maxSumFixedWindow(arr3, k3));
    }
}
