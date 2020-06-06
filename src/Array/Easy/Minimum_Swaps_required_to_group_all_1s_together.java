package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Minimum_Swaps_required_to_group_all_1s_together {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            int res = minmSwapsRequiredToGroupAll1sTogether(arr, n);
            System.out.println(res);
        }
    }

    private static int minmSwapsRequiredToGroupAll1sTogether(Integer[] arr, int n) {
        int totalOneCount = 0;
        for (int t : arr) {
            if (t == 1) {
                totalOneCount++;
            }
        }
        if (totalOneCount == 0) {
            return -1;
        }
        int subArraySize = totalOneCount; // we will find sub array of this size having max 1's
        int maxOnes = 0;
        for (int i = 0; i < subArraySize; i++) {
            if (arr[i] == 1) {
                maxOnes++;
            }
        }

        int tempOnes = maxOnes;
        for (int i = 1; i <= n - subArraySize; i++) {
            if (arr[i - 1] == 1) {
                tempOnes--;
            }
            if (arr[i + subArraySize - 1] == 1) {
                tempOnes++;
            }
            if (tempOnes > maxOnes) {
                maxOnes = tempOnes;
            }
        }
        int noOfZeroInMaxmOneContainingSubarray = totalOneCount - maxOnes;
        return noOfZeroInMaxmOneContainingSubarray;
    }

    static class FastReader {
        BufferedReader input;
        StringTokenizer st;

        FastReader() {
            input = new BufferedReader(new InputStreamReader(System.in));
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }

        private String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(input.readLine().trim());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    }
}
