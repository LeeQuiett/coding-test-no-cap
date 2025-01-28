import java.util.Scanner;

public class NumberK {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.close();

        // 이진 탐색 범위
        long left = 1;
        long right = (long) n * n;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = countLessOrEqual(mid, n);

            if (count >= k) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    // mid 이하의 숫자가 몇 개 있는지 계산
    private static long countLessOrEqual(long mid, int n) {
        long count = 0;

        for (int i = 0; i <= n; i++){
            count += Math.min(mid / i, n);// i번째 중에서 mid 이하의 값 개수
        }

        return count;
    }
}
