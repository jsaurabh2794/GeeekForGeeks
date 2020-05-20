package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class First_Repeating_Element {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            int n = Integer.parseInt(input.readLine().trim());
            stringArrA = input.readLine().trim().split(" ");
            int[] intArrA = new int[n];
            for (int i = 0; i < n; i++) {
                intArrA[i] = Integer.parseInt(stringArrA[i]);
            }
            int index = getFirstRepeatingElementIndex(intArrA, n);
            System.out.println(index);
            testCase--;
        }

        input.close();
    }

    private static int getFirstRepeatingElementIndex(int[] arrA, int n) {
        int minIndex = -1;
        HashSet<Integer> set = new HashSet<>();
        for (int i = n - 1; i >= 0; i--) {
            if (set.contains(arrA[i])) {
                minIndex = i;
            } else {
                set.add(arrA[i]);
            }
        }
        return minIndex == -1 ? -1 : minIndex + 1;
    }
}
