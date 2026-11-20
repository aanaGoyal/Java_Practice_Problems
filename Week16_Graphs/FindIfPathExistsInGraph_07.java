package Week16_Graphs;

import java.util.ArrayList;
import java.util.List;

public class FindIfPathExistsInGraph_07 {
    void dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;

        for(int neighbour : graph.get(node)) {

            if(!visited[neighbour]) {
                dfs(graph, visited, neighbour);
            }
        }
    }

    boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        dfs(graph, visited, source);

        return visited[destination];
    }

    public static void main(String[] args) {
    	FindIfPathExistsInGraph_07 obj = new FindIfPathExistsInGraph_07();
        int n = 6;

        int[][] edges = {
            {0, 1},
            {0, 2},
            {3, 5},
            {5, 4},
            {4, 3}
        };

        int source = 0;
        int destination = 2;
        boolean result = obj.validPath(n, edges, source, destination);
        System.out.println("Path Exists: " + result);
    }
}

