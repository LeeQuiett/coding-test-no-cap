import java.util.Scanner;

public class LatestTrain {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

       int M = sc.nextInt();
       int D = sc.nextInt();
       int Y = sc.nextInt();

       int maxDeparture = -1;

       for (int i = 0; i < M; i++) {
           int departure = sc.nextInt();
           int travelTime = sc.nextInt();
           /*if (D + departure + travelTime <= Y) {
                maxDeparture = Math.max(maxDeparture, departure);
           }*/
           if (departure >= D && D + (departure - D) + travelTime <= Y) {
               maxDeparture = Math.max(maxDeparture, departure);
           }
       }

        System.out.println(maxDeparture);
    }
}
