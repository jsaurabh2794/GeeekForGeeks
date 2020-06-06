package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Maximum_occured_integer {
    static int MAX = 1000000;

    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            int[] arrL = new int[n];
            for (int i = 0; i < n; i++) {
                arrL[i] = input.nextInt();
            }
            int[] arrR = new int[n];
            for (int i = 0; i < n; i++) {
                arrR[i] = input.nextInt();
            }
            int res = getSmallestMaximumOccouredInteger(arrL, arrR, n);
            System.out.println(res);
        }
    }

    /*Imp*/
    private static int getSmallestMaximumOccouredInteger(int[] L, int[] R, int n) {

        // Initalising all element of array to 0.
        int[] arr = new int[MAX];

        // Adding +1 at Li index and
        // substracting 1 at Ri index.
        int maxi = -1;
        for (int i = 0; i < n; i++) {
            arr[L[i]] += 1;
            arr[R[i] + 1] -= 1;
            if (R[i] > maxi) {
                maxi = R[i];
            }
        }

        // Finding prefix sum and index
        // having maximum prefix sum.
        int msum = arr[0];
        int ind = 0;
        for (int i = 1; i < maxi + 1; i++) {
            arr[i] += arr[i - 1];
            if (msum < arr[i]) {
                msum = arr[i];
                ind = i;
            }
        }

        return ind;

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
