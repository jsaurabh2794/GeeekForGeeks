package Array.Medium;

import java.util.Arrays;

public class Shell_Sort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        int n = arr.length;
        //Shell Sort
        for (int interval = n / 2; interval > 0; interval /= 2) {
            for (int i = interval; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= interval && arr[j - interval] > temp; j -= interval) {
                    arr[j] = arr[j - interval];
                }
                arr[j] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
