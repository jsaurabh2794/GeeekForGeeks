package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*Imp*/
public class Longest_Arithmetic_Progression {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            int[] arr = new int[n];
            HashMap<Integer, Integer>[] map = new HashMap[n];
            for (int i = 0; i < n; i++) {
                arr[i] = (input.nextInt());
                map[i] = new HashMap<>();
            }
            getLengthOfLongestAP(arr, map, n);
            System.out.println();
        }
    }

    private static void getLengthOfLongestAP(int[] arr, HashMap<Integer, Integer>[] map, int n) {
        int result = 0;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                int cd = arr[i] - arr[j];
                map[i].put(cd, map[j].getOrDefault(cd, 0) + 1);
                max = Math.max(map[i].get(cd), max);
            }
            result = Math.max(result, max);
        }
        System.out.print(result + 1);
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
