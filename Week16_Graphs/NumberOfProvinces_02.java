package Week16_Graphs;

public class NumberOfProvinces_02 {
    void dfs(int[][] isConnected, boolean[] visited, int city) {
        visited[city] = true;

        for(int i = 0; i < isConnected.length; i++) {
            if(isConnected[city][i] == 1 && !visited[i]) {
                dfs(isConnected, visited, i);
            }
        }
    }

    int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                count++;
                dfs(isConnected, visited, i);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfProvinces_02 obj = new NumberOfProvinces_02();
        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };

        int result = obj.findCircleNum(isConnected);
        System.out.println("Number of Provinces: " + result);
    }
}

