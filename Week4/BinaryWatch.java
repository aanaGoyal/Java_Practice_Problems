package Week4;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    result.add(String.format("%d:%02d", h, m));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int turnedOn = 1;
        System.out.println("Possible times: " + readBinaryWatch(turnedOn));
    }
}
