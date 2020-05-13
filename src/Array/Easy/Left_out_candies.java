package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Left_out_candies {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            stringArrA = input.readLine().trim().split("\\s+");
            int n = Integer.parseInt(stringArrA[0]);
            int m = Integer.parseInt(stringArrA[1]);
            int leftOutCandies = getLeftOutCandies(n, m);
            System.out.println(leftOutCandies);
            testCase--;
        }

        input.close();
    }

    private static int getLeftOutCandies(int n, int m) {
        int OneRoundCandiesRequired = (n * (n + 1)) / 2;
        if (m - OneRoundCandiesRequired > 0) {
            m = (m % OneRoundCandiesRequired);
        }
        for (int i = 1; i <= n; i++) {
            if (m >= i) {
                m = m - i;
            } else {
                break;
            }
        }
        return m;
    }
}
