package Array_Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Longest_increasing_subarray {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] dataArray;
        while (testCase-- > 0) {
            int noOfElements = Integer.parseInt(input.readLine().trim());
            dataArray = input.readLine().trim().split(" ");
            int[] dataArrayInteger = new int[dataArray.length];
            for (int i = 0; i < dataArray.length; i++) {
                dataArrayInteger[i] = Integer.parseInt(dataArray[i]);
            }
            int len = getLongestSubArrayLength(dataArrayInteger, noOfElements);
            System.out.println(len);
        }
    }

    private static int getLongestSubArrayLength(int[] dataArrayInteger, int noOfElements) {
        int count = 0;
        int currCount = 1;
        for (int i = 0; i < noOfElements - 1; i++) {
            if(dataArrayInteger[i] < dataArrayInteger[i+1]){
                currCount++;
            }else{
                if(count < currCount){
                    count = currCount;
                }
                currCount = 1;
            }
        }
        if(currCount > count){
            count = currCount;
        }
        return count;
    }
}
