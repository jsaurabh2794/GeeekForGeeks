package String.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*Good*/ /*Imp*/
public class Closest_Strings {
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
            int n = input.nextInt();
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(input.next());
            }
            String word1 = input.next();
            String word2 = input.next();
            int min = gwtShortestDistance(list, word1, word2);
            System.out.println(min);
        }
    }

    private static int gwtShortestDistance(ArrayList<String> list, String word1, String word2) {
        int minmDistance = Integer.MAX_VALUE;
        int prev = -1; // it will store previous index of any element
        // i will compare the index with other word index
        if (word1.equals(word2)) {
            return 0;
        }
        // find the first index of any word
        for (int i = 0; i < list.size(); i++) {
            if (word1.equals(list.get(i)) || word2.equals(list.get(i))) {
                prev = i;
                break;
            }
        }
        int i = prev; //will start from here to rest element to compare
        while (i < list.size()) {
            String currentWord = list.get(i);
            if (currentWord.equals(word1) || currentWord.equals(word2)) {
                String prevWord = list.get(prev);
                if (!prevWord.equals(currentWord) && i - prev < minmDistance) { // if prev word is different than current word eg. prev= word1 and current word = word2
                    minmDistance = i - prev;
                }
                prev = i;
            }
            i++;
        }

        return minmDistance;
    }
}
