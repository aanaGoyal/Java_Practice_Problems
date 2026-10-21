package Week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Week 3 - LeetCode 989: Add to Array-Form of Integer
 *
 * The array-form of an integer num is an array representing its digits
 * in left-to-right order. Given num in array form and an integer k,
 * return the array-form of num + k.
 *
 * Approach (simulate addition, like adding two numbers on paper):
 * Traverse the digit array from the last digit to the first, adding
 * digits of k along the way, carrying over as needed. Continue until
 * both the array and k (and any leftover carry) are exhausted.
 *
 * Time Complexity : O(max(n, log10(k)))
 * Space Complexity: O(max(n, log10(k))) for the result list
 */
public class AddToArrayFormOfInteger {

    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int i = num.length - 1;

        while (i >= 0 || k > 0) {
            int digitSum = k % 10;
            k /= 10;

            if (i >= 0) {
                digitSum += num[i];
                i--;
            }

            result.add(digitSum % 10);
            k += digitSum / 10; // carry propagates into k
        }

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 0, 0};
        int k1 = 34;
        System.out.println("num = [1,2,0,0], k = 34 -> " + addToArrayForm(num1, k1));
        // Expected: [1, 2, 3, 4]

        int[] num2 = {2, 7, 4};
        int k2 = 181;
        System.out.println("num = [2,7,4], k = 181 -> " + addToArrayForm(num2, k2));
        // Expected: [4, 5, 5]

        int[] num3 = {2, 1, 9};
        int k3 = 1000000;
        System.out.println("num = [2,1,9], k = 1000000 -> " + addToArrayForm(num3, k3));
        // Expected: [1, 0, 0, 0, 2, 1, 9]

        int[] num4 = {9, 9, 9};
        int k4 = 1;
        System.out.println("num = [9,9,9], k = 1 -> " + addToArrayForm(num4, k4));
        // Expected: [1, 0, 0, 0]
    }
}
