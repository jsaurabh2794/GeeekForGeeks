package String.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*Imp*/
public class Number_following_a_pattern {
    static class MyReader {
        BufferedReader input;
        StringTokenizer stringTokenizer;

        public MyReader() {
            input = new BufferedReader(new InputStreamReader(System.in));
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                try {
                    stringTokenizer = new StringTokenizer(input.readLine().trim());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }
    }

    public static void main(String[] args) {
        MyReader input = new MyReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            String str = input.next();
            printTheNumberFollowingThePattern(str);
            System.out.println();
        }
    }

    private static void printTheNumberFollowingThePattern(String str) {
        char startingChar = str.charAt(0);
        int latestIndexOfI = 0, nextAvailableMin = 3; // At first it will use 1 and 2 so next min available  is 3.
        ArrayList<Integer> res = new ArrayList<>();
        if (startingChar == 'I') {
            res.add(1);
            res.add(2);
            latestIndexOfI = 1; // one, because for first character adding two numbers
        } else {
            res.add(2);
            res.add(1);
            //D will appear first, then will use 0 as first index for I
        }

        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'I') {
                res.add(nextAvailableMin);
                latestIndexOfI = i + 1;
            } else {
                // if D is there, will pick previous element and add that to in list and increment +1 from lasteindexofI to till I
                res.add(res.get(i)); // it will give previous element because we have already added two element for first character
                for (int j = latestIndexOfI; j <= i; j++) { // LatestIndexOfI means next char after I to till ith element(till one element before current), increase +1
                    res.set(j, res.get(j) + 1);
                }
            }
            nextAvailableMin++;
        }

        // print the Data
        StringBuilder builder = new StringBuilder();
        for (int t : res) {
            builder.append(t);
        }
        System.out.print(builder);
    }
}
