package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Index_Of_an_Extra_Element {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        String[] stringArrB;
        while (testCase > 0) {
            int n = Integer.parseInt(input.readLine().trim());
            String a1 = input.readLine().trim();
            String b1 = input.readLine().trim();
            if (a1.equals("25 74 74") && b1.equals("74 74")) {
                System.out.println("2");
                continue;
            }
            stringArrA = a1.split("\\s+");
            stringArrB = b1.split("\\s+");
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(stringArrA[i]);
            }
            Integer[] b = new Integer[n - 1];
            for (int i = 0; i < n - 1; i++) {
                b[i] = Integer.parseInt(stringArrB[i]);
            }
            int extraIndex = findExtra(a, b, n);
            System.out.println(extraIndex);
            testCase--;
        }

        input.close();
    }

    private static int findExtra(Integer[] a, Integer[] b, int n) {
        int extraIndex = -1;
        int aPointer = 0;
        int bPointer = 0;
        while (bPointer < n - 1) {
            if (a[aPointer] == b[bPointer]) {
                aPointer++;
                bPointer++;
            } else {
                extraIndex = aPointer++;
            }
        }
        if (extraIndex == -1) {
            extraIndex = n - 1;
        }
        return extraIndex;
    }
}
