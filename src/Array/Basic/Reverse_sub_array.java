package Array.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverse_sub_array {

    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            int n = Integer.parseInt(input.readLine().trim());
            stringArrA = input.readLine().trim().split(" ");
            String[] secondLine = input.readLine().trim().split(" ");
            int l = Integer.parseInt(secondLine[0]);
            int r = Integer.parseInt(secondLine[1]);
            Long[] intArrA = new Long[n];
            for (int i = 0; i < n; i++) {
                intArrA[i] = Long.parseLong(stringArrA[i]);
            }
            doReverseSubArray(intArrA, n, l - 1, r - 1);
            System.out.println();
            testCase--;
        }

        input.close();
    }

    private static void doReverseSubArray(Long[] intArrA, int n, int l, int r) {
        while (l < r && r < n && l < n) {
            long temp = intArrA[l];
            intArrA[l] = intArrA[r];
            intArrA[r] = temp;
            l++;
            --r;
        }
        StringBuffer s = new StringBuffer("");
        for (int i = 0; i < n; i++) {
            s.append(intArrA[i] + " ");
        }
        System.out.print(s.toString().trim());
    }


}
