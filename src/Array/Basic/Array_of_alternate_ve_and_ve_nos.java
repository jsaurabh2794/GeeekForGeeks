/**
 *
 */
package Array.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author SAURABH SINGH RAJPUT
 *
 */
public class Array_of_alternate_ve_and_ve_nos {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine());
        String[] dataArray1;
        while (testCase > 0) {
            int noOfElements1 = Integer.parseInt(input.readLine());
            dataArray1 = input.readLine().split(" ");
            getPositiveAndNegativeOrder(dataArray1, noOfElements1);
            System.out.println();
            testCase--;
        }

        input.close();
    }

    private static void getPositiveAndNegativeOrder(String[] dataArray1, int noOfElements1) {
        StringBuffer positive = new StringBuffer("");
        StringBuffer negative = new StringBuffer("");
        for (int i = 0; i < noOfElements1; i++) {
            int data = Integer.parseInt(dataArray1[i]);
            if (data < 0) {
                negative.append(data + " ");
            } else {
                positive.append(data + " ");
            }
        }
        String[] positiveArray = positive.toString().split(" ");
        String[] negativeArray = negative.toString().split(" ");
        int strIndex = 0;
        StringBuffer finalString = new StringBuffer("");
        for (int i = 0; i < noOfElements1; i++) {
            if (strIndex < positiveArray.length) {
                finalString.append(positiveArray[strIndex] + " ");
            }
            if (strIndex < negativeArray.length) {
                finalString.append(negativeArray[strIndex] + " ");
            }
            strIndex++;
        }
        System.out.print(finalString.toString().trim());
    }

}
