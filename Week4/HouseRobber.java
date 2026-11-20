package Week4;

public class HouseRobber {

    public static int rob(int[] nums) {
        int prev1 = 0; // max money up to i-1
        int prev2 = 0; // max money up to i-2

        for (int num : nums) {
            int current = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println("Max amount that can be robbed: " + rob(nums));
    }
}
