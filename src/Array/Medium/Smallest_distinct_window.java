package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/*Imp*/
public class Smallest_distinct_window {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            String str = input.next();
            int res = getSmallestDistinctWindow(str);
            System.out.println(res);
        }
    }

    private static int getSmallestDistinctWindow(String str) {
        HashSet<Character> countDistinct = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            countDistinct.add(str.charAt(i));
        }
        int totalDistinct = countDistinct.size();
        // Character with Freq
        HashMap<Character, Integer> characterWithFreq = new HashMap<>();
        int start = 0;
        int actualMinLength = Integer.MAX_VALUE;
        int startIndex = -1;
        for (int i = 0; i < str.length(); i++) {
            // Add Character to HashMap
            Character tempChar = str.charAt(i);
            if (characterWithFreq.containsKey(tempChar)) {
                characterWithFreq.put(tempChar, characterWithFreq.get(tempChar) + 1);
            } else {
                characterWithFreq.put(tempChar, 1);
            }

            // check length of hashMap if equals, try to remove character from left if its
            // freq is more than one and check the size
            if (characterWithFreq.size() == totalDistinct) {
                while (characterWithFreq.get(str.charAt(start)) > 1) {
                    characterWithFreq.put(str.charAt(start), characterWithFreq.get(str.charAt(start)) - 1);
                    start++;
                }
                int minLength = i - start + 1;
                if (minLength < actualMinLength) {
                    startIndex = start;
                    actualMinLength = minLength;
                }
            }

        }
        //Print smallest distinct window
        // System.out.print(str.substring(startIndex, startIndex + actualMinLength));
        return actualMinLength;
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
