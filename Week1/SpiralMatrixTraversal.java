package Week1;

import java.util.ArrayList;
import java.util.List;

/*
 * Week 3 - General Question 5
 * Spiral Matrix Traversal
 * (Same pattern as LeetCode 54: Spiral Matrix)
 *
 * Approach:
 * Maintain four boundaries: top, bottom, left, right.
 * Traverse right along the top row, down along the right column,
 * left along the bottom row, and up along the left column,
 * shrinking the boundaries after each pass, until all elements
 * are visited.
 *
 * Time Complexity : O(m * n)
 * Space Complexity: O(m * n) for the output list
 */
public class SpiralMatrixTraversal {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            // Traverse from left to right along the top row
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++;

            // Traverse from top to bottom along the right column
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--;

            // Traverse from right to left along the bottom row (if still valid)
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--;
            }

            // Traverse from bottom to top along the left column (if still valid)
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("3x3 Matrix spiral order: " + spiralOrder(matrix1));
        // Expected: [1, 2, 3, 6, 9, 8, 7, 4, 5]

        int[][] matrix2 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        System.out.println("3x4 Matrix spiral order: " + spiralOrder(matrix2));
        // Expected: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
    }
}
