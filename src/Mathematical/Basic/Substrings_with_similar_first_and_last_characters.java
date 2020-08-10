package Mathematical.Basic;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Substrings_with_similar_first_and_last_characters {
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

    public static void main(String[] args) throws IOException {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            String str = input.input.readLine().trim();
            countSubstringWithSimilarFirstAndLast(str, n);
            System.out.println();
        }
    }

    private static void countSubstringWithSimilarFirstAndLast(String str, int n) {
        HashMap<Character, Integer> charFreq = new HashMap<>();

        int count = n;
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (charFreq.containsKey(c)) {
                charFreq.put(c, charFreq.get(c) + 1);
            } else {
                charFreq.put(c, 1);
            }
        }

        for (Map.Entry<Character, Integer> map : charFreq.entrySet()) {
            if (map.getValue() > 1) {
                int chCount = map.getValue();
                long nc2 = (chCount * (chCount - 1))/2;
                count += nc2;
            }
        }
        System.out.print(count);
    }


}
