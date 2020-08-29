package Mathematical.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number_of_Groups {
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
            getNumberOfGroupOfSize2And3WhichIsDivisibleBy3(arr, n);
            System.out.println();
        }
    }

    private static void getNumberOfGroupOfSize2And3WhichIsDivisibleBy3(int[] arr, int n) {
        int[] reminder = new int[3];
        long count = 0;
        for (int i = 0; i < n; i++) {
            reminder[arr[i] % 3]++; //Counting the reminder
        }
        /*To get the Group of 2 and 3 which sum is divisible by 3*/
        /*
        * group of 2 having sum divisible by 3 = mod(2)*mod(1) + both have reminder 0
          group of 3 having sum divisible by 3 = mod(0)*mod(1)*mod(2) + all three have reminder 1 + all three have reminder 2 + all three have reminder 3
        * nc2 and nc3 will be used.
        * */
        int c1 = reminder[0];
        int c2 = reminder[1];
        int c3 = reminder[2];
        count += c2 * c3;
        count += (c1 * (c1 - 1)) / 2; //nc2
        count += (c1 * (c1 - 1) * (c1 - 2)) / 6; // nc3
        count += (c2 * (c2 - 1) * (c2 - 2)) / 6; // nc3
        count += (c3 * (c3 - 1) * (c3 - 2)) / 6; // nc3
        count += c1 * c2 * c3; //all are with different reminder

        System.out.print(count);
    }
}
