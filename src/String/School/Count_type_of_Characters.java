package String.School;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Count_type_of_Characters {
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
            countTypeOfCharacters(str);
            System.out.println();
        }
    }

    //Special Characters (32–47 / 58–64 / 91–96 / 123–126)
    //Numbers (48-57)
    //Letters (65–90 / 97–122):Uppercase/LowerCase
    private static void countTypeOfCharacters(String str) {
        int uppercase = 0;
        int lowercase = 0;
        int specialChar = 0;
        int numeric = 0;
        for (int i = 0; i < str.length(); i++) {
            int t = str.charAt(i);
            if (t >= 65 && t <= 90) {
                uppercase++;
            } else if (t >= 97 && t <= 122) {
                lowercase++;
            } else if (t >= 48 && t <= 57) {
                numeric++;
            } else if ((t >= 32 && t <= 47) || (t >= 58 && t <= 64) || (t >= 91 && t <= 96) || (t >= 123 && t <= 126)) {
                specialChar++;
            }
        }
        System.out.println(uppercase);
        System.out.println(lowercase);
        System.out.println(numeric);
        System.out.print(specialChar);
    }
}
