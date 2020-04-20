package Array.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Count_the_numbers {


    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        while (testCase-- > 0) {
            int noOfElements = Integer.parseInt(input.readLine().trim());
            countTheNumbers(noOfElements);
            System.out.println();
        }
    }

    private static void countTheNumbers(int noOfElements) {
        int count = 0;
        for (int i = 1; i <= noOfElements; i++) {
            if (isValid(i)) {
                count++;
            }
        }
        System.out.print(count);
    }

    private static boolean isValid(int aLong) {
        boolean result = true;
        while (aLong > 0) {
            if (!(aLong % 10 >= 1 && aLong % 10 <= 5)) {
              result = false;
              break;
            }
            aLong = aLong/10;
        }
        return result;
    }
}
