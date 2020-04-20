package Array.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Maximize_of_an_Array {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] dataArray;
        while (testCase-- > 0) {
            int noOfElements = Integer.parseInt(input.readLine().trim());
            dataArray = input.readLine().trim().split(" ");
            Long[] dataArrayInteger = new Long[dataArray.length];
            for (int i = 0; i < dataArray.length; i++) {
                dataArrayInteger[i] = Long.parseLong(dataArray[i]);
            }
            maximizeTheArraySumElement(dataArrayInteger, noOfElements);
            System.out.println();
        }
    }

    private static void maximizeTheArraySumElement(Long[] dataArrayInteger, int noOfElements) {
        Arrays.sort(dataArrayInteger);
        long sum = 0L;
        for (int i = 0; i < noOfElements; i++) {
            sum += dataArrayInteger[i] * i;
        }
        System.out.print(sum % (long)(Math.pow(10,9) + 7));
    }
}
