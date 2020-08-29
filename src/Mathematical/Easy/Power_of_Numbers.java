package Mathematical.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
/*Did not understand*/ /*Tough*/
public class Power_of_Numbers {
    static int mod = 1000000007;
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
            long n = input.nextLong();
            long m = reverse(n);
            long ans = modfun(n, m);
            System.out.println(ans%mod);
        }
    }

    private static void powerOfNumbers(long n, long m) {
        BigInteger integer = new BigInteger("1");
        for (int i = 0; i < m; i++) {
            integer = integer.multiply(BigInteger.valueOf(n));
        }
        System.out.print(integer.mod(BigInteger.valueOf(1000000007)));
    }

    // compute pow(n, rev) with mod 1000000007
    static long modfun(long n, long rev)
    {
        // Base cases
        if (rev == 0)
            return 1;
        if (rev == 1)
            return n;

        // If rev is even, y = (n^(rev/2)) * (n^(rev/2));
        long y = 0;
        if (rev % 2 == 0)
        {
            y = modfun(n, rev / 2);
            y = (y * y) % mod;
        }

        // If rev is odd, y = (n^(rev/2)) * (n^(rev/2)) * n;
        /*(m * n) % p =((m % p) * (n % p)) % p

        *((n^(rev/2)) * (n^(rev/2)) * n)%mod = ((n^(rev/2)) * (n^(rev/2))%mod)*(n%mod))%mod
        *=((((n^(rev/2))%mod)*((n^(rev/2))%mod)%mod *(n%mod))%mod
        * */
        else
        {
            y = ( modfun(n, rev/2) % mod );
            y = ( ( (y * y) % mod ) * n ) % mod;
        }

        return y;
    }

    private static long reverse(long n) {
        long res = 0;
        while (n > 0) {
            res = (res * 10) + (n % 10);
            n = n / 10;
        }
        return res;
    }
}
