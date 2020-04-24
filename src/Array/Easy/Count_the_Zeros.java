package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Count_the_Zeros {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            int n = Integer.parseInt(input.readLine().trim());
            stringArrA = input.readLine().trim().split(" ");
            int[] intArrA = new int[n];
            for (int i = 0; i < n; i++) {
                intArrA[i] = Integer.parseInt(stringArrA[i]);
            }
            int point = getCountOfZero(intArrA, n);
            System.out.println(point);
            testCase--;
        }

        input.close();
    }

    private static int getCountOfZero(int arr[], int n) {
        return getTransitionPointUsingBinarySearch(arr, n, 0, n - 1);
    }

    private static int getTransitionPointUsingBinarySearch(int[] arr, int n, int start, int end) {
        if (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == 0 && ((mid == 0 ) || (mid - 1 >= 0 && arr[mid - 1] == 1))) {
                return (n-mid);
            } else if (arr[mid] == 1){
                return getTransitionPointUsingBinarySearch(arr,n,mid+1,end);
            }else {
                return getTransitionPointUsingBinarySearch(arr,n,start,mid-1);
            }
        }
        return 0;
    }
}
