package Array.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Intersection_of_two_arrays {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        String[] stringArrB;
        while (testCase > 0) {
            String[] secondLine = input.readLine().trim().split(" ");
            int n = Integer.parseInt(secondLine[0]);
            int m = Integer.parseInt(secondLine[1]);
            stringArrA = input.readLine().trim().split(" ");
            stringArrB = input.readLine().trim().split(" ");
            Integer[] intArrA = new Integer[n];
            Integer[] intArrB = new Integer[m];
            for (int i = 0; i < n; i++) {
                intArrA[i] = Integer.parseInt(stringArrA[i]);
            }
            for (int i = 0; i < m; i++) {
                intArrB[i] = Integer.parseInt(stringArrB[i]);
            }
            int count = NumberofElementsInIntersection(intArrA, intArrB, n, m);
            System.out.println(count);
            testCase--;
        }

        input.close();
    }

    private static int NumberofElementsInIntersection(Integer[] a, Integer[] b, int n, int m) {
        int count = 0;
        HashSet<Integer> arrA = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arrA.add(a[i]);
        }
        for (int i = 0; i < m; i++) {
            if(arrA.contains(b[i]))
            {
                count++;
                arrA.remove(b[i]);
            }
        }
        return count;
    }

}
