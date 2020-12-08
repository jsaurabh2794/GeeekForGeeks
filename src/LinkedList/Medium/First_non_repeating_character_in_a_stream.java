package LinkedList.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class First_non_repeating_character_in_a_stream {
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

    public static void main(String[] args) throws IOException {
        MyReader input = new MyReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            char[] arr = input.input.readLine().replaceAll(" ", "").toCharArray();
            getFirstNonRepeatingChar(arr, n);
            System.out.println();
        }
    }

    private static void getFirstNonRepeatingChar(char[] arr, int n) {
        boolean[] isRepeated = new boolean[256];
        List<Character> firstNonRepeatedFromLeft = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i< n; i++){
            char c = arr[i];
            if(!isRepeated[c]){
                firstNonRepeatedFromLeft.add(c);
                isRepeated[c] = true;
            }else{
                if (firstNonRepeatedFromLeft.contains(Character.valueOf(c))){
                    firstNonRepeatedFromLeft.remove(Character.valueOf(c));
                }
            }
            if (firstNonRepeatedFromLeft.size() > 0){
                sb.append(firstNonRepeatedFromLeft.get(0)+" ");
            }else{
                sb.append("-1 ");
            }
        }
        System.out.print(sb);
    }
}
