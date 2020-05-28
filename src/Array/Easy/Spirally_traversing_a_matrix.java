package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Spirally_traversing_a_matrix {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            String[] secondLine = input.readLine().trim().split("\\s+");
            int m = Integer.parseInt(secondLine[0]);
            int n = Integer.parseInt(secondLine[1]);
            stringArrA = input.readLine().trim().split("\\s+");
            int stringCounter = 0;
            Integer[][] arr = new Integer[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(stringArrA[stringCounter++]);
                }
            }
            printMatrixInSpiral(arr, m, n);
            System.out.println();
            testCase--;
        }

        input.close();
    }

    /*Imp*/
    private static void printMatrixInSpiral(Integer[][] arr, int m, int n) {
        StringBuilder sb = new StringBuilder();
        int rowCount = 0, colCount = 0;
        while (rowCount < m && colCount < n) {
            // Print Row
            for (int i = colCount; i < n; i++) {
                sb.append(arr[rowCount][i] + " ");
            }
            rowCount++;
            // Print col
            for (int i = rowCount; i < m; i++) {
                sb.append(arr[i][n - 1] + " ");
            }
            n--; // Decreased one Col
            if (rowCount < m) {
                for (int i = n - 1; i >= colCount; i--) {
                    sb.append(arr[m - 1][i] + " ");
                }
                m--;
            }
            if (colCount < n) {
                for (int i = m - 1; i >= rowCount; i--) {
                    sb.append(arr[i][colCount] + " ");
                }
                colCount++;
            }
        }
        System.out.print(sb.toString().trim());
    }
}
