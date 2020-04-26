package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class First_negative_integer_in_every_window_of_size_k {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            int n = Integer.parseInt(input.readLine().trim());
            stringArrA = input.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input.readLine().trim());
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(stringArrA[i]);
            }
            printFirstNegativeInteger(arr, n, k);
            System.out.println();
            testCase--;
        }

        input.close();
    }

    private static void printFirstNegativeInteger(Integer[] arr, int n, int k) {
        StringBuffer sb = new StringBuffer();
        LinkedList<Integer> Di = new LinkedList<>();
        int i;
        for (i = 0; i < k; i++) {
            if (arr[i] < 0)
                Di.add(i);
        }
        // -8 2 3 -6 10
        for (; i < n; i++) {
            if (!Di.isEmpty()) {
                sb.append(arr[Di.peek()] + " ");
            } else {
                sb.append("0" + " ");
            }
            while ((!Di.isEmpty()) && Di.peek() < (i - k + 1)) {
                Di.remove();
            }
            if (arr[i] < 0) {
                Di.add(i);
            }
        }

        if (!Di.isEmpty()) {
            sb.append(arr[Di.peek()] + " ");
        } else {
            sb.append("0" + " ");
        }
        System.out.print(sb.toString());
    }
}
