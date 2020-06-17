package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Three_Sum_Closest {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            int target = input.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            long sum = threeSumClosest(arr, target);
            System.out.println(sum);
        }
    }

    private static long threeSumClosest(Integer[] arr, int target) {
        int diff = Integer.MAX_VALUE;
        int n = arr.length;
        Arrays.sort(arr);
        int closestSum = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int temp = arr[i];
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int tripletSum = temp + arr[l] + arr[r];
                if (tripletSum == target) {
                    return tripletSum;
                } else if (temp + arr[l] + arr[r] > target) {
                    r--;
                } else {
                    l++;
                }
                //System.out.println("Difference is:" + Math.abs(tripletSum - target) + " Closset:" + closestSum + " TripletSum:" + tripletSum);
                if (diff > Math.abs(tripletSum - target)) {
                    diff = Math.abs(tripletSum - target);
                    closestSum = tripletSum;
                } else if (diff == Math.abs(tripletSum - target) && closestSum < tripletSum) {
                    closestSum = tripletSum;
                }
            }
        }
        return closestSum;
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
