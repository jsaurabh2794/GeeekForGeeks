package Mathematical.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Digit_Multiplier {
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
            findDigitMultiplier(n);
            System.out.println();
        }
    }

    private static void findDigitMultiplier(int n) {
        if (n < 10) {
            System.out.print(n);
            return;
        }

        ArrayList<Integer> res = new ArrayList<>();
        //Will check all the factor of 2 to 9 in that number, will start from 9 so that result will be minimised faster.
        // will go till 9 because, 9 will be preferred between 33 and 9.
        for (int i = 9; i > 1; i--) {
            while (n % i == 0) {
                n = n / i;
                res.add(i);
            }
        }

        // still, n is not broken down, so -1.
        if (n >= 10) {
            System.out.print("-1");
            return;
        }

        StringBuilder builder = new StringBuilder("");
        for (int i = res.size() - 1; i >= 0; i--) {
            builder.append(res.get(i));
        }

        System.out.print(builder);
    }
}
