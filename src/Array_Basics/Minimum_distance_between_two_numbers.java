package Array_Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Minimum_distance_between_two_numbers {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine());
        String[] dataArray;
        while (testCase > 0) {
            int noOfElements = Integer.parseInt(input.readLine());
            dataArray = input.readLine().split(" ");
            String[] xAndY = input.readLine().split(" ");
            Long X = Long.parseLong(xAndY[0]);
            Long Y = Long.parseLong(xAndY[1]);
            Long[] dataArrayInteger = new Long[noOfElements];
            for (int i = 0; i < noOfElements; i++) {
                dataArrayInteger[i] = Long.parseLong(dataArray[i]);
            }
            Long distance = findMinmDistanceBetweenXAndY(dataArrayInteger, noOfElements, X, Y);
            System.out.println(distance);
            testCase--;
        }

        input.close();
    }

    private static Long findMinmDistanceBetweenXAndY(Long[] arr, int n, Long x, Long y) {
        int firstOccurance = Integer.MAX_VALUE;
        int secondOccurance = Integer.MAX_VALUE;
        Long minmDistance = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                firstOccurance = i;
            } else if (arr[i] == y) {
                secondOccurance = i;
            }
            if (firstOccurance < Integer.MAX_VALUE && secondOccurance < Integer.MAX_VALUE) {
                if (minmDistance > Math.abs(firstOccurance - secondOccurance)) {
                    minmDistance = (long) Math.abs(firstOccurance - secondOccurance);
                }
            }
        }
        if (minmDistance == Long.MAX_VALUE) {
            minmDistance = -1l;
        }
        return minmDistance;
    }
}
