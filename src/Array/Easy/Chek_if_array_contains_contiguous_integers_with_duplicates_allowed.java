package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Chek_if_array_contains_contiguous_integers_with_duplicates_allowed {
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
            String res = checkArrayContainsContiguousIntegers(intArrA, n);
            System.out.println(res);
            testCase--;
        }

        input.close();
    }

    private static String checkArrayContainsContiguousIntegers(Integer[] arrA, int n) {
        String res = "No";
        Set<Integer> elements = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            elements.add(arrA[i]);
        }
        Integer temp = elements.iterator().next();
        int forIncrement = temp;
        int forDecrement = temp - 1;
        /*Continuously Increasing and checking in hashset--whether it is present or not*/
        while (elements.contains(forIncrement)) {
            count++;
            forIncrement++;
        }
        /*Continuously Decreasing and checking in hashset--whether it is present or not*/
        while (elements.contains(forDecrement)) {
            count++;
            forDecrement--;
        }
        if (count == elements.size()) {
            res = "Yes";
        }
        return res;
    }
}
