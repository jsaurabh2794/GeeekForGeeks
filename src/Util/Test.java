package Util;

import java.util.Arrays;
import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        final long f = 1000000000;
        HashSet<Long> s = new HashSet<>();
        HashSet<Long> s3 = new HashSet<>();
        HashSet<Long> s5 = new HashSet<>();
        HashSet<Long> s7 = new HashSet<>();
        long n = 3;
        int i = 1;
        while (n <= f) {
            n = (long) Math.pow(3, i++);
            s.add(n);
            s3.add(n);
        }
        i = 1;
        n = 5;
        while (n <= f) {
            n = (long) Math.pow(5, i++);
            s.add(n);
            s5.add(n);
        }
        i = 1;
        n = 7;
        while (n <= f) {
            n = (long) Math.pow(7, i++);
            s7.add(n);
            s.add(n);
        }
        System.out.println(s3.size());
        System.out.println(Arrays.toString(s3.toArray()));
        System.out.println("-----------------------------");
        System.out.println(s5.size());
        System.out.println(Arrays.toString(s5.toArray()));
        System.out.println("-----------------------------");
        System.out.println(s7.size());
        System.out.println(Arrays.toString(s7.toArray()));
        System.out.println("-----------------------------");
        System.out.println(s.size());
        System.out.println(Arrays.toString(s.toArray()));
    }
}
