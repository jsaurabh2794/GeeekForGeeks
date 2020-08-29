package Mathematical.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Finding_Position {
    static class MyReader {
        BufferedReader input = null;
        StringTokenizer st = null;

        public MyReader() {
            input = new BufferedReader(new InputStreamReader(System.in));
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }

        Long nextLong() {
            return Long.parseLong(next());
        }

        String next() {
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

    public static void main(String[] args) {
        MyReader input = new MyReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            findPosition(n);
            System.out.println();
        }
    }
    /*1-> 1
    1 2 -> 2
    1 2 3->2
    1 2 3 4-> 4
    1 2 3 4 5 -> 4
    1 2 3 4 5 6-> 4
    1 2 3 4 5 6 7-> 4
    1 2 3 4 5 6 7 8-> 8
    1 2 3 4 5 6 7 8 9-> 8
    1 2 3 4 5 6 7 8 9 10-> 8
    1 2 3 4 5 6 7 8 9 10 11-> 8
    1 2 3 4 5 6 7 8 9 10 11 12-> 8
    if n ==1; 1

    int intial = 2; example. n= 5
    while (n >= 2*intial){
    intial = intial*2;
    got the pattern from soln
}*/
    private static void findPosition(int n) {
        if (n == 1) {
            System.out.print("1");
            return;
        }
        long strt = 1;
        while (n >= 2 * strt) {
            strt = 2 * strt;
        }
        System.out.print(strt);
    }
}
