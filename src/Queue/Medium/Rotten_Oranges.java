package Queue.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Rotten_Oranges {
    static boolean ableToRotAtLeastOne = false;

    static class Index {
        int i;
        int j;

        public Index(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int r = input.nextInt();
            int c = input.nextInt();
            int[][] arr = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    arr[i][j] = input.nextInt();
                }
            }
            int uniteTime = getTimeToRottenAllOranges(arr, r, c);
            System.out.println(uniteTime);
        }
    }

    private static int getTimeToRottenAllOranges(int[][] arr, int r, int c) {
        //Insert all Rotten Oranges to Queue
        Queue<Index> indexQueue = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 2) { //Rotten Eggs
                    indexQueue.add(new Index(i, j));
                }
            }
        }
        indexQueue.add(new Index(-1, -1)); // Delimiter, which can Separate  from rotten Oranges in One unit
        int timeUnit = 0;
        while (!indexQueue.isEmpty()) {
            //Process All Rotten Oranges in timeFrame
            ableToRotAtLeastOne = false; // this flag is required to increase timeUnit at once. if its increased at once, we are setting it as false, so timeunit will not increase again in same time frame
            while (!isDelimiter(indexQueue.peek())) { // Execute, untill we reach to delimiter
                Index rottenOrangeIndex = indexQueue.poll();
                int i = rottenOrangeIndex.i;
                int j = rottenOrangeIndex.j;
                if (j - 1 >= 0 && arr[i][j - 1] == 1) { //Left
                    timeUnit = ableToRotAlready(timeUnit);
                    //Make Rotten
                    arr[i][j - 1] = 2;
                    indexQueue.add(new Index(i, j - 1));
                }
                if (j + 1 < c && arr[i][j + 1] == 1) { //right
                    timeUnit = ableToRotAlready(timeUnit);
                    arr[i][j + 1] = 2;
                    indexQueue.add(new Index(i, j + 1));
                }
                if (i - 1 >= 0 && arr[i - 1][j] == 1) { //up
                    timeUnit = ableToRotAlready(timeUnit);
                    arr[i - 1][j] = 2;
                    indexQueue.add(new Index(i - 1, j));
                }
                if (i + 1 < r && arr[i + 1][j] == 1) { //down
                    timeUnit = ableToRotAlready(timeUnit);
                    arr[i + 1][j] = 2;
                    indexQueue.add(new Index(i + 1, j));
                }
            }
            //Remove Delimiter
            indexQueue.poll();

            // if Queue is not Empty then Create Delimiter for Next Time Frame
            if (!indexQueue.isEmpty()) {
                indexQueue.add(new Index(-1, -1));
            }
        }
        return checkAllOranges(arr) ? timeUnit : -1;
    }

    private static boolean checkAllOranges(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) { // if any fresh orange is there, means all are not rotten
                    return false;
                }
            }
        }
        return true;
    }

    private static int ableToRotAlready(int timeUnit) {
        if (!ableToRotAtLeastOne) {
            timeUnit++;
            ableToRotAtLeastOne = true;
        }
        return timeUnit;
    }

    private static boolean isDelimiter(Index index) {
        if (index.i == -1 && index.j == -1) {
            return true;
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