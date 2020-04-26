package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Count_Occurences_of_Anagrams {

    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            StringBuffer text = new StringBuffer();
            StringBuffer word = new StringBuffer();
            text.append(input.readLine().trim());
            word.append(input.readLine().trim());
            int count = getCountOfAnagrams(text, word);
            System.out.println(count);
            testCase--;
        }

        input.close();
    }

    private static int getCountOfAnagrams(StringBuffer text, StringBuffer word) {
        int count = 0;
        for (int i = 0; i < text.length() - word.length() + 1; i++) {
            if (check(text.substring(i, i + word.length()), word)) {
                count++;
            }
        }
        return count;
    }

    private static boolean check(String substring, StringBuffer word) {
        boolean result = true;
        HashMap<Character, Integer> characterCount = new HashMap<>();
        for (char c : substring.toCharArray()) {
            if (characterCount.containsKey(c)) {
                characterCount.put(c, characterCount.get(c) + 1);
            } else {
                characterCount.put(c, 1);
            }
        }
        for (char c : word.toString().toCharArray()) {
            if (characterCount.containsKey(c)) {
                characterCount.put(c, characterCount.get(c) - 1);
                if (characterCount.get(c) == 0) {
                    characterCount.remove(c);
                }
            }
        }
        if (characterCount.size() > 0) {
            result = false;
        }
        return result;
    }
}
