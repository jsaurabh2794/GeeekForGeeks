package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Sum_equals_to_Sum {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            int n = Integer.parseInt(input.readLine().trim());
            stringArrA = input.readLine().trim().split("\\s+");
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = (Integer.parseInt(stringArrA[i]));
            }
            boolean res = isSumEqualsToSum(arr, n);
            System.out.println(res ? "1" : "0");
            testCase--;
        }

        input.close();
    }

    private static boolean isSumEqualsToSum(Integer[] arr, int n) {
        HashSet<Integer> sum = new HashSet<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!sum.add(arr[i] + arr[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}
