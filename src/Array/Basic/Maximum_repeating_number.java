package Array.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Maximum_repeating_number {
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
            getMaximumRepeatingNumber(dataArrayInteger, n, k);
            System.out.println();
            testCase--;
        }

        input.close();

    }

    private static void getMaximumRepeatingNumber(Integer[] dataArrayInteger, int n, int k) {
        for (int i = 0; i < n; i++) {
            dataArrayInteger[dataArrayInteger[i] % k] += k;
        }
        //Since it is containing more than one value who is repeating same no of time,need to modify again
        for (int i = 0; i < n; i++) {
            dataArrayInteger[i] -= dataArrayInteger[i] % k;
        }
        int max = dataArrayInteger[0];
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (max < dataArrayInteger[i]) {
                max = dataArrayInteger[i];
                index = i;
            }
        }
        System.out.print(index);
    }
}
