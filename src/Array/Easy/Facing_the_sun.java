package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Facing_the_sun {
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
            int count = getCountOfBuildingWhichIsFacingSunlight(arr, n);
            System.out.println(count);
            testCase--;
        }

        input.close();
    }

    private static int getCountOfBuildingWhichIsFacingSunlight(Integer[] arr, int n) {
        int max = arr[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (max < arr[i]) {
                count++;
                max = arr[i];
            }
        }
        return count;
    }
}
