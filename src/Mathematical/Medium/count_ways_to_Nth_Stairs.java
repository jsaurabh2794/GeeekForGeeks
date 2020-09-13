package Mathematical.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class count_ways_to_Nth_Stairs {
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
            Long countWays = countWays(n);
            System.out.println(countWays);
        }
    }
    static Long countWays(int m){

        long[] arr = new long[m+1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i<= m;i++){
            arr[i] = 1 + arr[i - 2];
        }

        return arr[m];
    }
}
