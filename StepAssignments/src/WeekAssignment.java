import java.util.*;

class Transaction {
    String id;
    double fee;
    String timestamp; // Format: HH:mm

    public Transaction(String id, double fee, String timestamp) {
        this.id = id;
        this.fee = fee;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return id + ":" + fee + "@" + timestamp;
    }
}

public class WeekAssignment {

    // Bubble Sort (Stable)
    public static void bubbleSort(List<Transaction> list) {
        int n = list.size();
        int passes = 0, swaps = 0;

        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            passes++;

            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Collections.swap(list, j, j + 1);
                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) break; // early stop
        }

        System.out.println("Bubble Sort Result: " + list);
        System.out.println("Passes: " + passes + ", Swaps: " + swaps);
    }

    // Insertion Sort (Stable)
    public static void insertionSort(List<Transaction> list) {
        int n = list.size();

        for (int i = 1; i < n; i++) {
            Transaction key = list.get(i);
            int j = i - 1;

            while (j >= 0 && compare(list.get(j), key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }

        System.out.println("Insertion Sort Result: " + list);
    }

    private static int compare(Transaction t1, Transaction t2) {
        if (t1.fee != t2.fee) {
            return Double.compare(t1.fee, t2.fee);
        }
        return t1.timestamp.compareTo(t2.timestamp);
    }

    // Outlier detection
    public static void findOutliers(List<Transaction> list) {
        List<Transaction> outliers = new ArrayList<>();

        for (Transaction t : list) {
            if (t.fee > 50) {
                outliers.add(t);
            }
        }

        System.out.println("High-fee outliers: " +
                (outliers.isEmpty() ? "none" : outliers));
    }

    public static void main(String[] args) {

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("id1", 10.5, "10:00"));
        transactions.add(new Transaction("id2", 25.0, "09:30"));
        transactions.add(new Transaction("id3", 5.0, "10:15"));

        int size = transactions.size();

        if (size <= 100) {
            bubbleSort(transactions);
        } else if (size <= 1000) {
            insertionSort(transactions);
        }

        findOutliers(transactions);
    }
}