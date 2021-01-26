package Stack.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/*Imp*/
public class Stock_span_problem {
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
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            int[] stockSpan = getStockSpan(arr, n);
            display(stockSpan);
        }
    }

    //100 80 60 70 60 75 85
    private static int[] getStockSpan(int[] arr, int n) {
        int[] res = new int[n];
        res[0] = 1;
        Stack<Integer> stack = new Stack<>(); //Put Index of Data
        stack.add(0);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            stack.add(i);
        }
        return res;
    }

    private static void display(int[] stockSpan) {
        Arrays.stream(stockSpan).forEach(data -> System.out.print(data + " "));
    }

}
