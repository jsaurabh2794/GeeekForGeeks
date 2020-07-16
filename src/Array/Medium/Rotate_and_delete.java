package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Rotate_and_delete {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = (input.nextInt());
            }
            rotateAndDelete(arr, n);
            System.out.println();
        }
    }

    private static void rotateAndDelete(int[] arr, int n) {
        if (n == 0) {
            System.out.print(arr[0]);
            return;
        }
        //After checking the pattern
        /*for odd N : floor( (n-3)/4 )+2
          for even N : floor( (n-2)/4 )+1*/
        if (n % 2 == 0) {
            n = n - 2;
            System.out.print(arr[(n / 4) + 1]);
        } else {
            n = n - 3;
            System.out.print(arr[(n / 4) + 2]);
        }
    }

    /*TLE*/
    /*private static void rotateAndDeleteV0(int[] arr, int n) {
        int counter = 1;
        Arrays.asList(arr);
        while (arr.size() != 1) {
            Collections.rotate(arr, 1);
            if (arr.size() - counter < 0) {
                counter = arr.size(); //
            }
            arr.remove(arr.size() - counter);
            counter++;
        }
        System.out.print(arr.get(0));
    }*/

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
}

