package Array.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Word_with_maximum_frequency {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] arr;
        while (testCase-- > 0) {
            arr = input.readLine().trim().split("\\s+");
            wordWithMaximuFrequency(arr);
            System.out.println();
        }

        input.close();
    }

    private static void wordWithMaximuFrequency(String[] arr) {
        LinkedHashMap<String, Integer> stringCount = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (stringCount.containsKey(arr[i])) {
                int tempCount = stringCount.get(arr[i]);
                stringCount.put(arr[i], tempCount + 1);
            } else {
                stringCount.put(arr[i], 1);
            }
        }
        String maxFreqStr = "";
        int count = 0;
        for (Map.Entry<String, Integer> temp : stringCount.entrySet()) {
            if (count < temp.getValue()) {
                count = temp.getValue();
                maxFreqStr = temp.getKey();
            }
        }
        System.out.print(maxFreqStr + " " + count);
    }
}
