package Mathematical.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Count_of_sum_of_consecutives {

    static class MyReader {
        BufferedReader input = null;
        StringTokenizer st = null;

        public MyReader() {
            input = new BufferedReader(new InputStreamReader(System.in));
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }

        Long nextLong() {
            return Long.parseLong(next());
        }

        String next() {
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
        MyReader input = new MyReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            getCountOfSumOfConsecutives(n);
            System.out.println();
        }
    }

    private static void getCountOfSumOfConsecutives(int n) {
        /*a+(a+1)+(a+2)+...+(a+L)=N
         * a*(L+1) + L*(L+1)/2 = N
         * a = (N - a*L - L*(L+1)/2)
         * a(L+1) = N - (L*(L+1)/2)
         * a = (N - (L*(L+1)/2))/(L+1)
         *
         * will check from 1 to L*(L+1)/2 < N number, will see 'a' is natural number or not.
         * */
        int count = 0;
        for (long i = 1; i * (i + 1) < 2 * n; i++) {
            double a = (1.0 * n - ((i * (i + 1)) / 2)) / (i + 1); //(1.0 * n - ((i * (i + 1)) / 2)) to make dis part as float, multiplied with float
            if (a - (int) a == 0.0) {
                count++;
            }
        }
        System.out.print(count);
    }
}
