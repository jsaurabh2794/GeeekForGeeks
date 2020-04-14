package Array_Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Missing_number {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] dataArray;
        while (testCase-- > 0) {
            int noOfElements = Integer.parseInt(input.readLine().trim());
            dataArray = input.readLine().trim().split(" ");
            Long[] dataArrayInteger = new Long[noOfElements];
            for (int i = 0; i < dataArray.length; i++) {
                dataArrayInteger[i] = Long.parseLong(dataArray[i]);
            }
            getMissingNumber(dataArrayInteger, noOfElements);
            System.out.println();
        }
    }

    private static void getMissingNumber(Long[] dataArrayInteger, int noOfElements) {
        HashSet<Long> total = new HashSet<Long>();
        for (int i = 1; i <= noOfElements ; i++) {
            total.add((long)i);
        }
        for (int i = 0; i < noOfElements; i++) {
            if(total.contains(dataArrayInteger[i])){
                total.remove(dataArrayInteger[i]);
            }
        }
        System.out.print(total.iterator().next());
    }
}
