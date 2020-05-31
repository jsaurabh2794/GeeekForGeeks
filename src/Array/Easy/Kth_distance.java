package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Kth_distance {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase-- > 0) {
            String[] secondLine = input.readLine().trim().split("\\s+");
            int n = Integer.parseInt(secondLine[1]);
            int k = Integer.parseInt(secondLine[0]);
            stringArrA = input.readLine().trim().split("\\s+");
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(stringArrA[i]);
            }
            String res = isDuplicatesWithinKDistenc(arr, n, k);
            System.out.println(res);
        }

        input.close();
    }

    private static String isDuplicatesWithinKDistenc(Integer[] arr, int n, int k) {
        int l = 0, r = 0;
        HashSet<Integer> set = new HashSet<>();
        while (l < n && r < n) {
            if (r <= k) {
                if (!set.add(arr[r++])) {
                    return "True";
                }
            } else {
                set.remove(arr[l++]);
                if (!set.add(arr[r++])) {
                    return "True";
                }
            }
        }
        return "False";
    }
}
