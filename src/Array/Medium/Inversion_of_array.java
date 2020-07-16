package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*Imp*/
//O(n^2) -->Other Method is do simple count for each element which is
// greater than current element and is in left side
public class Inversion_of_array {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextLong();
            }
            long count = getInversionCountOfArray(arr, 0, n - 1);
            System.out.println(count);
        }
    }

    private static long getInversionCountOfArray(long[] arr, int l, int r) {
        long inversionCount = 0;
        if (l < r) {
            int mid = l + (r - l) / 2;
            //Left SubArray
            inversionCount += getInversionCountOfArray(arr, l, mid);
            //Right Subaaray
            inversionCount += getInversionCountOfArray(arr, mid + 1, r);
            //Merge Count
            inversionCount += mergeBothPartAndCount(arr, l, mid, r);

        }
        return inversionCount;
    }

    private static long mergeBothPartAndCount(long[] arr, int l, int mid, int r) {
        // Excluding mid+1 element
        long[] leftArray = Arrays.copyOfRange(arr, l, mid + 1);
        long[] rightArray = Arrays.copyOfRange(arr, mid + 1, r + 1);
        int i = 0, j = 0, k = l;
        long inversionCount = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                //Swap is required
                arr[k++] = rightArray[j++];
                inversionCount += (mid + 1) - (l + i);
            }
        }
        while (i < leftArray.length) {
            arr[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            arr[k++] = rightArray[j++];
        }
        return inversionCount;
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

        Long nextLong() {
            return Long.parseLong(next());
        }

        public String next() {
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
