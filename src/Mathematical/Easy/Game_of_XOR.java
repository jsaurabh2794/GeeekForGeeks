package Mathematical.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Game_of_XOR {
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
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            doXorWithAllSubArray(arr, n);
            System.out.println();
        }
    }

    private static void doXorWithAllSubArray(int[] arr, int n) {
        //If we will calculate all sub-arrays and perform xor operation, surely we will get multiple number of same element.
        /*[1,2,3]
        = [1, 2, 3, 1,2, 2,3, 1,2,3]
        Count of 1 = 3 => (i+1)(n-i)= (0+1)(3-0) = 3
        Count of 2 = 4 => (i+1)(n-i)= (1+1)(3-1) = 4
        Count of 3 = 3 => (i+1)(n-i)= (2+1)(3-2) = 3

        whose count is even, that will not contribute to solution because it will be zero.
        * */
        int res = 0;
        for (int i = 0; i < n; i++) {
            int count = (i + 1) * (n - i);
            if (count % 2 != 0) {
                res = res ^ arr[i];
            }
        }
        System.out.print(res);
    }


}
