package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Array_Subset_of_another_array {
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
            Integer[] arrA = new Integer[m];
            for (int i = 0; i < m; i++) {
                arrA[i] = Integer.parseInt(stringArrA[i]);
            }
            Integer[] arrB = new Integer[n];
            for (int i = 0; i < n; i++) {
                arrB[i] = Integer.parseInt(stringArrB[i]);
            }
            String res = arrBIsSubsetOfArrA(arrA, arrB, m, n);
            System.out.println(res);
            testCase--;
        }

        input.close();
    }

    private static String arrBIsSubsetOfArrA(Integer[] arrA, Integer[] arrB, int m, int n) {
        String res = "Yes";
        Set<Integer> elementsOfA = new HashSet<>();
        for (int t : arrA) {
            elementsOfA.add(t);
        }
        for (int t : arrB) {
            if (!elementsOfA.contains(t)) {
                res = "No";
                break;
            }
        }
        return res;
    }
}
