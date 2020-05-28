package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Triplet_Sum_Array {

    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            String[] secondLine = input.readLine().trim().split("\\s+");
            int N = Integer.parseInt(secondLine[0]);
            int sum = Integer.parseInt(secondLine[1]);
            stringArrA = input.readLine().trim().split("\\s+");
            Integer[] arr = new Integer[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(stringArrA[i]);
            }
            isTripletAvailableWithGivenSum(arr, N, sum);
            System.out.println();
            testCase--;
        }

        input.close();
    }

    private static void isTripletAvailableWithGivenSum(Integer[] dataArray, int noOfElements, int sum) {

        boolean found = false;
        for (int i = 0; i < dataArray.length - 1; i++) {
            HashSet<Integer> previousData = new HashSet<>(); // storing previous traversed data
            int currentSum = sum - dataArray[i];
            for (int j = i + 1; j < dataArray.length; j++) {
                int x = currentSum - dataArray[j];
                if (previousData.contains(x)) { // checking some of both of negation is present in set
                    found = true;
                    break;
                } else {
                    previousData.add(dataArray[j]); // otherwise adding it for future use
                }
            }

        }

        if (found) {
            System.out.print("1");
        } else {
            System.out.print("0");
        }

    }

    public boolean findTriplets(int[] arr, int n, int sum) {
        // sort the elements
        Arrays.sort(arr);

        // traversing the array elements
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1;
            int r = n - 1;
            int x = arr[i];

            // find the two elements which sum upto zero
            // with element at ith index
            while (l < r) {

                // check if the sum is equal to 0
                if (x + arr[l] + arr[r] == sum)
                    return true;
                    // else, if the sum is less than zero
                    // then you need to take greater element
                else if (x + arr[l] + arr[r] < sum)
                    l++;
                    // If the sum is greater than 0
                    // then you need to include some smaller elelment
                    // instead of something greater
                else
                    r--;
            }
        }
        return false;
    }
}