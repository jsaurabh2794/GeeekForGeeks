package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Remove_all_duplicates_from_a_given_string {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        while (testCase > 0) {
            String str = input.readLine().trim();
            String finalString = removeAllDuplicatesFromString(str);
            System.out.println(finalString);
            testCase--;
        }

        input.close();
    }

    private static String removeAllDuplicatesFromString(String str) {
        LinkedHashSet<Character> characters = new LinkedHashSet<>();
        for (int i = 0; i < str.length(); i++) {
            characters.add(str.charAt(i));
        }
        StringBuffer sb = new StringBuffer();
        Iterator iterator = characters.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
        }
        return sb.toString();
    }
}

