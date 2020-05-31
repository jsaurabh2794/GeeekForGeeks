package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Pairs_with_difference_k {


    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] stringArrA;
        while (testCase > 0) {
            String[] secondLine = input.readLine().trim().split("\\s+");
            int n = Integer.parseInt(secondLine[0]);
            int givenDiff = Integer.parseInt(secondLine[1]);
            stringArrA = input.readLine().trim().split("\\s+");
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(stringArrA[i]);
            }
            int count = countThePairWithGivenDiff(arr, n, givenDiff);
            System.out.println(count);

        }
        input.close();
    }


    private static int countThePairWithGivenDiff(Integer[] arr, int n, int givenDiff) {
        int countOfPair = 0;
        //Map of Element,Count
        HashMap<Integer, Integer> elementFreq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (elementFreq.containsKey(arr[i] + givenDiff)) {
                countOfPair += elementFreq.get(arr[i] + givenDiff);
            }
            if (elementFreq.containsKey(arr[i] - givenDiff)) {
                countOfPair += elementFreq.get(arr[i] - givenDiff);
            }
            if (elementFreq.containsKey(arr[i])) {
                elementFreq.put(arr[i], elementFreq.get(arr[i]) + 1);
            } else {
                elementFreq.put(arr[i], 1);
            }
        }
        return countOfPair;
    }

}
