package Week16_Graphs;

public class SurroundingRegions_05 {
    void dfs(char[][] board, int r, int c) {
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return;
        }

        if(board[r][c] != 'O') {
            return;
        }

        board[r][c] = '#';
        dfs(board, r-1, c);
        dfs(board, r+1, c);
        dfs(board, r, c-1);
        dfs(board, r, c+1);
    }

    void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O') {
                dfs(board, i, 0);
            }

            if(board[i][n-1] == 'O') {
                dfs(board, i, n-1);
            }
        }

        for(int j = 0; j < n; j++) {
            if(board[0][j] == 'O') {
                dfs(board, 0, j);
            }

            if(board[m-1][j] == 'O') {
                dfs(board, m-1, j);
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void main(String[] args) {
        SurroundingRegions_05 obj = new SurroundingRegions_05();

        char[][] board = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };

        obj.solve(board);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }
    }
}

