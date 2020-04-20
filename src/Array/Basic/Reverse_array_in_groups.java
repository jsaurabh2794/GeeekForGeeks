package Array.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverse_array_in_groups {

    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            String[] secondLine = input.readLine().trim().split(" ");
            int n = Integer.parseInt(secondLine[0]);
            int k = Integer.parseInt(secondLine[1]);
            stringArrA = input.readLine().trim().split(" ");
            Long[] intArrA = new Long[n];
            for (int i = 0; i < n; i++) {
                intArrA[i] = Long.parseLong(stringArrA[i]);
            }
            doReverseArrayInGroup(intArrA, n, k);
            System.out.println();
            testCase--;
        }

        input.close();
    }

    private static void doReverseArrayInGroupVs2(Long[] intArrA, int n, int k) {
        StringBuffer finalString = new StringBuffer("");
        int group = 0;
        StringBuffer tempString = new StringBuffer("");
        for (int i = 0; i < n; i++) {
            if(group < k){
                tempString.insert(0," "+intArrA[i]);
                group++;
            }else{
                finalString.append(tempString.toString());
                tempString.delete(0,tempString.length());
                group = 1;
                tempString.insert(0," "+intArrA[i]);
            }
        }
        finalString.append(tempString.toString());
        System.out.print(finalString.toString().trim());
    }
    private static void doReverseArrayInGroup(Long[] intArrA, int n, int k) {
        for (int i = 0; i < n; i += k) {
            int l = i;
            int r = Math.min(l + k - 1, n - 1);
            while (l < r) {
                long temp = intArrA[l];
                intArrA[l] = intArrA[r];
                intArrA[r] = temp;
                l++;
                r--;
            }
        }
        StringBuffer s = new StringBuffer("");
        for (int i = 0; i < n; i++) {
            s.append(intArrA[i] + " ");
        }
        System.out.print(s.toString());
    }
}
