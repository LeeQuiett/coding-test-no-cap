import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //입력  처리
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = scanner.nextInt();
        }
        scanner.close();

        // 가능한 조합 탐색
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    int currentSum = cards[i] + cards[j] + cards[k];
                    if (currentSum <= m) {
                        maxSum = Math.max(maxSum,currentSum);
                    }
                }
            }
        }

        System.out.println(maxSum);
    }
}
