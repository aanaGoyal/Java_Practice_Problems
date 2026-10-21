package Week2;

public class FirstLastOccurrence {

    public static int findFirst(int[] arr, int target) {
        int low = 0, high = arr.length - 1, result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                result = mid;
                high = mid - 1; // keep searching left side
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    public static int findLast(int[] arr, int target) {
        int low = 0, high = arr.length - 1, result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                result = mid;
                low = mid + 1; // keep searching right side
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    public static int countFrequency(int[] arr, int target) {
        int first = findFirst(arr, target);
        if (first == -1) {
            return 0;
        }
        int last = findLast(arr, target);
        return last - first + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 4, 5};
        int target = 2;

        System.out.println("First occurrence: " + findFirst(arr, target));
        System.out.println("Last occurrence: " + findLast(arr, target));
        System.out.println("Frequency: " + countFrequency(arr, target));
    }
}
