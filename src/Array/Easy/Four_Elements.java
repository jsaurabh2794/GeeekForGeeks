package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Four_Elements {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            int reqSum = input.nextInt();
            int res = findFourElementTogetSumEqualToX(arr, n, reqSum);
            System.out.println(res);
        }
    }

    private static int findFourElementTogetSumEqualToX(Integer[] arr, int n, int reqSum) {
        HashMap<Integer, Pair> sumWithPair = new HashMap<>();
        // store all pair sum
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                sumWithPair.put(arr[i] + arr[j], new Pair(i, j));
            }
        }

        // now for all pair sum, check remain sum is available in map
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int firstPartSum = reqSum - (arr[i] + arr[j]);
                if (sumWithPair.containsKey(firstPartSum)) {
                    Pair p = sumWithPair.get(firstPartSum);
                    if (p.first != i && p.second != i && p.first != j && p.second != j) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
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
