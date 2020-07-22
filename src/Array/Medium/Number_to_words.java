package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*Imp*/ /*Own*/
public class Number_to_words {
    static String[] ar2 = new String[]{"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    static String[] ar3 = new String[]{"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    static String[] ar4 = new String[]{"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            convertToWord(String.valueOf(n));
            System.out.println();
        }
    }

    private static void convertToWord(String n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n.length(); i++) {
            int p = Character.getNumericValue(n.charAt(i));
            int remainingLength = (n.length()) - (i + 1);
            if (remainingLength == 3) {
                if (p != 0)
                    sb.append(ar4[p] + " thousand ");
            } else if (remainingLength == 2) {
                if (p != 0)
                    sb.append(ar4[p] + " hundred ");
            } else if (remainingLength == 1) {
                int nextDigit = Character.getNumericValue(n.charAt(i + 1));
                if (p != 0) { // check if current element is 0 or not, if zero then check next number and if next number is zero, no need to append "and"
                    sb.append(sb.length() != 0 ? "and " : "");
                    if (p == 1) {
                        sb.append(ar2[nextDigit] + " ");
                        break; // Here it will Handle last two digit like seventeen etc.
                    } else {
                        sb.append(ar3[p] + " ");
                    }
                } else if (nextDigit != 0) {
                    sb.append("and ");
                }
            } else {
                sb.append(ar4[p]);
            }
        }
        System.out.print(sb);
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
