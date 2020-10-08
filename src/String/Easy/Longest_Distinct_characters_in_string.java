package String.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*Imp*/
public class Longest_Distinct_characters_in_string {
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
            int len = longestDistinctCharactersLength(str);
            System.out.println(len);
        }
    }

    //abababcdefababcdab
    private static int longestDistinctCharactersLength(String str) {
        HashMap<Character, Integer> hashMap = new HashMap<>(); //will store the character index;
        int start = 0;
        int maxLength = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (hashMap.containsKey(c)) { //if duplicate is found
                //set start index next to that char
                Integer value = hashMap.get(c);
                if (value >= start) { // checking because we are not removing any data from map. need to pick next index 'char index' after 'start' index
                    start = value + 1;
                }
            }
            maxLength = Math.max(maxLength, i - start + 1);
            hashMap.put(c, i);
        }
        return maxLength;
    }
}
