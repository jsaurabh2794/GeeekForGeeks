package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Three_Great_Candidates {
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
            getThreeCandidates(arr, N);
            System.out.println();
            testCase--;
        }

        input.close();
    }

    private static void getThreeCandidates(Integer[] arr, int n) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE; // if negative contains then it will pick two  smallest -ve value
        int secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = arr[i];
            } else if (arr[i] > secondMax) {
                thirdMax = secondMax;
                secondMax = arr[i];
            } else if (arr[i] > thirdMax) {
                thirdMax = arr[i];
            }


            if (firstMin > arr[i]) {
                secondMin = firstMin;
                firstMin = arr[i];
            } else if (secondMin > arr[i]) {
                secondMin = arr[i];
            }

        }
        System.out.print(Math.max(firstMin * secondMin * firstMax, firstMax * secondMax * thirdMax));
    }
}
