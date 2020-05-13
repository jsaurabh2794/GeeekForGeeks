package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Sorted_subsequence_of_size_3 {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            int n = Integer.parseInt(input.readLine().trim());
            stringArrA = input.readLine().trim().split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(Integer.parseInt(stringArrA[i]));
            }
            ArrayList<Integer> res = sortedSequenceOfSizeThree(arr, n);
            System.out.println(Arrays.toString(res.toArray()));
            testCase--;
        }

        input.close();
    }

    /*Imp*/
    private static ArrayList<Integer> sortedSequenceOfSizeThree(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> res = new ArrayList<>();
        //Create Smaller Array of all element
        int[] smaller = new int[n];
        smaller[0] = -1;
        int min = 0;
        for (int i = 1; i < n; i++) {
            if (arr.get(min) >= arr.get(i)) {
                min = i;
                smaller[i] = -1;
            } else {
                smaller[i] = min;
            }
        }
        // Create greater array for every element
        int[] greater = new int[n];
        greater[n - 1] = -1;
        int max = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr.get(max) > arr.get(i)) {
                greater[i] = max;
            } else {
                max = i;
                greater[i] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (smaller[i] != -1 && greater[i] != -1) {
                res.add(arr.get(smaller[i]));
                res.add(arr.get(i));
                res.add(arr.get(greater[i]));
                return res;
            }
        }

        return res;
    }
}
