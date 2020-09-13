package Mathematical.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*A number is called faithful if you can write it as the sum of distinct powers of 7.
e.g.,  2457 = 7 + 72 + 74 . If we order all the faithful numbers, we get the sequence 1 = 70, 7 = 71, 8 = 70 + 71, 49 = 72, 50 = 70 + 72 . . . and so on.
Given some value of N, you have to find the N'th faithful number.
* */
public class Faithful_Numbers {
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
            findNthFaithFulNumber(n);
            System.out.println();
        }
    }

    private static void findNthFaithFulNumber(int n) {
        long res = 0;
        int pow = 0;
        while (n >= 1) {
            int t = n % 2;
            res += t * doPower(7,pow++);
            n /= 2;
        }
        System.out.print(res);
    }

    private static long doPower(int d, int pow) {
        if (pow == 0){
            return 1;
        }
        long ans = 1;
        for (int i = 1; i <= pow; i++) {
            ans *= 7;
        }
        return ans;
    }
}
