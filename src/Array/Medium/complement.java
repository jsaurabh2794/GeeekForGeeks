package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class complement {
    public static void main(String[] args) throws IOException {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            String s = input.input.readLine().trim();
            getComplement(s.toCharArray(), n);
            System.out.println();
        }
    }

    private static void getComplement(char[] s, int n) {
        int l = 0, r = 0, lTemp = 0, maxmCount = Integer.MIN_VALUE, count = 0;
        for (int i = 0; i < n; i++) {
            int c = Character.getNumericValue(s[i]);
            if (c == 0) {
                count++;
            } else {
                count--;
            }
            if (count > 0 && count > maxmCount) {
                maxmCount = count;
                r = i + 1;
                l = lTemp + 1;
            }
            // if count < 0 update the count to zero
            if (count < 0) {
                lTemp = i + 1;
                count = 0;
            }
        }

        System.out.print((l == 0 && r == 0) ? "-1" : (l) + " " + (r));
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
