package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Addition_of_submatrix {

    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            String[] secondLine = input.readLine().trim().split("\\s+");
            int n = Integer.parseInt(secondLine[0]);
            int m = Integer.parseInt(secondLine[1]);
            stringArrA = input.readLine().trim().split("\\s+");
            String[] thirdLineLine = input.readLine().trim().split("\\s+");
            int x1 = Integer.parseInt(thirdLineLine[0]);
            int y1 = Integer.parseInt(thirdLineLine[1]);
            int x2 = Integer.parseInt(thirdLineLine[2]);
            int y2 = Integer.parseInt(thirdLineLine[3]);
            ArrayList<ArrayList<Integer>> data = new ArrayList<>();
            int c = 0;
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> t = new ArrayList<>();
                for (int j = 0; j < m; j++) {
                    t.add(Integer.parseInt(stringArrA[c++]));
                }
                data.add(t);
            }
            long sum = getAdditionOfSubMatrix(data, x1, y1, x2, y2);
            System.out.println(sum);
            testCase--;
        }

        input.close();
    }

    private static long getAdditionOfSubMatrix(ArrayList<ArrayList<Integer>> data, int x1, int y1, int x2, int y2) {
        long sum = 0l;
        for (int i = x1 - 1; i <= x2 - 1; i++) {
            for (int j = y1 - 1; j <= y2 - 1; j++) {
                sum += data.get(i).get(j);
            }
        }
        return sum;
    }
}
