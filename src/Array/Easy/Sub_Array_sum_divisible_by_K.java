package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Sub_Array_sum_divisible_by_K {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase-- > 0) {
            String[] secondLine = input.readLine().trim().split("\\s+");
            int n = Integer.parseInt(secondLine[0]);
            int k = Integer.parseInt(secondLine[1]);
            stringArrA = input.readLine().trim().split("\\s+");
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(stringArrA[i]);
            }
            int noOfSubArray = getNoOfSubArrayDivisibleByK(arr, n, k);
            System.out.println(noOfSubArray);
        }

        input.close();
    }

    /*Imp*/
    private static int getNoOfSubArrayDivisibleByK(Integer[] arr, int n, int k) {
        int subArrayCount = 0;
        HashMap<Integer, Integer> remainderFreq = new HashMap<>();
        //At First, cumulative sum will be zero.
        // we will update hashmap reminder, freq
        int cumulativeSum = 0;
        remainderFreq.put(cumulativeSum, 1);
        for (int i = 0; i < n; i++) {
            cumulativeSum += arr[i];
            int tempReminder = ((cumulativeSum % k) + k) % k; // if Sum Goes negative then also it will work
            // if it contains same reminder again means between them, reminder were 0, means divisible by k
            if (remainderFreq.containsKey(tempReminder)) {
                int tempFreq = remainderFreq.get(tempReminder);
                subArrayCount += tempFreq;
                // increase freq
                remainderFreq.put(tempReminder, tempFreq + 1);
            } else {
                remainderFreq.put(tempReminder, 1);
            }
        }
        return subArrayCount;
    }
}
