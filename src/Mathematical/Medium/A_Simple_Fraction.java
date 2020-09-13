package Mathematical.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class A_Simple_Fraction {
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
            int n = input.nextInt();
            int d = input.nextInt();
            doSimpleFraction(n, d);
            System.out.println();
        }
    }

    private static void doSimpleFraction(int n, int d) {
        StringBuilder sb = new StringBuilder("");
        StringBuilder afterDecimmal = new StringBuilder("");
        HashMap<Integer, Integer> mods = new HashMap<>(); // Mod start from which position, will place left braces from there
        boolean isInfinite = true;
        int beforeDec = n / d;
        int reminder = n % d;

        int charPos = 0;

        sb.append(beforeDec);
        if (reminder == 0) {
            System.out.print(sb);
            return;
        }
        //130.(769230)
        while (!mods.containsKey(reminder) && reminder != 0) {
            mods.put(reminder, charPos++);
            int newN = reminder * 10;
            if (newN != 0) {
                afterDecimmal.append(newN / d);
            }
            reminder = newN % d;
            if (reminder == 0) {
                isInfinite = false;
            }
        }
        if (isInfinite) {
            int pos = mods.get(reminder);
            String s1 = "." + afterDecimmal.substring(0, pos);
            String s2 = afterDecimmal.substring(pos);
            System.out.print(sb + s1 + "(" + s2 + ")");
        } else {
            System.out.print(sb + "." + afterDecimmal);
        }
    }
}
