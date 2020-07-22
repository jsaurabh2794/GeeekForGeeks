package Array.Medium;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*Imp*/
public class Max_absolute_difference {

    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            // getMaximumAbsoluteDifference(arr, n);
            getMaximumAbsoluteDifferenceV2(arr, n);
            System.out.println();
        }
    }

    // For every Element, (Finding Max sum on left and Min Sum on right) or (Finding Min sum on right and Max Sum on left) finding Max form both
    private static void getMaximumAbsoluteDifferenceV2(int[] arr, int n) {
        //Create Four Array
        int[] leftMax = new int[n];
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];
        int[] rightMin = new int[n];
        fillArrays(arr, leftMax, leftMin, rightMax, rightMin, n);
        int maxAbsDifference = Integer.MIN_VALUE, temp;
        for (int i = 0; i < n - 1; i++) {
            temp = Math.max(Math.abs(leftMax[i] - rightMin[i + 1]), Math.abs(leftMin[i] - rightMax[i + 1]));
            maxAbsDifference = Math.max(maxAbsDifference, temp);
        }
        System.out.print(maxAbsDifference);
    }

    private static void fillArrays(int[] arr, int[] leftMax, int[] leftMin, int[] rightMax, int[] rightMin, int n) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, tempMax = 0, tempMin = 0;
        for (int i = 0; i < n; i++) {
            tempMax += arr[i];
            tempMin += arr[i];
            max = Math.max(max, tempMax);
            min = Math.min(min, tempMin);
            leftMax[i] = max;
            leftMin[i] = min;
            if (tempMax < 0) {
                tempMax = 0;
            }
            if (tempMin > 0) {
                tempMin = 0;
            }
        }
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        tempMax = 0;
        tempMin = 0;
        for (int i = n - 1; i >= 0; i--) {
            tempMax += arr[i];
            tempMin += arr[i];
            max = Math.max(max, tempMax);
            min = Math.min(min, tempMin);
            rightMax[i] = max;
            rightMin[i] = min;
            if (tempMax < 0) {
                tempMax = 0;
            }
            if (tempMin > 0) {
                tempMin = 0;
            }
        }
    }

    /*Wrong Approach- Tried to find Max then Min do difference1 && Min then Max and do difference2 and Max(difference1,difference2) */
    private static void getMaximumAbsoluteDifference(int[] arr, int n) {
        // First Calculate Max Sum Sub-array
        int lMax = 0, rMax = 0, lTemp = 0, maxSum = Integer.MIN_VALUE, tempSum = 0;
        for (int i = 0; i < n; i++) {
            tempSum += arr[i];
            if (maxSum < tempSum) {
                maxSum = tempSum;
                lMax = lTemp;
                rMax = i;
            }
            if (tempSum < 0) {
                tempSum = 0;
                lTemp = i + 1;
            }
        }
        // Calculate Min Sub-array form remaining
        int minSum = Integer.MAX_VALUE, tempMinSum = 0;
        for (int i = 0; i < lMax; i++) {
            tempMinSum += arr[i];
            if (minSum > tempMinSum) {
                minSum = tempMinSum;
            }
            if (tempMinSum > 0) {
                tempMinSum = 0;
            }
        }
        tempMinSum = 0;
        for (int i = rMax + 1; i < n; i++) {
            tempMinSum += arr[i];
            if (minSum > tempMinSum) {
                minSum = tempMinSum;
            }
            if (tempMinSum > 0) {
                tempMinSum = 0;
            }
        }
        int first = Math.abs(maxSum - minSum); // Find Max then MIn Sub-Array

        int lMin = 0, rMin = 0, lMinTemp = 0, minSum2 = Integer.MAX_VALUE, tempMinSum2 = 0;
        for (int i = 0; i < n; i++) {
            tempMinSum2 += arr[i];
            if (minSum2 > tempMinSum2) {
                minSum2 = tempMinSum2;
                lMin = lMinTemp;
                rMin = i;
            }
            if (tempMinSum2 > 0) {
                tempMinSum2 = 0;
                lMinTemp = i + 1;
            }
        }
        // Calculate Min Sub-array form remaining
        int maxSum2 = Integer.MIN_VALUE, tempMaxSum2 = 0;
        for (int i = 0; i < lMin; i++) {
            tempMaxSum2 += arr[i];
            if (maxSum2 < tempMaxSum2) {
                maxSum2 = tempMaxSum2;
            }
            if (tempMaxSum2 < 0) {
                tempMaxSum2 = 0;
            }
        }
        tempMaxSum2 = 0;
        for (int i = rMin + 1; i < n; i++) {
            tempMaxSum2 += arr[i];
            if (maxSum2 < tempMaxSum2) {
                maxSum2 = tempMaxSum2;
            }
            if (tempMaxSum2 < 0) {
                tempMaxSum2 = 0;
            }
        }
        int second = Math.abs(maxSum2 - minSum2);
        System.out.println(first);
        System.out.println(second);
        System.out.print(Math.max(first, second));
    }

    static class FastReader {
        BufferedReader input;
        StringTokenizer st;

        FastReader() {
            input = new BufferedReader(new InputStreamReader(System.in));
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }

        private String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(input.readLine().trim());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    }

}
