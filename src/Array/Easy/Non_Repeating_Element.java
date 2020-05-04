package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Non_Repeating_Element {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            int n = Integer.parseInt(input.readLine().trim());
            stringArrA = input.readLine().trim().split("\\s+");
            Long[] intArrA = new Long[n];
            for (int i = 0; i < n; i++) {
                intArrA[i] = Long.parseLong(stringArrA[i]);
            }
            long firstNonRepeatingElement = getFirstNonRepeatingElement(intArrA, n);
            System.out.println(firstNonRepeatingElement);
            testCase--;
        }

        input.close();
    }

    private static long getFirstNonRepeatingElement(Long[] arr, int n) {
        long element = 0;
        Map<Long, Integer> integerSet = new LinkedHashMap<>();
        for (long l : arr) {
            if (integerSet.containsKey(l)) {
                int tempCount = integerSet.get(l);
                integerSet.put(l, tempCount + 1);
            } else {
                integerSet.put(l, 1);
            }
        }
        for (Map.Entry<Long, Integer> t : integerSet.entrySet()) {
            if (t.getValue() == 1) {
                element = t.getKey();
                break;
            }
        }
        return element;
    }

}
