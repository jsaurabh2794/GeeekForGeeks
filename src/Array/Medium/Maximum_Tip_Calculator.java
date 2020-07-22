package Array.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/*Imp*/
public class Maximum_Tip_Calculator {
    public static void main(String[] args) {
        Minimum_Platforms.FastReader input = new Minimum_Platforms.FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            int x = input.nextInt(); //For Rahul
            int y = input.nextInt(); //For Ankit
            ArrayList<Order> orderList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Order o = new Order();
                o.tipForRahul = input.nextInt();
                o.orderNo = i;
                orderList.add(o);
            }
            for (int i = 0; i < n; i++) {
                orderList.get(i).setTipForAnkit(input.nextInt());
            }
            getMaximumTip(orderList, n, x, y);
            System.out.println();
        }
    }

    private static void getMaximumTip(ArrayList<Order> orderList, int n, int x, int y) {
        Collections.sort(orderList, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return Math.abs(o1.tipForRahul - o1.tipForAnkit) - Math.abs(o2.tipForRahul - o2.tipForAnkit); // Sort based on Tip Absolute Difference (Have to Maximize)
            }
        });
        int maxmTip = 0;
        for (int i = n - 1; i >= 0; i--) {
            Order tempOrder = orderList.get(i);
            if (tempOrder.tipForRahul > tempOrder.tipForAnkit) {
                if (x-- > 0) {
                    maxmTip += tempOrder.tipForRahul;
                } else {
                    maxmTip += tempOrder.tipForAnkit;
                }
            } else {
                if (y-- > 0) {
                    maxmTip += tempOrder.tipForAnkit;
                } else {
                    maxmTip += tempOrder.tipForRahul;
                }
            }
        }
        System.out.print(maxmTip);
    }

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

    static class Order {
        int tipForRahul;
        int tipForAnkit;
        int orderNo;

        public void setTipForRahul(int tipForRahul) {
            this.tipForRahul = tipForRahul;
        }

        public void setTipForAnkit(int tipForAnkit) {
            this.tipForAnkit = tipForAnkit;
        }

        public void setOrderNo(int orderNo) {
            this.orderNo = orderNo;
        }

    }
}
