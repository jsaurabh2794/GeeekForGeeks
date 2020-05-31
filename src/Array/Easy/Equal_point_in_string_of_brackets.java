package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Equal_point_in_string_of_brackets {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        while (testCase-- > 0) {
            String str = input.readLine().trim();
            int inx = getEqualPointOfBrakets(str);
            System.out.println(inx);
        }
    }

    private static int getEqualPointOfBrakets(String str) {
        int l = 0, r = str.length() - 1;
        while (l <= r) {
            if (str.charAt(l) != '(') {
                l++;
            } else if (str.charAt(r) != ')') {
                r--;
            } else {
                l++;
                r--;
            }
        }
        return l;
    }
}
