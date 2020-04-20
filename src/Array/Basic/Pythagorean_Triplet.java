package Array.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pythagorean_Triplet {
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
            checkIsPythagoreanTriplet(dataArrayInteger, noOfElements);
            System.out.println();
        }
    }

    private static void checkIsPythagoreanTriplet(int[] dataArrayInteger, int noOfElements) {
        String isPythagorean = "No";
        for (int i = 0; i < noOfElements; i++) {
            dataArrayInteger[i] = dataArrayInteger[i] * dataArrayInteger[i];
        }
        Arrays.sort(dataArrayInteger);
        for (int i = noOfElements - 2; i >= 2; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
               if(dataArrayInteger[left] + dataArrayInteger[right] == dataArrayInteger[i])
               {
                   isPythagorean = "Yes";
                   break;
               }else if(dataArrayInteger[left] + dataArrayInteger[right] > dataArrayInteger[i]){
                   right--;
               }else{
                   left++;
               }
            }
            if (isPythagorean.equalsIgnoreCase("Yes")){
                break;
            }
        }
        System.out.print(isPythagorean);
    }
}
