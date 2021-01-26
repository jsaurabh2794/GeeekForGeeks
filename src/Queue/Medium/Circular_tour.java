package Queue.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Circular_tour {
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

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int testCase = reader.nextInt();
        while (testCase-- > 0) {
            int n = reader.nextInt();
            int[] petrol = new int[n];
            int[] distance = new int[n];
            for (int i = 0; i < n; i++) {
                petrol[i] = reader.nextInt();
            }
            for (int i = 0; i < n; i++) {
                distance[i] = reader.nextInt();
            }
            int no = getPetrolPumpForCircularTour(petrol, distance);
            System.out.println(no);
        }
    }

    private static int getPetrolPumpForCircularTour(int[] petrol, int[] distance) {
        int start = 0, end = 1, petrolAvailableInTruck = petrol[start] - distance[start], length = distance.length;
        while (start != end || petrolAvailableInTruck < 0) {
            while (start != end && petrolAvailableInTruck < 0) { // remove that petrol pump from the tour and keep increasing the starting point of the tour
                petrolAvailableInTruck -= petrol[start] - distance[start];
                start = (start + 1) % length;
                if (start == 0) { // As we have started from zero and keep increasing, if we reach to zero again, menas no possible tour is there.
                    return -1;
                }
            }
            petrolAvailableInTruck += petrol[end] - distance[end];
            end = (end + 1) % length;
        }
        return start;
    }
}
