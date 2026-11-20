package Week16_Graphs;

public class MaxAreaOfIsland_04 {
    int dfs(int[][] grid, int r, int c) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) {
            return 0;
        }

        if(grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;
        int area = 1;

        area += dfs(grid, r-1, c);
        area += dfs(grid, r+1, c);
        area += dfs(grid, r, c-1);
        area += dfs(grid, r, c+1);
        return area;
    }

    int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland_04 obj = new MaxAreaOfIsland_04();

        int[][] grid = {
            {0, 0, 1, 0},
            {1, 1, 1, 0},
            {0, 1, 0, 0},
            {0, 0, 0, 1}
        };

        int result = obj.maxAreaOfIsland(grid);
        System.out.println("Maximum Area of Island: " + result);
    }
}
