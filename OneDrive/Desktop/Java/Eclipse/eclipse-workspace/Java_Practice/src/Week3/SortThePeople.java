package Week3;

import java.util.Arrays;

public class SortThePeople {

    public static String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> heights[b] - heights[a]); // descending by height

        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = names[indices[i]];
        }

        return result;
    }

    public static void main(String[] args) {
        String[] names = {"Mary", "John", "Emma"};
        int[] heights = {180, 165, 170};
        System.out.println("Sorted names: " + Arrays.toString(sortPeople(names, heights)));
    }
}
