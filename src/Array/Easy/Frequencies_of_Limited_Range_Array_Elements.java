package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
  /*Given an array A[] of N positive integers which can contain integers
  from 1 to N where elements can be repeated or can be absent from the array.
    Your task is to count frequency of all elements from 1 to N.
    Note: Expected time complexity is O(n) with O(1) extra space.*/

public class Frequencies_of_Limited_Range_Array_Elements {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            int N = Integer.parseInt(input.readLine().trim());
            stringArrA = input.readLine().trim().split("\\s+");
            Integer[] arr = new Integer[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(stringArrA[i]);
            }
            getFrequenciesOfEveryElement(arr, N);
            System.out.println();
            testCase--;
        }

        input.close();
    }

    private static void getFrequenciesOfEveryElement(Integer[] arr, int n) {
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] - 1;
        }

        for (int i = 0; i < n; i++) {
            arr[arr[i] % n] = arr[arr[i] % n] + n;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i] / n + " ");
        }
        System.out.print(sb.toString().trim());

    }
}
