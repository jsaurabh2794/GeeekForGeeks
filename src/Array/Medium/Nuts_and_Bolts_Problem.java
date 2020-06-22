package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Nuts_and_Bolts_Problem {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            String[] nuts = new String[n];
            for (int i = 0; i < n; i++) {
                nuts[i] = input.next();
            }
            String[] bolt = new String[n];
            for (int i = 0; i < n; i++) {
                bolt[i] = input.next();
            }
            nutsAndVoltsMapping(nuts, bolt, n);
            System.out.println();
        }
    }

    private static void nutsAndVoltsMapping(String[] nuts, String[] bolts, int n) {
        StringBuilder sb = new StringBuilder();
        String[] nutVoltOrder = "!#$%&*@^~".split("");
        HashSet<String> nutSet = new HashSet<>();
        for (String str : nuts) {
            nutSet.add(str);
        }
        HashSet<String> boltSet = new HashSet<>();
        for (String str : bolts) {
            boltSet.add(str);
        }
        for (String str : nutVoltOrder) {
            if (nutSet.contains(str) && boltSet.contains(str)) {
                sb.append(str + " ");
            }
        }
        System.out.print(sb + "\n" + sb);
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

        public String next() {
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
