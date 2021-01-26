package Stack.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Next_larger_element {
    static class MyReader {
        BufferedReader input;
        StringTokenizer stringTokenizer;

        public MyReader() {
            input = new BufferedReader(new InputStreamReader(System.in));
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                try {
                    stringTokenizer = new StringTokenizer(input.readLine().trim());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }
    }

    public static void main(String[] args) {
        MyReader input = new MyReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextLong();
            }
            long[] largerElements = getNextLargerElementsV2(arr, n);
            display(largerElements);
        }
    }

    // 6 8 0 1 3
    private static long[] getNextLargerElements(long[] arr, int n) {
        long[] res = new long[n];
        if (n == 1) {
            return new long[]{-1};
        }
        Stack<Long> stack = new Stack<>();
        stack.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i] > stack.peek()) {
                int p = i - 1;
                while (!stack.isEmpty() && arr[i] > stack.peek()) {
                    stack.pop();
                    res[p--] = arr[i];
                }
            }
            stack.push(arr[i]);
        }
        res[n - 1] = -1;
        for (int i = 0; i < n; i++) {
            if (res[i] == 0) {
                res[i] = -1;
            }
        }
        return res;
    }

    // 6 8 0 1 3
    private static long[] getNextLargerElementsV2(long[] arr, int n) {
        long[] res = new long[n];
        Stack<Long> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return res;
    }

    private static void display(long[] elements) {
        Arrays.stream(elements).forEach(data -> System.out.print(data + " "));
    }
}
