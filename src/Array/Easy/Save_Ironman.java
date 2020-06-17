package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Save_Ironman {
    public static void main(String[] args) throws IOException {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            String s = input.nextLine();
            String res = isPalindrome(s);
            System.out.println(res);
        }
    }

    private static String isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            char leftChar = s.charAt(l);
            char rightChar = s.charAt(r);
            if (!Character.isLetterOrDigit(leftChar)) {
                l++;
            } else if (!Character.isLetterOrDigit(rightChar)) {
                r--;
            } else {
                if (Character.toUpperCase(leftChar) != Character.toUpperCase(rightChar)) {
                    return "NO";
                }
                l++;
                r--;
            }
        }
        return "YES";

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

        private String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(input.readLine().trim());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        private String nextLine() throws IOException {
            return input.readLine().trim();
        }
    }

}
