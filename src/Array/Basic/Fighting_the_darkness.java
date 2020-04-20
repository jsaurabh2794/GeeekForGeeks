package Array.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Fighting_the_darkness {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] dataArray;
        while (testCase-- > 0) {
            int noOfElements = Integer.parseInt(input.readLine().trim());
            dataArray = input.readLine().trim().split(" ");
            long[] dataArrayInteger = new long[dataArray.length];
            for (int i = 0; i < dataArray.length; i++) {
                dataArrayInteger[i] = Long.parseLong(dataArray[i]);
            }
            long maxDaysWithoutDarkness = getMaxNoDaysWithoutDarkness(dataArrayInteger, noOfElements);
            System.out.println(maxDaysWithoutDarkness);
        }
    }

    private static long getMaxNoDaysWithoutDarkness(long[] dataArrayInteger, int noOfElements) {
        long res = 0;
        for (int i = 0; i < noOfElements; i++) {
            if(res < dataArrayInteger[i]){
                res = dataArrayInteger[i];
            }
        }
        return res;
    }
}
