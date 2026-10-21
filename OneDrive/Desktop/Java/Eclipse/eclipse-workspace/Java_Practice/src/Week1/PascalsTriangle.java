package Week1;

import java.util.ArrayList;
import java.util.List;

/*
 * Week 3 - LeetCode 118: Pascal's Triangle
 *
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * Each number is the sum of the two numbers directly above it
 * (the first and last number of each row is always 1).
 *
 * Approach:
 * Build the triangle row by row. Each row starts and ends with 1.
 * Every inner element at position j equals the sum of element j-1
 * and element j from the previous row.
 *
 * Time Complexity : O(numRows^2)
 * Space Complexity: O(numRows^2) for the output
 */
public class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int row = 0; row < numRows; row++) {
            List<Integer> currentRow = new ArrayList<>();

            for (int col = 0; col <= row; col++) {
                if (col == 0 || col == row) {
                    currentRow.add(1); // edges of the triangle are always 1
                } else {
                    List<Integer> prevRow = triangle.get(row - 1);
                    currentRow.add(prevRow.get(col - 1) + prevRow.get(col));
                }
            }

            triangle.add(currentRow);
        }

        return triangle;
    }

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> triangle = generate(numRows);

        System.out.println("Pascal's Triangle with " + numRows + " rows:");
        for (List<Integer> row : triangle) {
            System.out.println(row);
        }
        // Expected:
        // [1]
        // [1, 1]
        // [1, 2, 1]
        // [1, 3, 3, 1]
        // [1, 4, 6, 4, 1]

        System.out.println("\nPascal's Triangle with 1 row:");
        System.out.println(generate(1));
        // Expected: [[1]]
    }
}
