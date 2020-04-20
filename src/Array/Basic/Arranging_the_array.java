package Array.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Arranging_the_array {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] dataArray;
        while (testCase-- > 0) {
            int noOfElements = Integer.parseInt(input.readLine().trim());
            dataArray = input.readLine().trim().split(" ");
            long[] dataArrayInteger = new long[dataArray.length];
            for (int i = 0; i < dataArray.length; i++) {
                dataArrayInteger[i] = Long.parseLong(dataArray[i]);
            }
            doArrangingTheArray(dataArrayInteger, noOfElements);
            System.out.println();
        }
    }

    private static void doArrangingTheArray(long[] dataArrayInteger, int noOfElements) {
        StringBuffer negativevalue = new StringBuffer("");
        StringBuffer positiveValue = new StringBuffer("");
        for (int i = 0; i < noOfElements; i++) {
            if(dataArrayInteger[i] < 0){
                negativevalue.append(dataArrayInteger[i]+" ");
            }else{
                positiveValue.append(dataArrayInteger[i]+" ");
            }
        }
        System.out.print(negativevalue.toString().concat(positiveValue.toString()));
    }
}
