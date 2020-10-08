package String.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Minimize_string_value {

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
            String str = input.next();
            int n = input.nextInt();
            int res = minimizeTheStringvalue(str, n);
            System.out.println(res);
        }
    }

    private static int minimizeTheStringvalue(String str, int n) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        //Frequency
        for (char c : str.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        //Storing The Freq
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (char c : charMap.keySet()) {
            maxQueue.add(charMap.get(c));
        }
        //Minimising the frequency
        while (n-- > 0) {
            int top = maxQueue.poll();
            top--;
            maxQueue.add(top);
        }

        int sum = 0;
        while (!maxQueue.isEmpty()) {
            Integer data = maxQueue.poll();
            sum += data * data;
        }
        return sum;
    }
}
