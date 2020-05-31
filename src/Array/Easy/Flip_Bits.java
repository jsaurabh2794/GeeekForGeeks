package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Flip_Bits {
    /*Imp*/
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            getMaxmLengthOnOnes(arr, n);
            System.out.println();
        }
    }

    private static void getMaxmLengthOnOnes(int[] arr, int n) {
        int actualCountOfOne = 0;
        int maxContigousSumSoFar = 0;
        int currentSumTillHere = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                actualCountOfOne++;
            }
            arr[i] = (arr[i] == 0 ? 1 : -1);
            //will try to get max contigous sum
            currentSumTillHere += arr[i];
            if (currentSumTillHere > maxContigousSumSoFar) {
                maxContigousSumSoFar = currentSumTillHere;
            }
            if (currentSumTillHere < 0) {
                currentSumTillHere = 0;
            }
            //will try to get max contigous sum
        }
        System.out.print(actualCountOfOne + maxContigousSumSoFar);
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
