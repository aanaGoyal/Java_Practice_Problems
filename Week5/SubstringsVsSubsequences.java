package Week5;

import java.util.ArrayList;
import java.util.List;

public class SubstringsVsSubsequences {

    // Substrings are contiguous parts of the string
    public static List<String> generateSubstrings(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                result.add(s.substring(i, j));
            }
        }
        return result;
    }

    // Subsequences don't need to be contiguous, order is preserved
    public static List<String> generateSubsequences(String s) {
        List<String> result = new ArrayList<>();
        subsequenceHelper(s, 0, new StringBuilder(), result);
        return result;
    }

    private static void subsequenceHelper(String s, int index, StringBuilder current, List<String> result) {
        if (index == s.length()) {
            if (current.length() > 0) {
                result.add(current.toString());
            }
            return;
        }

        current.append(s.charAt(index));
        subsequenceHelper(s, index + 1, current, result); // include char
        current.deleteCharAt(current.length() - 1);

        subsequenceHelper(s, index + 1, current, result); // exclude char
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println("Substrings of \"" + s + "\": " + generateSubstrings(s));
        System.out.println("Subsequences of \"" + s + "\": " + generateSubsequences(s));
    }
}
