package Mathematical.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Pair_cube_count {
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
        FastReader input = new FastReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            int n = input.nextInt();
            getPairCubeCount(n);
            System.out.println();
        }
    }

    private static void getPairCubeCount(int n) {
        int cubeCount = 0;
        Set<Integer> cubeSet = new HashSet<>();
        int cubeCounter = 1; // Considering as 1
        int cubeRoot = (int) Math.pow(cubeCounter, 3);
        while (cubeRoot <= n) {
            cubeSet.add(cubeRoot);
            cubeCounter++;
            cubeRoot = (int) Math.pow(cubeCounter, 3);
        }
        Iterator<Integer> data = cubeSet.iterator();
        while (data.hasNext()) {
            Integer element = data.next();
            if (cubeSet.contains(n - element) || n == element) { // considering n-data.next as b
                cubeCount++;
            }
        }
        System.out.print(cubeCount);
    }
}
