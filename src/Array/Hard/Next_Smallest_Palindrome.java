package Array.Hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*Very Good Algorithm*/ /*Imp*/
public class Next_Smallest_Palindrome {
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
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            getNextSmallestPalindrome(arr, n);
            System.out.println();
        }
    }

    private static void getNextSmallestPalindrome(int[] arr, int n) {
        StringBuilder sb = new StringBuilder();
        if (isAllElements9(arr, n)) {
            sb.append("1 ");
            for (int i = 0; i < n - 1; i++) {
                sb.append("0 ");
            }
            sb.append("1");
        } else {
            generateNextPalindromeUtil(arr, n);
            printArray(arr);
        }
    }

    private static void generateNextPalindromeUtil(int[] arr, int n) {
        //Get the mid index
        int mid = n / 2;
        int l = mid - 1;
        int r = (n % 2 == 0) ? mid : mid + 1;

        boolean isLeftPartSmaller = false;
        while (l >= 0 && arr[l] == arr[r]) { // element is same in both side simple move ahead
            l--;
            r++;
        }

        if (l < 0 || arr[l] < arr[r]) { // l< 0 means, already ppalindrome.then also need to do some operation so, making it as true;
            isLeftPartSmaller = true;
        }
        //copy left to right, if left side is smaller then do update according to carry, if no carry is there then update middle +
        while (l >= 0) {
            arr[r++] = arr[l--];
        }

        // if left part is smaller
        if (isLeftPartSmaller) {
            int carry = 1;
            if (n % 2 == 1) {
                arr[mid] += 1;
                carry = arr[mid] / 10;
                arr[mid] = arr[mid] % 10;
            }
            //Initialize once again the pointer
            l = mid - 1;
            r = (n % 2 == 0) ? mid : mid + 1;

            while (l >= 0 && carry > 0) {
                arr[l] = arr[l] + carry;
                carry = arr[l] / 10;
                arr[l] = arr[l] % 10;
                arr[r] = arr[l];
                r++;
                l--;
            }

        }
    }

    private static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + " ");
        }
        System.out.print(sb);
    }

    private static boolean isAllElements9(int[] arr, int n) {
        boolean res = true;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 9) {
                res = false;
                break;
            }
        }
        return res;
    }
}
