package String.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/*Imp*/ /*By Own*/
public class Match_specific_pattern {
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
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.next();
            }
            String str = input.next();
            findMatchSpeceficPattern(arr, str);
            System.out.println();
        }
    }

    private static ArrayList<String> findMatchSpeceficPattern(String[] arr, String str) {
        ArrayList<String> list = new ArrayList<>();
        String decodedPattern = getDecodedString(str);

        for (String strNew : arr) {
            String decodString = getDecodedString(strNew);
            if (decodString.equals(decodedPattern)) {
                list.add(strNew);
            }
        }

        return list;
    }

    private static String getDecodedString(String str) {
        HashMap<Character, Integer> characterHashSet = new HashMap<>();
        String decodedPattern = "";
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (!characterHashSet.containsKey(temp)) {
                characterHashSet.put(temp, i + 1);
                decodedPattern += (i + 1);
            } else {
                Integer integer = characterHashSet.get(temp);
                decodedPattern += integer;
            }
        }
        characterHashSet.clear();
        return decodedPattern;
    }
}
