package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Minimum_Energy {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            int n = Integer.parseInt(input.readLine().trim());
            stringArrA = input.readLine().trim().split("\\s+");
            Integer[] intArrA = new Integer[n];
            for (int i = 0; i < n; i++) {
                intArrA[i] = Integer.parseInt(stringArrA[i]);
            }
            int minmEnergy = getMinmEnergy(intArrA, n);
            System.out.println(minmEnergy);
            testCase--;
        }

        input.close();
    }

    private static int getMinmEnergy(Integer[] arrA, int n) {
        int minEnergy = 0;
        boolean flag = false;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arrA[i];
            if (sum <= 0) {
                minEnergy += Math.abs(sum) + 1;
                sum = sum + minEnergy;
                flag = true;
            }
        }
        return flag ? minEnergy : 1;
    }
}
