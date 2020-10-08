package String.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Does_robot_moves_circular {

    enum Direction {
        POSITIVE_X, NEGATIVE_X, POSITIVE_Y, NEGATIVE_Y;
    }

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
            boolean b = doesRobotMovesCircular(str);
            System.out.println(b ? "Circular":"Not Circular");
        }
    }

    private static boolean doesRobotMovesCircular(String str) {
        char[] arr = str.toCharArray();
        //Consider, Robot will start from 0,0 with Direction Positive_x
        int Y = 0, X = 0;
        Direction dir = Direction.POSITIVE_X;
        for (char c : arr) {
            if (c == 'L' || c == 'R') {
                dir = getNewDirection(c, dir);
            } else {
                if (dir == Direction.POSITIVE_X) {
                    X++;
                } else if (dir == Direction.POSITIVE_Y) {
                    Y++;
                } else if (dir == Direction.NEGATIVE_X) {
                    X--;
                } else if (dir == Direction.NEGATIVE_Y) {
                    Y--;
                }
            }
        }
       // System.out.println(String.format("X=%s and Y=%s", X, Y));
        return (X==0 && Y==0) ? true:false;
    }

    private static Direction getNewDirection(char c, Direction dir) {
        Direction direction = null;

        if (dir == Direction.POSITIVE_X) {
            direction = (c == 'L') ? Direction.POSITIVE_Y : Direction.NEGATIVE_Y;
        } else if (dir == Direction.POSITIVE_Y) {
            direction = (c == 'L') ? Direction.NEGATIVE_X : Direction.POSITIVE_X;
        } else if (dir == Direction.NEGATIVE_X) {
            direction = (c == 'L') ? Direction.NEGATIVE_Y : Direction.POSITIVE_Y;
        } else if (dir == Direction.NEGATIVE_Y) {
            direction = (c == 'L') ? Direction.POSITIVE_X : Direction.NEGATIVE_X;
        }
        return direction;
    }
}
