package Week16_Graphs;

public class FillFlood_01 {
    void dfs(int[][] image, int sr, int sc, int originalColor, int newColor) {
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) {
            return;
        }

        if(image[sr][sc] != originalColor) {
            return;
        }

        image[sr][sc] = newColor;
        dfs(image, sr-1, sc, originalColor, newColor);
        dfs(image, sr+1, sc, originalColor, newColor);
        dfs(image, sr, sc-1, originalColor, newColor);
        dfs(image, sr, sc+1, originalColor, newColor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if(originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);
        return image;
    }
    
    public static void main(String[] args) {
        FillFlood_01 obj = new FillFlood_01();
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sr = 1;
        int sc = 1;
        int color = 2;

        int[][] result = obj.floodFill(image, sr, sc, color);
        for(int i = 0; i < result.length; i++) {

            for(int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }

            System.out.println();
        }
    }
}
