package String.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*Imp*/ /*Memoization*/
public class Interleaved_Strings {
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
            String a = input.next();
            String b = input.next();
            String c = input.next();
            boolean res = isInterLeaved(a, b, c, new HashMap<>());
            System.out.println(res ? "1" : "0");
        }
    }

    //if both string have common character, we can not know which character is used from which string
    //AB AC AABC here how will decide first A is came from AB or AC. SO need to check both scenario
    //IF both string does not have common char, then simply can do if else.
    //AB CD ABCD
    //we can use memoization
    private static boolean isInterLeaved(String a, String b, String c, HashMap<String, Boolean> memory) {
        //base case
        if ("".equals(a) && "".equals(b) && "".equals(c)) { // then it will be interleaving
            return true;
        }
        if ("".equals(c)) { // if C is empty, means charters in c is less, so cant form interleaving
            return false;
        }
        String key = a + "|" + b + "|" + "c";
        if (memory.containsKey(key)) {
            return memory.get(key);
        }
        boolean firstString = (!"".equals(a) && a.charAt(0) == c.charAt(0)) && isInterLeaved(a.substring(1), b, c.substring(1),memory);
        boolean secondString = (!"".equals(b) && b.charAt(0) == c.charAt(0)) && isInterLeaved(a, b.substring(1), c.substring(1),memory);

        // if not there in memory, will put there
        boolean result = firstString || secondString;
        memory.put(key, result);
        return result; // will consider any one of them or both for interleaving
    }

}
