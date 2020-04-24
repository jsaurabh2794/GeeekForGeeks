package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Count_pairs_with_given_sum {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            String[] secondLine = input.readLine().trim().split("\\s+");
            int n = Integer.parseInt(secondLine[0]);
            int k = Integer.parseInt(secondLine[1]);
            stringArrA = input.readLine().trim().split("\\s+");
            int[] intArrA = new int[n];
            for (int i = 0; i < n; i++) {
                intArrA[i] = Integer.parseInt(stringArrA[i]);
            }
            int count = getCountWithGivenSum(intArrA, n, k);
            System.out.println(count);
            testCase--;
        }

        input.close();
    }

    // 1 1 1 1
    private static int getCountWithGivenSum(int[] intArrA, int n, int k) {
        int count = 0;
        HashMap<Integer, Integer> countOfElement = new HashMap<>();
        for (int i = 1; i < n; i++) {
            if(countOfElement.containsKey(intArrA[i-1])){
                countOfElement.put(intArrA[i-1], countOfElement.get(intArrA[i-1]) + 1);
            }else{
                countOfElement.put(intArrA[i-1], 1);
            }
            int temp = k - intArrA[i];
            if (countOfElement.containsKey(temp)) {
                count += countOfElement.get(temp);
            }
        }
        return count;
    }
}
