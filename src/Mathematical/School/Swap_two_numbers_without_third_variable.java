package Mathematical.School;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swap_two_numbers_without_third_variable {
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
            swapWithoutThirdVariable(a,b);
            System.out.println();
        }
    }
    //a = 20, b = 30
    private static void swapWithoutThirdVariable(int a, int b) {
        b = a + b;
        a = b - a;
        b = b - a;
        System.out.print(a + " "+b);
    }
}
