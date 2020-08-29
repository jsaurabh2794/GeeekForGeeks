package Mathematical.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Multiply_two_polynomials {
    static class MyReader {
        BufferedReader input = null;
        StringTokenizer st = null;

        public MyReader() {
            input = new BufferedReader(new InputStreamReader(System.in));
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }

        Long nextLong() {
            return Long.parseLong(next());
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(input.readLine().trim());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

    }

    public static void main(String[] args) {
        MyReader input = new MyReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int m = input.nextInt();
            int n = input.nextInt();
            int[] arrA = new int[m];
            for (int i = 0; i < m; i++) {
                arrA[i] = input.nextInt();
            }
            int[] arrB = new int[n];
            for (int i = 0; i < n; i++) {
                arrB[i] = input.nextInt();
            }
            doMultiplyTwoPolyNomials(arrA, arrB);
            System.out.println();
        }
    }

    private static void doMultiplyTwoPolyNomials(int[] arrA, int[] arrB) {
        HashMap<Integer, Integer> powerCoefficientMap = new HashMap<>();
        for (int i = 0; i < arrA.length; i++) {
            for (int j = 0; j < arrB.length; j++) {
                int tempMultiplyCoeff = arrA[i] * arrB[j];
                int power = i + j;
                if (powerCoefficientMap.containsKey(power)) {
                    powerCoefficientMap.put(power, powerCoefficientMap.get(power) + tempMultiplyCoeff);
                } else {
                    powerCoefficientMap.put(power, tempMultiplyCoeff);
                }
            }
        }
        StringBuffer sb = new StringBuffer("");
        for (Map.Entry<Integer, Integer> data : powerCoefficientMap.entrySet()) {
            sb.append(data.getValue() + " ");
        }
        System.out.print(sb);
    }
}
