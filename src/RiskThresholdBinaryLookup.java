import java.util.*;

public class RiskThresholdLookup {

    static int linearComparisons = 0;
    static int binaryComparisons = 0;

    // 🔹 Linear Search (unsorted)
    public static boolean linearSearch(int[] arr, int target) {
        linearComparisons = 0;

        for (int value : arr) {
            linearComparisons++;
            if (value == target) {
                return true;
            }
        }
        return false;
    }

    // 🔹 Binary Search (find insertion point)
    public static int binaryInsertionPoint(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        binaryComparisons = 0;

        while (low <= high) {
            binaryComparisons++;
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low; // insertion point
    }

    // 🔹 Floor (largest ≤ target)
    public static int findFloor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int floor = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return arr[mid];
            } else if (arr[mid] < target) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return floor;
    }

    // 🔹 Ceiling (smallest ≥ target)
    public static int findCeiling(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ceil = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return arr[mid];
            } else if (arr[mid] > target) {
                ceil = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ceil;
    }

    public static void main(String[] args) {

        int[] risks = {10, 25, 50, 100};
        int target = 30;

        // 🔹 Linear Search (unsorted simulation)
        int[] unsorted = {50, 10, 100, 25};
        boolean found = linearSearch(unsorted, target);

        System.out.println("Linear Search:");
        System.out.println("Threshold " + target + " found: " + found);
        System.out.println("Comparisons: " + linearComparisons);

        // 🔹 Binary Search (sorted array)
        System.out.println("\nBinary Search:");

        int insertionPoint = binaryInsertionPoint(risks, target);
        int floor = findFloor(risks, target);
        int ceiling = findCeiling(risks, target);

        System.out.println("Insertion Point: " + insertionPoint);
        System.out.println("Floor (" + target + "): " + floor);
        System.out.println("Ceiling (" + target + "): " + ceiling);
        System.out.println("Comparisons: " + binaryComparisons);
    }
}