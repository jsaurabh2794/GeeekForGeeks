package Array.Medium;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*Imp*/ /*Own*/
public class Minimum_Platforms {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            ArrayList<Train> trainList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Train t = new Train();
                t.setArrivalTime(input.nextInt());
                t.setTrainNo(i);
                trainList.add(t);
            }
            for (int i = 0; i < n; i++) {
                trainList.get(i).setDepartureTime(input.nextInt());
            }
            getMinimumNoOfPlatformRequired(trainList, n);
            System.out.println();
        }
    }

    private static void getMinimumNoOfPlatformRequired(ArrayList<Train> trainList, int n) {
        //Sort the Trains according to arrival time
        Collections.sort(trainList, new Comparator<Train>() {
            @Override
            public int compare(Train t1, Train t2) {
                return t1.arrivalTime - t2.arrivalTime;
            }
        });
        PriorityQueue<Train> platform = new PriorityQueue<>(new Comparator<Train>() {
            @Override
            public int compare(Train t1, Train t2) {
                return t1.departureTime - t2.departureTime;
            }
        });
        //Add first train to PQ
        platform.add(trainList.get(0));
        for (int i = 1; i < n; i++) {
            Train tempTrain = platform.peek();
            Train nextTrain = trainList.get(i);
            if (tempTrain.departureTime >= nextTrain.arrivalTime) { // Here departure and Arrival is same then also required next train.
                platform.add(nextTrain);
            } else {
                platform.poll();
                platform.add(nextTrain);
            }
        }
        //Size of Pq will be No of Platform Req
        System.out.print(platform.size());
    }

    static class FastReader {
        BufferedReader input;
        StringTokenizer st;

        FastReader() {
            input = new BufferedReader(new InputStreamReader(System.in));
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }

        Long nextLong() {
            return Long.parseLong(next());
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(input.readLine().trim());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    }

    static class Train {
        int arrivalTime;
        int departureTime;
        int trainNo;

        public void setArrivalTime(int arrivalTime) {
            this.arrivalTime = arrivalTime;
        }

        public void setDepartureTime(int departureTime) {
            this.departureTime = departureTime;
        }

        public void setTrainNo(int trainNo) {
            this.trainNo = trainNo;
        }
    }
}