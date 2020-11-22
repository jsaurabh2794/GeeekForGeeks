package Mathematical.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Add_Binary_Strings {
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

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    public static void main(String[] args) {
        MyReader input = new MyReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            String bin1 = input.next();
            String bin2 = input.next();
            doAddBinaryString(bin1, bin2);
            System.out.println();
        }
    }

    private static void doAddBinaryString(String bin1, String bin2) {
        int i = 0;
        while(i < bin1.length() && bin1.charAt(i) == '0'){
            i++;
        }
        bin1 = bin1.substring(i);
        i = 0;
        while(i < bin2.length() && bin2.charAt(i) == '0'){
            i++;
        }
        bin2 = bin2.substring(i);
        int indexForBin1 = bin1.length() - 1;
        int indexForBin2 = bin2.length() - 1;
        StringBuffer res = new StringBuffer("");
        int carry = 0;
        while (indexForBin1 >= 0 && indexForBin2 >= 0) {
            carry = doSum(res, bin1.charAt(indexForBin1), bin2.charAt(indexForBin2), carry);
            indexForBin1--;
            indexForBin2--;
        }

        while (indexForBin1 >= 0) {
            carry = doSum(res, bin1.charAt(indexForBin1), '0', carry);
            indexForBin1--;
        }
        while (indexForBin2 >= 0) {
            carry = doSum(res, '0', bin2.charAt(indexForBin2), carry);
            indexForBin2--;
        }
        if (carry > 0) {
            res.append(carry);
        }
        System.out.print(res.reverse());
    }

    private static int doSum(StringBuffer res, char a, char b, int carry) {
        int x = Character.getNumericValue(a);
        int y = Character.getNumericValue(b);
        /* Working Code
        if (x == 1 && y == 1) {
            if (carry == 1) {
                res.append("1");
            } else {
                res.append("0");
            }
            carry = 1;
        } else if (x + y > 0) {
            if (carry == 1) {
                res.append("0");
                carry = 1;
            } else {
                res.append(x + y);
                carry = 0;
            }
        } else {
            if (carry == 1) {
                res.append("1");
                carry = 0;
            } else {
                res.append("0");
                carry = 0;
            }
        }*/
        res.append((x + y + carry) % 2);
        return (x + y + carry) / 2;
    }
}
