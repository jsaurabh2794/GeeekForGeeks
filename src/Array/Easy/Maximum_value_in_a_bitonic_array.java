package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Maximum_value_in_a_bitonic_array {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            int n = Integer.parseInt(input.readLine().trim());
            stringArrA = input.readLine().trim().split("\\s+");
            Long[] arr = new Long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(stringArrA[i]);
            }
            long maxElement = getMaxmValueInBitonicArray(arr, 0, n - 1, n);
            System.out.println(maxElement);
            testCase--;
        }

        input.close();
    }

    private static long getMaxmValueInBitonicArray(Long[] arr, int r, int l, int total) {
        if (r <= l) {
            int mid = r + (l - r) / 2;
            if (mid + 1 < total && mid - 1 >= 0 && arr[mid] > arr[mid + 1] && arr[mid - 1] < arr[mid]) {
                return arr[mid];
            } else if ((mid == total - 1 && arr[mid] > arr[mid - 1]) || (mid == 0 && arr[mid] > arr[mid + 1])) {
                return arr[mid];
            } else if (arr[mid] > arr[mid - 1]) {
                return getMaxmValueInBitonicArray(arr, mid + 1, l, total);
            } else {
                return getMaxmValueInBitonicArray(arr, 0, mid - 1, total);
            }
        }
        return 0;
    }
}
