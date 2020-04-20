package Array.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Type_of_array {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] dataArray;
        while (testCase-- > 0) {
            int noOfElements = Integer.parseInt(input.readLine().trim());
            dataArray = input.readLine().trim().split(" ");
            Long[] dataArrayInteger = new Long[dataArray.length];
            for (int i = 0; i < dataArray.length; i++) {
                dataArrayInteger[i] = Long.parseLong(dataArray[i]);
            }
            getTypeOfArrayAndMaxValue(dataArrayInteger, noOfElements);
            System.out.println();
        }
    }

    private static void getTypeOfArrayAndMaxValue(Long[] dataArrayInteger, int noOfElements) {

        Long max = dataArrayInteger[0];
        Long incCount = 0L;
        Long decCount = 0L;
        for (int i = 1; i < noOfElements; i++) {
            if(dataArrayInteger[i] > max){
                max = dataArrayInteger[i];
            }
            if(dataArrayInteger[i] > dataArrayInteger[i-1]){
                incCount++;
            }else{
                decCount++;
            }
        }
        System.out.print(max+" ");
        if(incCount > 0 && decCount == 0){
            System.out.print("1");
        }else if(incCount == 0 && decCount > 0){
            System.out.print("2");
        }else if(incCount > 0 && decCount == 1){
            System.out.print("4");
        }else if(decCount > 0 && incCount == 1){
            System.out.print("3");
        }
    }
}
