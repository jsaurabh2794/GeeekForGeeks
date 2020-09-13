package Mathematical.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*Tough*/ /*Copied*/
public class Check_if_two_lines_intersects {
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

    static class Point {
        long x;
        long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

    }

    static boolean onSegment(Point p, Point q, Point r) {
        if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) &&
                q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y))
            return true;
        /*double pq = Math.sqrt(((q.y - p.y) * (q.y - p.y)) + ((q.x - p.x) * (q.x - p.x)));
        double qr = Math.sqrt(((r.y - q.y) * (r.y - q.y)) + ((r.x - q.x) * (r.x - q.x)));
        double pr = Math.sqrt(((r.y - p.y) * (r.y - p.y)) + ((r.x - p.x) * (r.x - p.x)));

        if (pr == pq + qr) {
            return true;
        } not accepting in gfg*/

        return false;
    }

    static int orientation(Point p, Point q, Point r) {
        // See https://www.geeksforgeeks.org/orientation-3-ordered-points/
        // for details of below formula.
        long val = (q.y - p.y) * (r.x - q.x) -
                (q.x - p.x) * (r.y - q.y);

        if (val == 0) return 0; // colinear

        return (val > 0) ? 1 : 2; // clock or counterclock wise
    }

    // The main function that returns true if line segment 'p1q1'
// and 'p2q2' intersect.
    static boolean doIntersect(Point p1, Point q1, Point p2, Point q2) {
        // Find the four orientations needed for general and
        // special cases
        long o1 = orientation(p1, q1, p2);
        long o2 = orientation(p1, q1, q2);
        long o3 = orientation(p2, q2, p1);
        long o4 = orientation(p2, q2, q1);

        // General case
        if (o1 != o2 && o3 != o4)
            return true;

        // Special Cases
        // p1, q1 and p2 are colinear and p2 lies on segment p1q1
        if (o1 == 0 && onSegment(p1, p2, q1)) return true;

        // p1, q1 and q2 are colinear and q2 lies on segment p1q1
        if (o2 == 0 && onSegment(p1, q2, q1)) return true;

        // p2, q2 and p1 are colinear and p1 lies on segment p2q2
        if (o3 == 0 && onSegment(p2, p1, q2)) return true;

        // p2, q2 and q1 are colinear and q1 lies on segment p2q2
        if (o4 == 0 && onSegment(p2, q1, q2)) return true;

        return false; // Doesn't fall in any of the above cases
    }

    public static void main(String[] args) {
        MyReader input = new MyReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            Point p1 = new Point(input.nextLong(), input.nextLong());
            Point p2 = new Point(input.nextLong(), input.nextLong());
            Point p3 = new Point(input.nextLong(), input.nextLong());
            Point p4 = new Point(input.nextLong(), input.nextLong());
            boolean doIntersect = doIntersect(p1, p2, p3, p4);
            System.out.println(doIntersect ? "1" : "0");
        }
    }
}
