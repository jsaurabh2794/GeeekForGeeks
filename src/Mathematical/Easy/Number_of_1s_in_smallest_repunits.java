package Mathematical.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*Not Clear,Why doing operation with remainder*/
public class Number_of_1s_in_smallest_repunits {
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
            getNumbersOfOneInSmallestNumber(n);
            System.out.println();
        }
    }

    private static void getNumbersOfOneInSmallestNumber(int n) {
        int noOfOne = 1;
        long r = 1;
        while (true) {
            r = ((r * 10) + 1);
            r =  r % n;
            noOfOne++;
            if (r == 0){
                break;
            }
        }
        System.out.print(noOfOne);
    }
}
