package Week16_Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Keys_and_Rooms_06 {
    void dfs(List<List<Integer>> rooms, boolean[] visited, int room) {
        visited[room] = true;
        for(int key : rooms.get(room)) {
            if(!visited[key]) {
                dfs(rooms, visited, key);
            }
        }
    }

    boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms, visited, 0);

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Keys_and_Rooms_06 obj = new Keys_and_Rooms_06();
        List<List<Integer>> rooms = new ArrayList<>();

        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(new ArrayList<>());

        boolean result = obj.canVisitAllRooms(rooms);
        System.out.println("Can Visit All Rooms: " + result);
    }
}

