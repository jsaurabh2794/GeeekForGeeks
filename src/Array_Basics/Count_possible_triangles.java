package Array_Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Count_possible_triangles {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine());
        String[] dataArray;
        while (testCase-- > 0) {
            int noOfElements = Integer.parseInt(input.readLine());
            dataArray = input.readLine().split(" ");
            Long[] dataArrayInteger = new Long[noOfElements];
            for (int i = 0; i < noOfElements; i++) {
                dataArrayInteger[i] = Long.parseLong(dataArray[i]);
            }
            getCountOfPossibleTraingle(dataArrayInteger, noOfElements);
            System.out.println();
        }

    }

    private static void getCountOfPossibleTraingle(Long[] dataArrayInteger, int noOfElements) {
        int count = 0;
        Arrays.sort(dataArrayInteger);
        for (int i = noOfElements - 1; i >= 1; i--) {
            int l = 0;
            int r = i - 1;
             while (r > l) {
                if(dataArrayInteger[r]+dataArrayInteger[l] > dataArrayInteger[i]){
                    count+=r-l;
                    r--;
                }else{
                    l++;
                }
            }


        }
        System.out.print(count);
    }

}
