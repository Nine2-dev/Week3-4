import java.util.*;

public class AccountSearch {

    static int linearComparisons = 0;
    static int binaryComparisons = 0;

    // 🔹 Linear Search (First Occurrence)
    public static int linearFirst(String[] arr, String target) {
        linearComparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            linearComparisons++;
            if (arr[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    // 🔹 Linear Search (Last Occurrence)
    public static int linearLast(String[] arr, String target) {
        int index = -1;

        for (int i = 0; i < arr.length; i++) {
            linearComparisons++;
            if (arr[i].equals(target)) {
                index = i;
            }
        }
        return index;
    }

    // 🔹 Binary Search (Find any occurrence)
    public static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        binaryComparisons = 0;

        while (low <= high) {
            binaryComparisons++;
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                return mid;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // 🔹 Count occurrences using binary search
    public static int countOccurrences(String[] arr, String target) {
        int first = firstOccurrence(arr, target);
        int last = lastOccurrence(arr, target);

        if (first == -1) return 0;
        return last - first + 1;
    }

    private static int firstOccurrence(String[] arr, String target) {
        int low = 0, high = arr.length - 1, result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                result = mid;
                high = mid - 1;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private static int lastOccurrence(String[] arr, String target) {
        int low = 0, high = arr.length - 1, result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                result = mid;
                low = mid + 1;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        System.out.println("Original Logs: " + Arrays.toString(logs));

        // 🔹 Linear Search
        int first = linearFirst(logs, "accB");
        int last = linearLast(logs, "accB");

        System.out.println("\nLinear Search:");
        System.out.println("First occurrence of accB: " + first);
        System.out.println("Last occurrence of accB: " + last);
        System.out.println("Comparisons: " + linearComparisons);

        // 🔹 Sort for Binary Search
        Arrays.sort(logs);
        System.out.println("\nSorted Logs: " + Arrays.toString(logs));

        // 🔹 Binary Search
        int index = binarySearch(logs, "accB");
        int count = countOccurrences(logs, "accB");

        System.out.println("\nBinary Search:");
        System.out.println("Index of accB: " + index);
        System.out.println("Count of accB: " + count);
        System.out.println("Comparisons: " + binaryComparisons);
    }
}