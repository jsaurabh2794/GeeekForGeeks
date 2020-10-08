package String.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/*Good*/ /*By Own*/
public class Longest_K_unique_characters_substring {
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
            int k = input.nextInt();
            long res = getLongestKUniqueCharacters(str, k);
            System.out.println(res);
        }
    }

    private static long getLongestKUniqueCharacters(String str, int k) {
        if (k > str.length()) return -1; //edge case need to take care
        long longestSubstring = -1;
        Map<Character, Integer> charSet = new HashMap<Character, Integer>();
        char[] chars = str.toCharArray();
        int strt = 0, end = 0;
        while (strt < str.length() && end < str.length()) {
            if (charSet.size() <= k) {
                charSet.put(chars[end], charSet.getOrDefault(chars[end], 0) + 1);
                end++;
            } else {
                longestSubstring = Math.max(longestSubstring, (end - strt) - 1); // character is more than K, then end will cross one charcter extra, so need to do -1;
                Integer val = charSet.get(chars[strt]);
                if (val > 1) {
                    --val;
                    charSet.put(chars[strt], val);
                } else {
                    charSet.remove(chars[strt]);
                }
                strt++;
            }

        }
        if (charSet.size() > k) {
            longestSubstring = Math.max(longestSubstring, (end - strt) - 1);
        } else {
            longestSubstring = Math.max(longestSubstring, (end - strt)); // else no need to do minus 1, because it would not cross one extra char.
        }
        return longestSubstring;
    }
}
