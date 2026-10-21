package Week9;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    static void backtrack(char[] chars, int start, List<String> result) {
        if (start == chars.length) {
            result.add(new String(chars));
            return;
        }

        for (int i = start; i < chars.length; i++) {
            swap(chars, start, i);
            backtrack(chars, start + 1, result);
            swap(chars, start, i); // backtrack
        }
    }

    static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    static List<String> permute(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s.toCharArray(), 0, result);
        return result;
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println("Permutations of \"" + s + "\": " + permute(s));
    }
}
