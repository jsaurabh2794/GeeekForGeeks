package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Leaders_in_an_array {
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
            getLeadersInArray(arr, n);
            System.out.println();
            testCase--;
        }

        input.close();
    }

    private static void getLeadersInArray(Integer[] arr, int n) {
        //Always prefer append than insert...because it is faster
        StringBuffer sb = new StringBuffer();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[n - 1]);
        int maxTillNow = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (maxTillNow <= arr[i]) {
                maxTillNow = arr[i];
                list.add(arr[i]);
            }
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i) + " ");
        }
        System.out.print(sb.toString().trim());
    }
}
