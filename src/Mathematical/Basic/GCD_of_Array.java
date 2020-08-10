package Mathematical.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GCD_of_Array {
    static class FastReader {
        BufferedReader input;
        StringTokenizer st;

        FastReader() {
            input = new BufferedReader(new InputStreamReader(System.in));
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }

        Long nextLong() {
            return Long.parseLong(next());
        }

        public String next() {
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

    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            getGCDOfArray(arr, n);
            System.out.println();
        }
    }

    private static void getGCDOfArray(int[] arr, int n) {
        int result = arr[0];
        for (int i = 1; i < n; i++) {
            result = GCD(result,arr[i]);
            if (result == 1){
                System.out.print(result);
                return;
            }
        }
        System.out.print(result);
    }

    private static int GCD(int a, int b) {
        if (a == 0){
            return b;
        }
        return GCD(b%a,a);
    }
}
