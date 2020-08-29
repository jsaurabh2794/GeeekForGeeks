package Mathematical.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Angle_between_hour_and_minute_hand {
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
            int h = input.nextInt();
            int m = input.nextInt();
            getAngleBetweenHourAndMinute(h, m);
            System.out.println();
        }
    }

    private static void getAngleBetweenHourAndMinute(int h, int m) {
        // For Hour-> it completes 360 degree in 12 hour -> 1 hr or 60 minute it completes 30 degree ->1 minute it completes 0.5 degree
        //Calculate Hour Angle Degree reference of 12:00

        //For Minute -> 60 Minute it completes 360 deg so in one minute it completes 6 degree
        double hourAngle = (h * 60 + m) * 0.5; // it covers h * 60 + m minute
        double minuteAngle = m * 6;

        double AngleBetween = Math.abs(hourAngle - minuteAngle);
        System.out.print((int) Math.min(360 - AngleBetween, AngleBetween));
    }

}
