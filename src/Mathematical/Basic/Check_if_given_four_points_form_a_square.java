package Mathematical.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Check_if_given_four_points_form_a_square {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
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

    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            Point p1 = new Point(input.nextInt(), input.nextInt());
            Point p2 = new Point(input.nextInt(), input.nextInt());
            Point p3 = new Point(input.nextInt(), input.nextInt());
            Point p4 = new Point(input.nextInt(), input.nextInt());
            boolean res = checkGivenNumbersFormSquareOrNot(p1, p2, p3, p4);
            System.out.println(res ? "1" : "0");
        }
    }

    private static boolean checkGivenNumbersFormSquareOrNot(Point p1, Point p2, Point p3, Point p4) {
        //Calculate All possible difference, if 4 length same(side length) and 2 length same(diagonal length)
        int p1p2 = sqrDistance(p1, p2);
        int p1p3 = sqrDistance(p1, p3);
        int p1p4 = sqrDistance(p1, p4);
        int p2p3 = sqrDistance(p2, p3);
        int p2p4 = sqrDistance(p2, p4);
        int p3p4 = sqrDistance(p3, p4);

        List<Integer> distances = new ArrayList<>();
        distances.add(p1p2);
        distances.add(p1p3);
        distances.add(p1p4);
        distances.add(p2p3);
        distances.add(p2p4);
        distances.add(p3p4);

        Collections.sort(distances);
        int distance1 = distances.get(0), distance2 = distances.get(5);
        int LengthCount1 = 0, LengthCount2 = 0;
        for (int t : distances) {
            if (t == distance1) {
                LengthCount1++;
            } else if (t == distance2) {
                LengthCount2++;
            }
        }
        if ((LengthCount1 == 4 && LengthCount2 == 2) || (LengthCount1 == 2 && LengthCount2 == 4)) {
            return true;
        }

        return false;
    }

    private static int sqrDistance(Point a, Point b) {
        return ((b.x - a.x) * (b.x - a.x)) + ((b.y - a.y) * (b.y - a.y));
    }
}
