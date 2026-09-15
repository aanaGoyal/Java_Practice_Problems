package Week2;

public class CountSubarraysSumLimit {

    public static int countSubarrays(int[] nums, int limit) {
        int left = 0, sum = 0, count = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum > limit) {
                sum -= nums[left];
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 3, 5};
        int limit = 8;
        System.out.println("Count of valid subarrays: " + countSubarrays(nums, limit));
    }
}
