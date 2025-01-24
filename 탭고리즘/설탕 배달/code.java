import java.util.Scanner;

public class SugarDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.close();

        int bagCount = 0;

        while (n >= 0) {
            if(n % 5 == 0) {
                bagCount += n / 5;
                System.out.println(bagCount);
                return;
            }
            bagCount++;
            n = n - 3;
        }
        System.out.println(-1);
    }
}
