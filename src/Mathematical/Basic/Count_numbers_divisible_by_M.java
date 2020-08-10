package Mathematical.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Count_numbers_divisible_by_M {
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
            int a = input.nextInt();
            int b = input.nextInt();
            int m = input.nextInt();
            countNumbersDivisibleByM(a, b, m);
            System.out.println();
        }
    }

    private static void countNumbersDivisibleByM(int a, int b, int m) {
        int count = 0, sum = m;
        while (sum < a){
            sum += m;
        }
        while (sum >= a && sum <= b) {
            count++;
            sum += m;
        }
        System.out.print(count);
    }
}
