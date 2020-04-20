package Array.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Form_largest_number_from_digits {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArr;
        while (testCase > 0) {
            int noOfElements = Integer.parseInt(input.readLine().trim());
            stringArr = input.readLine().trim().split(" ");
            Integer[] intArr = new Integer[noOfElements];
            for (int i = 0; i < noOfElements; i++) {
                intArr[i] = Integer.parseInt(stringArr[i]);
            }
            formLargeNoFromElements(intArr, noOfElements);
            System.out.println();
            testCase--;
        }

        input.close();
    }

    private static void formLargeNoFromElements(Integer[] intArr, int noOfElements) {
        Arrays.sort(intArr, Collections.reverseOrder());
        StringBuffer s = new StringBuffer("");
        for (int i = 0; i < noOfElements; i++) {
            s.append(intArr[i]);
        }
        System.out.print(s.toString());
    }
}
