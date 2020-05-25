package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Nearest_multiple_of_10 {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            String n = input.readLine().trim();
            getNearestMultipleOf10(n);
            System.out.println();
            testCase--;
        }

        input.close();
    }

    //8612455638334947271564617487839781
    private static void getNearestMultipleOf10(String n) {
        BigInteger bigInteger = new BigInteger(n);
        Integer lastDigit = Integer.parseInt(n.substring(n.length() - 1));
        bigInteger = bigInteger.subtract(new BigInteger(String.valueOf(lastDigit)));
        if (lastDigit > 5) {
            bigInteger = bigInteger.add(new BigInteger("10"));
        }
        System.out.print(bigInteger);
    }
}
