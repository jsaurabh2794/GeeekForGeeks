package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Next_Greater_Even_Number {
    public static void main(String[] args) {
        Star_elements.FastReader input = new Star_elements.FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            String n = input.next();
            printNextGreaterEvenNumber(n);
            //System.out.println();
        }
    }

    private static void printNextGreaterEvenNumber(String n) {
        HashSet<Long> permutation = new HashSet<>();
        long actualNo = Long.parseLong(n);
        getAllPermutationOfGivenData(n, permutation, "");
        Iterator itr = permutation.iterator();
        long nextGreaterEvenNumber = Long.MAX_VALUE;
        while (itr.hasNext()) {
            long temp = (long) itr.next();
            if (temp < nextGreaterEvenNumber && temp > actualNo && temp % 2 == 0) {
                nextGreaterEvenNumber = temp;
            }
        }
        if (nextGreaterEvenNumber == Long.MAX_VALUE) {
            System.out.print("-1");
        } else {
            System.out.print(nextGreaterEvenNumber);
        }
    }

    private static void getAllPermutationOfGivenData(String str, HashSet<Long> permutation, String ans) {
        // If string is empty
        if (str.length() == 0) {
            permutation.add(Long.parseLong(ans));
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            // ith character of str
            char ch = str.charAt(i);

            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            // Recurvise call
            getAllPermutationOfGivenData(ros, permutation, ans + ch);
        }
    }

    static class FastReader {
        BufferedReader input;
        StringTokenizer st;

        FastReader() {
            input = new BufferedReader(new InputStreamReader(System.in));
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }

        Long nextLong() {
            return Long.parseLong(next());
        }

        private String next() {
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
}
