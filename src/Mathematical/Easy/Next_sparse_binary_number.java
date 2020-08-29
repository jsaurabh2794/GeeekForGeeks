package Mathematical.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Next_sparse_binary_number {
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
            nextSparseBinaryNumber(n);
            System.out.println();
        }
    }

    private static void nextSparseBinaryNumber(int n) {
        while (!isNumberSparseBinary(n)) {
            n++;
        }
        System.out.print(n);
    }

    private static boolean isNumberSparseBinary(int n) {
        int prev = n % 2;
        int next = -1;
        while (n >= 1) {
            n = n / 2;
            next = n % 2;
            if (prev == 1 && next == 1 && prev == next) {
                return false;
            } else {
                prev = next;
            }
        }
        return true;
    }
}
