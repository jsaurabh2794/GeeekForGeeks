package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;

public class Single_Number {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            int n = Integer.parseInt(input.readLine().trim());
            stringArrA = input.readLine().trim().split(" ");
            int[] intArrA = new int[n];
            for (int i = 0; i < n; i++) {
                intArrA[i] = Integer.parseInt(stringArrA[i]);
            }
            int singleNumber = getSingleNumber(intArrA, n);
            System.out.println(singleNumber);
            testCase--;
        }

        input.close();
    }

    /*XOR Operation O(n) O(1)*/
    private static int getSingleNumber(int[] arrA, int n) {
        int singleNumber = 0;
        for (int a : arrA) {
            singleNumber = singleNumber ^ a;
        }
        return singleNumber;
    }

    /*O(n) && O(n)*/
    private static int getSingleNumberV1(int[] arrA, int n) {
        int singleElement = 0;
        HashSet<Integer> data = new HashSet<>();
        /*The function returns True if the element is not present in
         the HashSet otherwise False if the element is already present in the HashSet.*/
        for (int a : arrA) {
            if (!data.add(a)) {
                data.remove(a);
            }
        }
        Iterator<Integer> iterator = data.iterator();
        if (iterator.hasNext()) {
            singleElement = iterator.next();
        }
        return singleElement;
    }
}
