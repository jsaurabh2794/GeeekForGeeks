package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Peak_element {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            int N = Integer.parseInt(input.readLine().trim());
            stringArrA = input.readLine().trim().split("\\s+");
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(stringArrA[i]);
            }
            int index = findPeakElement(arr, N);
            System.out.println(index);
            testCase--;
        }

        input.close();
    }

    private static int findPeakElement(int[] arr, int n) {
        return peakElement(arr, 0, n - 1, n);
    }

    private static int peakElement(int[] arr, int l, int r, int total) {
        if (l <= r) {
            int mid = l + (r - l) / 2;
            if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == total - 1 || arr[mid + 1] <= arr[mid])) {
                return mid;
            } else if (arr[mid] < arr[mid + 1]) {
                return peakElement(arr, mid + 1, r, total);
            } else {
                return peakElement(arr, l, mid - 1, total);
            }
        }
        return 0;
    }
}
