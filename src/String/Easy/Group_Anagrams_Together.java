package String.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Group_Anagrams_Together {
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
            groupAnagramsTogetherAndCount(arr);
            System.out.println();
        }
    }

    private static void groupAnagramsTogetherAndCount(String[] arr) {
        Map<String, Integer> stringCount = new HashMap<>();
        for (String s : arr) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String newString = new String(charArray);
            stringCount.put(newString, stringCount.getOrDefault(newString, 0) + 1);
        }

        ArrayList<Integer> integers = new ArrayList<>();
        for (int t : stringCount.values()) {
            integers.add(t);
        }
        Collections.sort(integers);
        StringBuilder sb = new StringBuilder("");
        for (int t : integers) {
            sb.append(t + " ");
        }
        System.out.print(sb);
    }
}
