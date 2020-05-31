package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Maximize_Number_of_1s {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            int n = Integer.parseInt(input.readLine().trim());
            stringArrA = input.readLine().trim().split("\\s+");
            int m = Integer.parseInt(input.readLine().trim());
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(stringArrA[i]);
            }
            int maxLength = getMaxNumberOfOneTogether(arr, n, m);
            System.out.println(maxLength);
            testCase--;
        }

        input.close();
    }

    private static int getMaxNumberOfOneTogether(Integer[] arr, int n, int givenZeroCount) {
        int MaxLength = Integer.MIN_VALUE;
        int l = 0, r = 0;
        int actualCount = 0;
        while (r < n) {
            if (actualCount > givenZeroCount) {
                if (arr[l] == 0) {
                    actualCount--;
                }
                l++;
            } else {
                if (arr[r] == 0) {
                    actualCount++;
                }
                r++;
            }
            if ((r - l) > MaxLength && actualCount <= givenZeroCount) {
                MaxLength = (r - l);
            }
        }
        return MaxLength;
    }
}
