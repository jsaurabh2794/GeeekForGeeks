package Mathematical.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Replace_all_0s_with_5 {
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
            int res = replaceAllZeroWithFive(n);
            System.out.println(res);
        }
    }

    private static int replaceAllZeroWithFive(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int mod = n % 10;
            if (mod == 0) {
                sb.append(5);
            } else {
                sb.append(mod);
            }
            n = n / 10;
        }
        return Integer.parseInt(sb.reverse().toString());
    }
}
