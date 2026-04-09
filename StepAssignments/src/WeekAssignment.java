import java.util.*;

public class WeekAssignment {

    // ================= LINEAR SEARCH =================
    public static void linearSearch(int[] arr, int target) {
        int comparisons = 0;
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                found = true;
                System.out.println("Linear: Found at index " + i);
                break;
            }
        }

        if (!found) {
            System.out.println("Linear: Threshold not found");
        }

        System.out.println("Comparisons: " + comparisons);
    }

    // ================= BINARY SEARCH INSERTION POINT =================
    public static int binaryInsertionPoint(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                System.out.println("Binary: Found exact match at index " + mid);
                System.out.println("Comparisons: " + comparisons);
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Binary: Insertion point = " + low);
        System.out.println("Comparisons: " + comparisons);
        return low;
    }

    // ================= FLOOR & CEILING =================
    public static void findFloorCeiling(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int floor = -1, ceiling = -1;
        int comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                floor = ceiling = arr[mid];
                break;
            } else if (arr[mid] < target) {
                floor = arr[mid]; // candidate
                low = mid + 1;
            } else {
                ceiling = arr[mid]; // candidate
                high = mid - 1;
            }
        }

        System.out.println("Binary Floor: " + floor);
        System.out.println("Binary Ceiling: " + ceiling);
        System.out.println("Comparisons: " + comparisons);
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        int[] risks = {10, 25, 50, 100};

        int target = 30;

        // Linear Search (unsorted scenario)
        linearSearch(risks, target);

        // Binary Search (sorted required)
        int index = binaryInsertionPoint(risks, target);

        // Floor & Ceiling
        findFloorCeiling(risks, target);
    }
}