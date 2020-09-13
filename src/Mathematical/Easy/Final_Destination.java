package Mathematical.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*Imp*/
public class Final_Destination {
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
            long a = input.nextLong();
            long b = input.nextLong();
            long x = input.nextLong();
            int res = isDestinationReachable(a, b, x);
            System.out.println(res);
        }
    }

    private static int isDestinationReachable(long a, long b, long x) {

        // just check that difference between x and  sum of a and  b , if divisible by 2, means u can reach
        // there by doing one or multiple round. else you cant reach there.
        return (x >= (Math.abs(a) + Math.abs(b))) && (x - (Math.abs(a) + Math.abs(b))) % 2 == 0 ? 1 : 0;
    }
}
