package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Maximum_average_subarray {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            int K = Integer.parseInt(input.readLine().trim());
            int N = Integer.parseInt(input.readLine().trim());
            stringArrA = input.readLine().trim().split("\\s+");
            Integer[] arr = new Integer[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(stringArrA[i]);
            }
            getMaxmAvgSubArray(arr, N, K);
            System.out.println();
            testCase--;
        }

        input.close();
    }

    private static void getMaxmAvgSubArray(Integer[] arr, int n, int k) {
        Double sumTillKValue = 0.0;
        for (int i = 0; i < k; i++) {
            sumTillKValue += arr[i];
        }
        double maxAvg = sumTillKValue / k;
        int strtPointerOfSubArray = 0;
        int endPointerOfSubArray = k - 1;
        int strtPoint = 0;
        int endPoint = k - 1;
        while (endPoint < n) {
            Double tempAvg = sumTillKValue / k;
            if (maxAvg < tempAvg) {
                maxAvg = tempAvg;
                strtPointerOfSubArray = strtPoint;
                endPointerOfSubArray = endPoint;
            }
            if (endPoint < n - 1) {
                sumTillKValue = sumTillKValue - arr[strtPoint++] + arr[++endPoint];
            } else {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = strtPointerOfSubArray; i <= endPointerOfSubArray; i++) {
            sb.append(arr[i] + " ");
        }
        System.out.print(sb.toString().trim());
    }
}
