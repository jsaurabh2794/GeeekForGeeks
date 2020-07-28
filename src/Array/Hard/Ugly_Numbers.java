package Array.Hard;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*Imp*/
public class Ugly_Numbers {
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

    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            long uglyNumber = getTheUglyNumber(n);
            System.out.println(uglyNumber);
        }
    }

    //For 2,3,5 Prime Factor
    private static long getTheUglyNumber(int n) {
        long[] uglyNumbers = new long[n];
        uglyNumbers[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        long primeFactor_2 = 2;
        long primeFactor_3 = 3;
        long primeFactor_5 = 5;
        long nextUglyNumber = 1;
        for (int i = 1; i < n; i++) {
            nextUglyNumber = Math.min(primeFactor_2, Math.min(primeFactor_3, primeFactor_5));
            uglyNumbers[i] = nextUglyNumber;
            if (nextUglyNumber == primeFactor_2) {
                i2++;
                primeFactor_2 = uglyNumbers[i2] * 2;
            }if (nextUglyNumber == primeFactor_3) { // dont use else if otherwise same number will be inserted two times
                i3++;
                primeFactor_3 = uglyNumbers[i3] * 3;
            }if (nextUglyNumber == primeFactor_5) {
                i5++;
                primeFactor_5 = uglyNumbers[i5] * 5;
            }
        }
        return nextUglyNumber;
    }
    /*nLong(n)*/ /*Not Accepted in GFG*/
    private static long getTheUglyNumberV2(int n) {
        long uglyNumber = 1;
        int count = 0;
        HashSet<Long> elements = new HashSet<>();
        PriorityQueue<Long> minPq = new PriorityQueue<>();
        minPq.add(1l);
        while (!minPq.isEmpty()){
            count++;
           long minElement = minPq.poll();
           if (elements.add(minElement * 2)){
               minPq.add(2 * minElement);
           }if (elements.add(minElement * 3)){
               minPq.add(3 * minElement);
           }if (elements.add(minElement * 5)){
               minPq.add(5 * minElement);
           }
           if (count == n){
               return minElement;
           }
        }
        return uglyNumber;
    }

}
