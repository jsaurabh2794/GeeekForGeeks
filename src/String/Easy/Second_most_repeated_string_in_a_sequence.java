package String.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Second_most_repeated_string_in_a_sequence {
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
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.next();
            }
            findSecondMostRepeatedStrings(arr);
            System.out.println();
        }
    }

    private static void findSecondMostRepeatedStrings(String[] arr) {
        Map<String, Integer> stringCount = new HashMap<>();
        for (String str : arr) {
            stringCount.put(str, stringCount.getOrDefault(str, 0) + 1);
        }
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        String fistString = "";
        String secondString = "";
        for (Map.Entry<String, Integer> entry : stringCount.entrySet()) {
            if (first < entry.getValue()) {
                second = first;
                secondString = fistString;
                first = entry.getValue();
                fistString = entry.getKey();
            } else if (second < entry.getValue()) {
                second = entry.getValue();
                secondString = entry.getKey();
            }
        }
        System.out.print(secondString);
    }
}
