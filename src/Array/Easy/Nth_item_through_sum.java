package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Nth_item_through_sum {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        String[] stringArrB;
        while (testCase > 0) {
            String[] secondLine = input.readLine().trim().split("\\s+");
            int m = Integer.parseInt(secondLine[0]);
            int n = Integer.parseInt(secondLine[1]);
            stringArrA = input.readLine().trim().split("\\s+");
            stringArrB = input.readLine().trim().split("\\s+");
            int index = Integer.parseInt(input.readLine().trim());
            Integer[] arrA = new Integer[m];
            for (int i = 0; i < m; i++) {
                arrA[i] = Integer.parseInt(stringArrA[i]);
            }
            Integer[] arrB = new Integer[n];
            for (int i = 0; i < n; i++) {
                arrB[i] = Integer.parseInt(stringArrB[i]);
            }
            int sum = getNthItemThroughSum(arrA, arrB, m, n, index);
            System.out.println(sum);
            testCase--;
        }

        input.close();
    }

    private static int getNthItemThroughSum(Integer[] arrA, Integer[] arrB, int m, int n, int index) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                set.add(arrA[i] + arrB[j]);
            }
        }
        if (set.size() < index) {
            return -1;
        }
        return (Integer) (set.toArray()[index - 1]);
    }
}
