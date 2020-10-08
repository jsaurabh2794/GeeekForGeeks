import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        /*int n = 123456;
        int sum = 0;
        while (n > 0){
            int temp = n % 10;
            n = n / 10;
           if (temp % 2 ==0){
               sum += temp;
           }
        }
        System.out.println(sum);*/

        /*int [] arr = {1,8,6,9,-5,15,10};
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
         for (int t : arr){
             if (first < t){
                 second = first;
                 first = t;
             }else if ( second < t){
                 second = t;
             }
         }
        System.out.println(second);*/
        int arr[] = {1, 2, 5, 8, 9, 10, 15, 16};
        int x = 24;
        HashSet<Integer> numbers = new HashSet<>();
        StringBuilder builder = new StringBuilder("");
         for (int t : arr){
            numbers.add(t);
         }

         for (int t : arr){
             if (numbers.contains(x - t)){
                 numbers.remove(t);
                 builder.append(t+" "+(x - t)+",");
             }
         }


        System.out.println(builder);
    }


}
