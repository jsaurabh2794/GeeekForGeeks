package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*Imp*/
public class Tic_Tac_Toe {
    // Wining position
    static int[][] win = {
            {0, 1, 2}, // Check first row.
            {3, 4, 5}, // Check second Row
            {6, 7, 8}, // Check third Row
            {0, 3, 6}, // Check first column
            {1, 4, 7}, // Check second Column
            {2, 5, 8}, // Check third Column
            {0, 4, 8}, // Check first Diagonal
            {2, 4, 6}  // Check second Diagonal
    };

    public static void main(String[] args) throws IOException {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            char[] board = new char[9];
            for (int i = 0; i < 9; i++) {
                board[i] = input.next().charAt(0);
            }
            boolean res = isBoardValid(board);
            System.out.println(res ? "Valid" : "Invalid");
        }
    }

    private static boolean isBoardValid(char[] board) {
        int xCount = 0, oCount = 0;
        for (char c : board) {
            if (c == 'X') {
                xCount++;
            } else if (c == 'O') {
                oCount++;
            }
        }

        // Valid if xCount == oCount or xCount == oCount+1 because x Starts always so xCount will be more or equal
        if (xCount == oCount || xCount == oCount + 1) {
            if (iswin(board, 'O')) {
                // If O wins then X cant win
                if (iswin(board, 'X')) {
                    return false;
                }
                // X starts first, if O wins then that time xCount == oCount with some space character
                return xCount == oCount;
            }

            return !iswin(board, 'X') || xCount == oCount + 1;
            // If O is not winner, and (X is winner or not) it will be valid
        }

        return false;
    }

    private static boolean iswin(char[] board, char c) {
        for (int i = 0; i < 8; i++) {
            if (board[win[i][0]] == c && board[win[i][1]] == c && board[win[i][2]] == c) {
                return true;
            }
        }
        return false;
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
