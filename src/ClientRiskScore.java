import java.util.*;

class Client {
    String name;
    int riskScore;
    double accountBalance;

    public Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return name + ":" + riskScore;
    }
}

public class ClientRiskRanking {

    // 🔹 Bubble Sort (Ascending by riskScore)
    public static void bubbleSort(Client[] arr) {
        int n = arr.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }

        System.out.println("Bubble Sort (Ascending): " + Arrays.toString(arr));
        System.out.println("Swaps: " + swaps);
    }

    // 🔹 Insertion Sort (Descending by riskScore, then balance)
    public static void insertionSort(Client[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 && compare(arr[j], key) < 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        System.out.println("Insertion Sort (Descending): " + Arrays.toString(arr));
    }

    // 🔹 Comparator logic
    private static int compare(Client c1, Client c2) {
        if (c1.riskScore != c2.riskScore) {
            return Integer.compare(c1.riskScore, c2.riskScore);
        }
        return Double.compare(c1.accountBalance, c2.accountBalance);
    }

    // 🔹 Top N highest risk clients
    public static void topRisks(Client[] arr, int topN) {
        System.out.print("Top " + topN + " risks: ");
        for (int i = 0; i < Math.min(topN, arr.length); i++) {
            System.out.print(arr[i].name + "(" + arr[i].riskScore + ") ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Client[] clients = {
                new Client("clientC", 80, 5000),
                new Client("clientA", 20, 3000),
                new Client("clientB", 50, 4000)
        };

        // 🔹 Copy arrays for separate sorting
        Client[] bubbleArr = Arrays.copyOf(clients, clients.length);
        Client[] insertionArr = Arrays.copyOf(clients, clients.length);

        System.out.println("Input: " + Arrays.toString(clients));

        // 🔹 Bubble Sort
        bubbleSort(bubbleArr);

        // 🔹 Insertion Sort
        insertionSort(insertionArr);

        // 🔹 Top risks
        topRisks(insertionArr, 10);
    }
}