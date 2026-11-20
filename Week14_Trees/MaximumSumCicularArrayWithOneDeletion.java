package Week14_Trees;

public class MaximumSumCicularArrayWithOneDeletion {

    static long maximumSumCircularArray(int arr[]) {
        long withDelete = Long.MIN_VALUE / 4;
        long noDelete = arr[0];
        long maxSumWithoutCircular = arr[0];

        
        for (int i = 1; i < arr.length; i++) {
            long num = arr[i];

            long deleteCurrent = Math.max(noDelete, withDelete + num);
            long takeCurrent = Math.max(num, noDelete + num);

            noDelete = takeCurrent;
            withDelete = deleteCurrent;

            maxSumWithoutCircular = Math.max(
                maxSumWithoutCircular,
                Math.max(withDelete, noDelete)
            );
        }

        if (arr.length == 1) {
            return maxSumWithoutCircular;
        }

        
        
        long totalSum = 0;
        long minEnding = arr[0];
        long minSum = arr[0];

        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];

            if (i > 0) {
                minEnding = Math.min(arr[i], minEnding + arr[i]);
                minSum = Math.min(minSum, minEnding);
            }
        }

        
        long circularSum = totalSum - minSum;
        if (circularSum == 0 && minSum == totalSum) {
            return maxSumWithoutCircular;
        }
        return Math.max(maxSumWithoutCircular, circularSum);
    }

    
    public static void main(String[] args) {
        int arr[] = {5, -3, 5, -2, 4};
        System.out.println(maximumSumCircularArray(arr));
        
     // Explanation: 
     // 1. First, we find the maximum sum of a normal subarray with at most one deletion.
	 //      noDelete = maximum sum ending at the current index without deleting any element.
	 //      withDelete = maximum sum ending at the current index when one deletion is allowed.
	 // 2. For every element, we have two choices:
	 //      (a). We can start a new subarray from the current element.
	 //      (b). We can add the current element to the previous subarray.
	 // 3. If one deletion is allowed, we can either:
	 //      (a). Delete the current element and keep the previous sum.
     //      (b). Use the deletion earlier and include the current element.
	 // 4. We update noDelete and withDelete for every element and keep updating maxSumWithoutCircular to store the maximum sum found.
	 // 5. Since the array is circular, a subarray can also start from the end of the array and continue from the beginning.
	 // 6. We need to consider both normal and circular subarrays and ensure that at least one element remains after deletion.
	 // 7. At last, we return the maximum possible sum.
     // Time Complexity: O(n)
	 // Space Complexity: O(1)

    }
}
