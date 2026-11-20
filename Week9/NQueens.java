package Week9;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] queens = new int[n]; // queens[row] = column of queen in that row
        backtrack(queens, 0, n, result);
        return result;
    }

    static void backtrack(int[] queens, int row, int n, List<List<String>> result) {
        if (row == n) {
            result.add(buildBoard(queens, n));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(queens, row, col)) {
                queens[row] = col;
                backtrack(queens, row + 1, n, result);
            }
        }
    }

    static boolean isSafe(int[] queens, int row, int col) {
        for (int prevRow = 0; prevRow < row; prevRow++) {
            int prevCol = queens[prevRow];
            if (prevCol == col || Math.abs(prevCol - col) == Math.abs(prevRow - row)) {
                return false; // same column or same diagonal
            }
        }
        return true;
    }

    static List<String> buildBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < n; col++) {
                sb.append(queens[row] == col ? 'Q' : '.');
            }
            board.add(sb.toString());
        }
        return board;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> solutions = solveNQueens(n);

        System.out.println("Total solutions for " + n + "-Queens: " + solutions.size());
        System.out.println("First solution:");
        for (String row : solutions.get(0)) {
            System.out.println(row);
        }
    }
}
