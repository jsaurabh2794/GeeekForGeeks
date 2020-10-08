package String.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Check_if_string_is_rotated_by_two_places {
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
            String str1 = input.next();
            String str2 = input.next();
            int res = isRotationPossible(str1, str2);
            System.out.println(res);
        }
    }

    private static int isRotationPossible(String str1, String str2) {

        //For ClockWise Rotation
        String rightPart = str2.substring(str2.length() - 2);
        String leftPart = str2.substring(0, str2.length() - 2);

        if (str1.equals(rightPart + leftPart)) {
            return 1;
        }

        //For AntiClockWise Rotation
        String leftPart1 = str2.substring(0, 2);
        String rightPart1 = str2.substring(2);

        if (str1.equals(rightPart1 + leftPart1)) {
            return 1;
        }


        return 0;
    }
}
