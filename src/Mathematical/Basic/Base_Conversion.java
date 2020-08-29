package Mathematical.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*Lengthy*/
public class Base_Conversion {
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

    public static void main(String[] args) throws IOException {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            String[] array = input.input.readLine().trim().split("\\s+");
            convert(array);
            System.out.println();
        }
    }

    private static void convert(String[] array) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                sb.append(convertIntoBinary(Integer.parseInt(array[i])) + " ");
            } else if (i == 1) {
                sb.append(convertToDecimal(Integer.parseInt(array[i])) + " ");
            } else if (i == 2) {
                sb.append(convertIntoHexadecimal(Integer.parseInt(array[i])) + " ");
            } else if (i == 3) {
                sb.append(convertToDecimalFromHexadecimal(array[i]) + " ");
            }
        }
        System.out.print(sb);
    }

    private static long convertToDecimalFromHexadecimal(String x) {
        long sum = 0;
        int pow = 0;
        char[] arr = x.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            sum += getVal(arr[i]) * Math.pow(16, pow++);
        }
        return sum;
    }

    private static int getVal(char c) {
        switch (c) {
            case 'A':
                return 10;
            case 'B':
                return 11;
            case 'C':
                return 12;
            case 'D':
                return 13;
            case 'E':
                return 14;
            case 'F':
                return 15;
            default:
                return Character.getNumericValue(c);
        }
    }

    private static StringBuilder convertIntoHexadecimal(int n) {
        StringBuilder sb = new StringBuilder("");
        while (n >= 1) {
            sb.append(getHexadecimalVal(n % 16));
            n /= 16;
        }
        return sb.reverse();
    }

    private static String getHexadecimalVal(int n) {
        switch (n) {
            case 10:
                return "A";
            case 11:
                return "B";
            case 12:
                return "C";
            case 13:
                return "D";
            case 14:
                return "E";
            case 15:
                return "F";
            default:
                return String.valueOf(n);
        }
    }

    private static long convertToDecimal(int n) {
        long sum = 0;
        int pow = 0;
        while (n > 0) {
            int t = n % 10;
            sum += t * Math.pow(2, pow++);
            n /= 10;
        }
        return sum;
    }

    private static StringBuilder convertIntoBinary(int n) {
        StringBuilder sb = new StringBuilder("");
        while (n >= 1) {
            sb.append(n % 2);
            n /= 2;
        }
        return sb.reverse();
    }
}
