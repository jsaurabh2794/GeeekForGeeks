package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Overlapping_Intervals_New {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            ArrayList<pair> pairs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                pairs.add(new pair(input.nextInt(), input.nextInt()));
            }
            ArrayList<pair> p = overlappedInterval(pairs, n);
            System.out.println(p);
        }
    }

    public static ArrayList<pair> overlappedInterval(ArrayList<pair> vec, int n) {
        ArrayList<pair> res = new ArrayList<>();
        Collections.sort(vec, new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                return o1.first != o2.first ? o1.first - o2.first : o1.second - o2.second;
            }
        });
        //Create Stack
        Stack<pair> stack = new Stack<>();
        //Push first Element
        stack.push(vec.get(0));
        for (int i = 1; i < n; i++) {
            pair top = stack.peek();
            pair goIngToEnter = vec.get(i);
            if (top.second < goIngToEnter.first) {
                stack.push(goIngToEnter);
            } else if (top.second < goIngToEnter.second) {
                stack.pop();
                stack.push(new pair(top.first, goIngToEnter.second));
            }
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        Collections.reverse(res);
        return res;
    }

    static class pair {
        int first;
        int second;

        pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return first + " " + second + " ";
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
