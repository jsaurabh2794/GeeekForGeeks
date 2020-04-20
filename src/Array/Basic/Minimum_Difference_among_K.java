package Array.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Minimum_Difference_among_K {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine());
        String[] dataArray1;
        while (testCase > 0) {
            String[] secondLine = input.readLine().trim().split(" ");
            int n = Integer.parseInt(secondLine[0]);
            int k = Integer.parseInt(secondLine[1]);
            dataArray1 = input.readLine().split(" ");
            Integer[] dataArrayInteger = new Integer[n];
            for (int i = 0; i < n; i++) {
                dataArrayInteger[i] = Integer.parseInt(dataArray1[i]);
            }
            // need to paas total index not length
            getMimimumDifferenceAmongK(dataArrayInteger, n, k);
            System.out.println();
            testCase--;
        }

        input.close();
    }

    private static void getMimimumDifferenceAmongK(Integer[] dataArrayInteger, int n, int k) {
        int minmDifference = Integer.MAX_VALUE;
        Arrays.sort(dataArrayInteger);
        for (int i = 0; i < n - k; i++) {
            int tempMin = dataArrayInteger[i];
            int tempMax = dataArrayInteger[i + k - 1];
            if ((tempMax - tempMin) < minmDifference) {
                minmDifference = tempMax - tempMin;
            }
        }
        System.out.print(n == k ? dataArrayInteger[n - 1] - dataArrayInteger[0] : minmDifference);
    }
}
