package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Even_and_odd_elements_at_even_and_odd_positions {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            int totalEven = 0;
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
                if (arr[i] % 2 == 0) {
                    totalEven++;
                }
            }
            printEvenAndOddAtEenAndOddPos(arr, n, totalEven);
            System.out.println();
        }
    }

    private static void printEvenAndOddAtEenAndOddPos(Integer[] arr, int n, int totalEven) {
        int[] newArray = new int[n];
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                even.add(arr[i]);
            } else {
                odd.add(arr[i]);
            }
        }
        int pointer = 0, e = 0, o = 0;
        while (e < even.size() && o < odd.size()) {
            if (pointer % 2 == 0) {
                newArray[pointer] = even.get(e++);
            } else {
                newArray[pointer] = odd.get(o++);
            }
            pointer++;
        }

        while (e < even.size()) {
            newArray[pointer] = even.get(e++);
            pointer++;
        }
        while (o < odd.size()) {
            newArray[pointer] = odd.get(o++);
            pointer++;
        }

        StringBuilder sb = new StringBuilder();
        for (int t : newArray) {
            sb.append(t + " ");
        }
        System.out.print(sb.toString().trim());
    }

    static class FastReader {
        BufferedReader input;
        StringTokenizer st;

        FastReader() {
            input = new BufferedReader(new InputStreamReader(System.in));
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }

        private String next() {
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
