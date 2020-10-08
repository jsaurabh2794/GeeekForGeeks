package String.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Non_Repeating_Character {
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
            String str = input.next();
            getFirstNonRepeatingCharacter(str);
            System.out.println();
        }
    }

    private static void getFirstNonRepeatingCharacter(String str) {
        LinkedHashMap<Character, Integer> characterMap = new LinkedHashMap();
        for (char c : str.toCharArray()) {
            characterMap.put(c, characterMap.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : characterMap.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.print(entry.getKey());
                return;
            }
        }
        System.out.print("-1");
    }
}
