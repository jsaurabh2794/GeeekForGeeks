package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Count_distinct_elements_in_every_window {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            String[] secondLine = input.readLine().trim().split("\\s+");
            int n = Integer.parseInt(secondLine[0]);
            int k = Integer.parseInt(secondLine[1]);
            stringArrA = input.readLine().trim().split("\\s+");
            Integer[] intArrA = new Integer[n];
            for (int i = 0; i < n; i++) {
                intArrA[i] = Integer.parseInt(stringArrA[i]);
            }
            countDistinct(intArrA, k, n);
            System.out.println();
            testCase--;
        }

        input.close();
    }

    private static void countDistinct(Integer[] intArrA, int k, int n) {
        int deleteCounter = -1;
        int count = 0;
        StringBuffer sb = new StringBuffer();
        HashMap<Integer, Integer> elementCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                sb.append(count + " ");
                deleteCounter++;
                if (elementCount.containsKey(intArrA[deleteCounter])) {
                    int temp = elementCount.get(intArrA[deleteCounter]);
                    if (temp > 1) {
                        elementCount.put(intArrA[deleteCounter], temp - 1);
                    } else {
                        elementCount.remove(intArrA[deleteCounter]);
                        count--;
                    }
                }
            }
            if (elementCount.containsKey(intArrA[i])) {
                int temp = elementCount.get(intArrA[i]);
                elementCount.put(intArrA[i], temp + 1);
            } else {
                elementCount.put(intArrA[i], 1);
                count++;
            }
        }
        sb.append(count + " ");
        System.out.print(sb.toString().trim());
    }
}
