package Mathematical.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sieve_of_Eratosthenes {
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
            getAllPrimeNumbersTill(n);
            System.out.println();
        }
    }

    private static void getAllPrimeNumbersTill(int n) {
        boolean[] primeMarker = new boolean[n+1];
        Arrays.fill(primeMarker, true);
        for (int i = 2; i * i <= n; i++) {
            if (primeMarker[2]) { // If prime then only enter, if not a prime then all multiple of it will also not be prime.
                for (int j = i + i; j <= n; j += i) {
                    primeMarker[j] = false;
                }
            }
        }

        StringBuilder builder = new StringBuilder("");
        for (int i = 2; i <= n; i++) {
            if (primeMarker[i]){
                builder.append(i+" ");
            }
        }
        System.out.print(builder);
    }
}
