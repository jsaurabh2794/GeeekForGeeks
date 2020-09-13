package Mathematical.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Convex_Hull {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
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
        MyReader input = new MyReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            ArrayList<Point> points = new ArrayList<>();
            int n = input.nextInt();
            for (int i = 1; i <= n; i++) {
                Point p = new Point(input.nextInt(), input.nextInt());
                if (!points.contains(p)) {
                    points.add(p);
                }
            }
            getConvexHull(points, points.size());
            System.out.println();
        }
    }

    private static void getConvexHull(ArrayList<Point> points, int n) {
        //if size is less than 3
        if (n < 3) {
            System.out.print("-1");
            return;
        }

        //Will get left Most Point
        int indexOfLeftMost = 0;
        for (int i = 1; i < n; i++) {
            if (points.get(indexOfLeftMost).x > points.get(i).x) {
                indexOfLeftMost = i;
            }
        }

        ArrayList<Point> result = new ArrayList<>();
        ArrayList<Point> collinear = new ArrayList<>();
        //Will Pick this index as first Point
        int p = indexOfLeftMost, q;
        do {
            result.add(points.get(p));
            collinear.addAll(collinear);
            q = (p + 1) % n;
            for (int i = 0; i < n; i++) {
                int orientation = orientation(points.get(p), points.get(q), points.get(i));
                if (orientation == 2) { // always try to find point which is more outside,that is anticlockwise.
                    q = i;
                    collinear = new ArrayList<>();
                } else if (orientation == 0) { // if collinear
                    int dist = distance(points.get(p), points.get(q), points.get(i));
                    if (dist == 2) { // if point[i] is far
                        collinear.add(points.get(q));
                        q = i;
                    } else {
                        collinear.add(points.get(i)); // else put into collinear list, because its near to p, no need to consider as convex hall, will consider farther point as q
                    }
                }
            }
            p = q; // will start from here, because second point as q is done.
        } while (p != indexOfLeftMost);

        Collections.sort(result, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x - o2.x == 0 ? o1.y - o2.y : o1.x - o2.x;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            Point point = result.get(i);
            sb.append(point.x + " " + point.y);
            if (i < result.size() - 1) {
                sb.append(", ");
            }
        }
        System.out.print(sb);
    }

    private static int orientation(Point a, Point b, Point c) {
        int y1 = a.y - b.y;
        int y2 = a.y - c.y;
        int x1 = a.x - b.x;
        int x2 = a.x - c.x;
        int val = y2 * x1 - y1 * x2;
        if (val == 0) {
            return 0;
        }
        return val > 0 ? 1 : 2; //1-->ClockWise 2-->AntiClockWise
    }

    private static int distance(Point a, Point b, Point c) {
        int y1 = b.y - a.y;
        int y2 = c.y - a.y;
        int x1 = b.x - a.x;
        int x2 = c.x - a.x;
        int ab = y1 * y1 + x1 * x1;
        int ac = y2 * y2 + x2 * x2;

        if (ab == ac) {
            return 0;
        }
        return ab > ac ? 1 : 2;

    }
}
