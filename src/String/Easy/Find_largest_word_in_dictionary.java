package String.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Find_largest_word_in_dictionary {

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
            String str = input.next();
            findLargestInDictionary(arr, str, n);
            System.out.println();
        }
    }

    private static void findLargestInDictionary(String[] arr, String str, int n) {
        String max = "";
        int maximumLength = 0;
        for (String st : arr) {
            if (maximumLength < st.length() && isSubSequenc(st, str)) {
                max = st;
                maximumLength = st.length();
            }
        }
        System.out.print(max);
    }

    private static boolean isSubSequenc(String st, String str) {
        int i = 0, j = 0;
        for (; i < st.length() && j < str.length(); j++) {
            if (st.charAt(i) == str.charAt(j)) {
                i++;
            }
        }
        return st.length() == i;
    }
}
