package Array.Easy;

import Util.FastReader;

public class Equilibrium_point {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader();
        int testCase = fastReader.nextInt();
        while (testCase-- > 0) {
            int n = fastReader.nextInt();
            Integer[] arr = new Integer[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = fastReader.nextInt();
                sum += arr[i];
            }
            int res = isEquilibriumThere(arr, n, sum);
            System.out.println(res);
        }
    }

    private static int isEquilibriumThere(Integer[] arr, int n, int totalSum) {
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum -= arr[i];
            if (leftSum == totalSum) {
                return i + 1;
            }
            leftSum += arr[i];
        }
        return -1;
    }
}
