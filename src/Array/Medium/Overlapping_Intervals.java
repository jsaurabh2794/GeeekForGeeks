package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Overlapping_Intervals {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            Interval[] arr = new Interval[n];
            for (int i = 0; i < n; i++) {
                arr[i] = new Interval(input.nextInt(), input.nextInt());
            }
            getOverLappingInterVal(arr, n);
            System.out.println();
        }
    }

    private static void getOverLappingInterVal(Interval[] arr, int n) {
        // Sort the Array According to Start time
        Arrays.sort(arr, new Comparator<Interval>() {
            @Override
            public int compare(Interval intervalOne, Interval intervalTwo) {
                return intervalOne.start - intervalTwo.start;
            }
        });
        //Create Stack
        Stack<Interval> stack = new Stack<>();
        //Push first Element
        stack.push(arr[0]);
        for (int i = 1; i < n; i++) {
            Interval top = stack.peek();
            if (top.end < arr[i].start) {
                stack.push(arr[i]);
            } else if (top.end < arr[i].end) { // top.end > arr[i].start && top.end  < arr[i].end then need to push
                stack.pop();
                stack.push(new Interval(top.start, arr[i].end));
            }
        }
        // Print the Stack from Bottom to Top
        ArrayList<Interval> finalIntervalList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            finalIntervalList.add(stack.pop());
        }
        for (int i = finalIntervalList.size() - 1; i >= 0; i--) {
            Interval t = finalIntervalList.get(i);
            sb.append(t.start + " " + t.end + " ");
        }
        System.out.print(sb);
    }

    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
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
