package Mathematical.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*Imp*/
public class Overlapping_rectangles {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

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
        Final_Destination.MyReader input = new Final_Destination.MyReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            Point l1 = new Point(input.nextInt(), input.nextInt());
            Point r1 = new Point(input.nextInt(), input.nextInt());
            Point l2 = new Point(input.nextInt(), input.nextInt());
            Point r2 = new Point(input.nextInt(), input.nextInt());
            int res = doOverlap(l1, r1, l2, r2);
            System.out.println(res);
        }
    }

    private static int doOverlap(Point l1, Point r1, Point l2, Point r2) {
        //If one rectangle is on left side of other
        if (l1.x >= r2.x || l2.x >= r1.x) {
            return 0;
        }
        //Check If one rectangle is above other
        if (l1.y <= r2.y || l2.y <= r1.y) {
            return 0;
        }
        return 1;
    }
}
