package Mathematical.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
profit[t][i] will be maximum of –

profit[t][i-1] which represents not doing any transaction on the ith day.
Maximum profit gained by selling on ith day.
In order to sell shares on ith day, we need to purchase it on any one of [0, i – 1] days.
If we buy shares on jth day and sell it on ith day, max profit will be price[i] – price[j] + profit[t-1][j] where j varies from 0 to i-1.
Here profit[t-1][j] is best we could have done with one less transaction till jth day.
* */
/*Toughest to understand optimized version*/ /*Imp*/
public class Maximum_Profit {
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
            int k = input.nextInt();
            int n = input.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            //long sum = getmaximumProfit(arr, n); // As many transaction is allowed.
            long sum = getmaximumProfitInAtmostKTransaction(arr, k, n);
            System.out.println(sum);
        }
    }

    private static long getmaximumProfitInAtmostKTransaction(int[] price, int k, int n) {
        long[][] arrOfProfit = new long[k + 1][n + 1];

        //Having 0th day, profit will be zero.
        for (int i = 0; i < n; i++) {
            arrOfProfit[0][i] = 0;
        }

        //Profit will be zero if we do 0 transaction
        for (int i = 0; i <= k; i++) {
            arrOfProfit[i][0] = 0;
        }

        //Will calculate for remaining
        /*for (int j = 1; j <= k; j++) {
            for (int i = 1; i < n; i++) { // it will go till N, because first day we already computed profit above.
                long Max = Integer.MIN_VALUE;
                for (int l = 0; l < i; l++) {
                    Max = Math.max(Max, (price[i] - price[l]) + arrOfProfit[j - 1][l]); // if we are selling on ith day and buying on any day from 0th to j-1
                }
                arrOfProfit[j][i] = Math.max(arrOfProfit[j][i - 1], Max);
            }
        }*/

        //Optimized version of above block
        //Will calculate for remaining
        for (int j = 1; j <= k; j++) {
            long prevDiff = Integer.MIN_VALUE;
            for (int i = 1; i < n; i++) { // it will go till N, because first day we already computed profit above.
                prevDiff = Math.max(prevDiff, arrOfProfit[j - 1][i - 1] - price[i - 1]); // if we are selling on ith day and buying on any day from 0th to j-1
                arrOfProfit[j][i] = Math.max(arrOfProfit[j][i - 1], price[i] + prevDiff);
            }
        }


        return arrOfProfit[k][n - 1];
    }

    private static long getmaximumProfit(int[] arr, int n) {
        long profit = 0;
        int buy = 0;
        int sell = 0;
        int i = 0;
        for (; i < n; ) {
            while (i + 1 < n && arr[i + 1] <= arr[i]) { //Will go until we get less priced stock
                i++;
            }
            buy = arr[i];
            //will go until we get less price than previous
            while (i + 1 < n && (buy <= arr[i + 1] || arr[i + 1] >= arr[i])) {
                i++;
            }
            sell = arr[i];
            i++;
            profit += sell - buy;
        }
        return profit;
    }
}
