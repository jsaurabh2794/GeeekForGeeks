package String.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Permutations_of_a_given_string {
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
            String str = input.next();
            TreeSet<String> permutation = getPermutationOfString(str);
            display(permutation);
            System.out.println();
        }
    }

    private static void display(TreeSet<String> permutation) {
        StringBuilder stringBuilder = new StringBuilder("");
        Iterator<String> iterator = permutation.iterator();
        while (iterator.hasNext()){
            stringBuilder.append(iterator.next()+" ");
        }
        System.out.print(stringBuilder);
    }

    private static TreeSet<String> getPermutationOfString(String str) {
        if (str.length() == 0) {
            TreeSet<String> ts = new TreeSet<String>();
            ts.add("");
            return ts;
        }

        char c = str.charAt(0);
        str = str.substring(1);

        TreeSet<String> treeSet = getPermutationOfString(str);

        TreeSet<String> permutation = new TreeSet<>();
        // will place character c in all place of that String
        Iterator<String> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            String temp = iterator.next();
            for (int i = 0; i <= temp.length(); i++) { // going to zero, beacuse need to consider empty string also. so first time only single character will be there in hashset.
                String newString = temp.substring(0, i) + c + temp.substring(i);

                //will add into treeset, it will sort and keeps unique element
                permutation.add(newString);
            }
        }
        return permutation;
    }
}
