package Array.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Professor_and_Parties {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine().trim());
        String[] dataArray;
        while (testCase-- > 0) {
            int noOfElements = Integer.parseInt(input.readLine().trim());
            dataArray = input.readLine().trim().split(" ");
            Long[] dataArrayInteger = new Long[noOfElements];
            for (int i = 0; i < dataArray.length; i++) {
                dataArrayInteger[i] = Long.parseLong(dataArray[i]);
            }
            getWhoosePartyIsThis(dataArrayInteger, noOfElements);
            System.out.println();
        }
    }

    private static void getWhoosePartyIsThis(Long[] dataArrayInteger, int noOfElements) {
        String party = "GIRLS";
        HashSet<Long> uniqueColor = new HashSet<>();
        for (long l : dataArrayInteger) {
            if (!uniqueColor.contains(l)) {
                uniqueColor.add(l);
            } else {
                party = "BOYS";
                break;
            }
        }
        System.out.print(party);
    }
}
