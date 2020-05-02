package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*Imp*/
public class Sort_an_array_of_0s_1s_and_2s {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            int n = Integer.parseInt(input.readLine().trim());
            stringArrA = input.readLine().trim().split("\\s+");
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(stringArrA[i]);
            }
            sortTheArrayV1(arr, n);
            System.out.println();
            testCase--;
        }

        input.close();
    }

    private static void sortTheArray(Integer[] arr, int n) {
        StringBuffer one = new StringBuffer();
        StringBuffer two = new StringBuffer();
        StringBuffer zero = new StringBuffer();
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zero.append(arr[i] + " ");
            } else if (arr[i] == 1) {
                one.append(arr[i] + " ");
            } else {
                two.append(arr[i] + " ");
            }
        }
        System.out.print(zero.toString() + one.toString() + two.toString().trim());
    }

    private static void sortTheArrayV1(Integer[] a, int n) {
        int low = 0, high = n - 1, mid = 0;
        while (mid <= high) {
            if (a[mid] == 0) {
                int temp = a[low];
                a[low] = a[mid];
                a[mid] = temp;
                low++;
                mid++;
            } else if (a[mid] == 1) {
                mid++;
            } else {
                int temp = a[mid];
                a[mid] = a[high];
                a[high] = temp;
                high--;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
