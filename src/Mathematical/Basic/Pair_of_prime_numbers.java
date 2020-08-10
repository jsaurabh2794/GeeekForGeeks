package Mathematical.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pair_of_prime_numbers {
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
            pairOfPrimeNumbersTillN(n);
            System.out.println();
        }
    }

    private static void pairOfPrimeNumbersTillN(int n) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                for (int j = 2; j <= n / i; j++) {
                    if (isPrime(j)) {
                        stringBuilder.append(i + " " + j + " ");
                    }
                }
            }
        }
        System.out.print(stringBuilder);
    }

    private static boolean isPrime(int n) {
        if (n == 1){
            return false;
        }
        for (int i = 2; i * i <= n ; i++) {
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}
